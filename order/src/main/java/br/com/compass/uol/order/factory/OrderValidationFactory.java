package br.com.compass.uol.order.factory;

import br.com.compass.uol.order.domain.dto.request.OrderDtoRequest;
import br.com.compass.uol.order.domain.enums.OrderStatus;
import br.com.compass.uol.order.domain.enums.PaymentStatus;
import br.com.compass.uol.order.domain.repository.OrderValidator;
import br.com.compass.uol.order.factory.validation.DefaultOrderValidator;
import br.com.compass.uol.order.factory.validation.OrderStatusValidator;
import br.com.compass.uol.order.factory.validation.PaymentStatusValidator;
import org.springframework.stereotype.Component;

import java.util.EnumSet;

@Component
public class OrderValidationFactory {
    public OrderValidator getValidator(OrderDtoRequest request) {
        if(!EnumSet.allOf(OrderStatus.class).contains(request.getOrderStatus())) {
            return new OrderStatusValidator();
        } else if(!EnumSet.allOf(PaymentStatus.class).contains(request.getPaymentStatus())) {
            return new PaymentStatusValidator();
        } else {
            return new DefaultOrderValidator();
        }
    }
}

