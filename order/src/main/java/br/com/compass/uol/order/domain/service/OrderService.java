package br.com.compass.uol.order.domain.service;

import br.com.compass.uol.order.domain.dto.request.OrderDtoRequest;
import br.com.compass.uol.order.domain.dto.response.OrderDtoResponse;
import br.com.compass.uol.order.domain.entity.Items;
import br.com.compass.uol.order.domain.entity.Order;
import br.com.compass.uol.order.domain.enums.OrderStatus;
import br.com.compass.uol.order.domain.enums.PaymentStatus;
import br.com.compass.uol.order.domain.repository.ItemsRepository;
import br.com.compass.uol.order.domain.repository.OrderRepository;
import br.com.compass.uol.order.domain.repository.OrderValidator;
import br.com.compass.uol.order.factory.OrderFactory;
import br.com.compass.uol.order.factory.OrderValidationFactory;
import org.modelmapper.ModelMapper;
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
    @Transactional
    public OrderDtoResponse save(OrderDtoRequest request){
        OrderValidator validator = orderValidationFactory.getValidator(request);
        validator.validate(request);
        Optional<Items> items = itemsRepository.findById(request.getItems().getId());
        List<Items> itemsList = items.map(Collections::singletonList).orElse(Collections.emptyList());
        Order order = orderFactory.createOrder(request);
        order.setItems(itemsList);
        orderRepository.save(order);
        return orderFactory.createOrderDtoResponse(order);
    }
    public List<OrderDtoResponse> getAll() {
        List<Order> orders = orderRepository.findAll();
        return orders.stream()
                .map(order -> modelMapper.map(order, OrderDtoResponse.class))
                .collect(Collectors.toList());
    }
}
