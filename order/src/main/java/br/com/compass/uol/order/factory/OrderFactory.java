package br.com.compass.uol.order.factory;

import br.com.compass.uol.order.domain.dto.request.OrderDtoRequest;
import br.com.compass.uol.order.domain.dto.response.OrderDtoResponse;
import br.com.compass.uol.order.domain.entity.Order;
import br.com.compass.uol.order.domain.enums.OrderStatus;
import br.com.compass.uol.order.domain.enums.PaymentStatus;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class OrderFactory {
    @Autowired
    private ModelMapper modelMapper;

    public Order createOrder(OrderDtoRequest request){
        Order order = new Order("cpf", "items", "amount", "orderStatus", "paymentStatus");
        order.setCpf(request.getCpf());
        order.setAmount(request.getAmount());
        order.setOrderStatus(OrderStatus.valueOf(request.getOrderStatus().toString()));
        order.setPaymentStatus(PaymentStatus.valueOf(request.getPaymentStatus().toString()));
        return order;
    }
    public OrderDtoResponse createOrderDtoResponse(Order order) {
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
