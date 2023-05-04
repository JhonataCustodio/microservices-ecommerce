package br.com.compass.uol.order.domain.service;

import br.com.compass.uol.order.config.RabbitMQConfig;
import br.com.compass.uol.order.domain.dto.request.OrderDtoRequest;
import br.com.compass.uol.order.domain.dto.response.OrderDtoResponse;
import br.com.compass.uol.order.domain.entity.Items;
import br.com.compass.uol.order.domain.entity.Order;
import br.com.compass.uol.order.domain.enums.OrderStatus;
import br.com.compass.uol.order.domain.enums.PaymentStatus;
import br.com.compass.uol.order.domain.exception.MessageExceptionNotFound;
import br.com.compass.uol.order.domain.repository.ItemsRepository;
import br.com.compass.uol.order.domain.repository.OrderRepository;
import br.com.compass.uol.order.domain.repository.OrderValidator;
import br.com.compass.uol.order.factory.ItemsDtoResponseFactory;
import br.com.compass.uol.order.factory.OrderFactory;
import br.com.compass.uol.order.factory.OrderValidationFactory;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class OrderService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private ItemsRepository itemsRepository;
    @Autowired
    private OrderFactory orderFactory;
    @Autowired
    private OrderValidationFactory orderValidationFactory;
    @Autowired
    private RabbitTemplate template;
    @Transactional
    public OrderDtoResponse save(OrderDtoRequest request){
        OrderValidator validator = orderValidationFactory.getValidator(request);
        if (validator != null) {
            validator.validate(request);
        }
        Optional<Items> items = itemsRepository.findById(request.getItems().getId());
        List<Items> itemsList = items.map(Collections::singletonList).orElse(Collections.emptyList());
        Order order = orderFactory.createOrder(request);
        order.setItems(itemsList);
        orderRepository.save(order);
        template.convertAndSend(RabbitMQConfig.EXCHANGE, RabbitMQConfig.ROUTING_KEY, order);
        return orderFactory.createOrderDtoResponse(order);
    }
    public List<OrderDtoResponse> getAll() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(order -> new OrderDtoResponse(
                        order.getId(),
                        order.getCpf(),
                        ItemsDtoResponseFactory.createFromItems(order.getItems()),
                        order.getAmount(),
                        order.getOrderStatus(),
                        order.getPaymentStatus()
                ))
                .collect(Collectors.toList());
    }

    public List<OrderDtoResponse> getByCpf(String cpf){
        List<Order> orders = orderRepository.searchByCpf(cpf);
        return orders.stream()
                .map(order -> new OrderDtoResponse(
                        order.getId(),
                        order.getCpf(),
                        ItemsDtoResponseFactory.createFromItems(order.getItems()),
                        order.getAmount(),
                        order.getOrderStatus(),
                        order.getPaymentStatus()
                ))
                .collect(Collectors.toList());
    }
    public List<OrderDtoResponse> getByAmount(){
        List<Order> orders = orderRepository.findAllByOrderByAmountAsc();
        return orders.stream()
                .map(order -> new OrderDtoResponse(
                        order.getId(),
                        order.getCpf(),
                        ItemsDtoResponseFactory.createFromItems(order.getItems()),
                        order.getAmount(),
                        order.getOrderStatus(),
                        order.getPaymentStatus()
                ))
                .collect(Collectors.toList());
    }
    public OrderDtoResponse getById(Integer id){
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new MessageExceptionNotFound("Order id not found"));
        OrderDtoResponse orderDtoResponse = new OrderDtoResponse();
        orderDtoResponse.setId(order.getId());
        orderDtoResponse.setCpf(order.getCpf());
        orderDtoResponse.setItems(ItemsDtoResponseFactory.createFromItems(order.getItems()));
        orderDtoResponse.setAmount(order.getAmount());
        orderDtoResponse.setOrderStatus(order.getOrderStatus());
        orderDtoResponse.setPaymentStatus(order.getPaymentStatus());
        return orderDtoResponse;
    }
    public String delete(Integer id){
        Order order = orderRepository.findById(id)
                .orElseThrow(() -> new MessageExceptionNotFound("Order id not found"));
        orderRepository.delete(order);
        return "Order removed";
    }
    public  OrderDtoResponse update(Integer id, OrderDtoRequest request){
        Order order = orderRepository.findById(id)
                .orElseThrow(()-> new MessageExceptionNotFound("Order id not found"));
        OrderValidator validator = orderValidationFactory.getValidator(request);
        if (validator != null) {
            validator.validate(request);
        }
        order.setCpf(request.getCpf());
        order.setItems(order.getItems());
        order.setAmount(request.getAmount());
        order.setOrderStatus(OrderStatus.valueOf(request.getOrderStatus().toString()));
        order.setPaymentStatus(PaymentStatus.valueOf(request.getPaymentStatus().toString()));
        orderRepository.save(order);
        OrderDtoResponse orderDtoResponse = new OrderDtoResponse();
        orderDtoResponse.setId(order.getId());
        orderDtoResponse.setCpf(order.getCpf());
        orderDtoResponse.setItems(ItemsDtoResponseFactory.createFromItems(order.getItems()));
        orderDtoResponse.setAmount(order.getAmount());
        orderDtoResponse.setOrderStatus(order.getOrderStatus());
        orderDtoResponse.setPaymentStatus(order.getPaymentStatus());
        return orderDtoResponse;

    }
}
