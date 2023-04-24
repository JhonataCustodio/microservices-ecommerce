package br.com.compass.uol.order.factory.validation;

import br.com.compass.uol.order.domain.dto.request.OrderDtoRequest;
import br.com.compass.uol.order.domain.exception.MessageExceptionNotFound;
import br.com.compass.uol.order.domain.repository.OrderValidator;
import org.springframework.stereotype.Component;

@Component
public class DefaultOrderValidator implements OrderValidator {
    @Override
    public void validate(OrderDtoRequest request) {
        throw new MessageExceptionNotFound("Error! The field does not need to be filled");
    }
}
