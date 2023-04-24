package br.com.compass.uol.order.factory.validation;

import br.com.compass.uol.order.domain.dto.request.OrderDtoRequest;
import br.com.compass.uol.order.domain.exception.MessageExceptionNotFound;
import br.com.compass.uol.order.domain.repository.OrderValidator;
import org.springframework.stereotype.Component;

@Component
public class OrderStatusValidator implements OrderValidator {
    @Override
    public void validate(OrderDtoRequest request) {
        throw new MessageExceptionNotFound("Error the order status field needs to be filled");
    }
}
