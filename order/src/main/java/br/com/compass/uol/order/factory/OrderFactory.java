package br.com.compass.uol.order.factory;

import br.com.compass.uol.order.domain.dto.request.OrderDtoRequest;
import br.com.compass.uol.order.domain.dto.response.OrderDtoResponse;
import br.com.compass.uol.order.domain.entity.Items;
import br.com.compass.uol.order.domain.entity.Order;
import br.com.compass.uol.order.domain.enums.OrderStatus;
import br.com.compass.uol.order.domain.enums.PaymentStatus;
import br.com.compass.uol.order.domain.repository.OrderRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class OrderFactory {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private OrderRepository orderRepository;
    public Order createOrder(OrderDtoRequest request){
        Order order = new Order();
        order.setCpf(request.getCpf());
        order.setAmount(request.getAmount());
        order.setOrderStatus(OrderStatus.valueOf(request.getOrderStatus().toString()));
        order.setPaymentStatus(PaymentStatus.valueOf(request.getPaymentStatus().toString()));
        return order;
    }
    public OrderDtoResponse createOrderDtoResponse(Order order){
        OrderDtoResponse orderDtoResponse = modelMapper.map(order, OrderDtoResponse.class);
        return orderDtoResponse;
    }
}
