package br.com.compass.uol.order.factory.validation;

import br.com.compass.uol.order.domain.dto.request.OrderDtoRequest;
import br.com.compass.uol.order.domain.repository.OrderValidator;
import org.springframework.stereotype.Component;

@Component
public class DefaultOrderValidator implements OrderValidator {
    @Override
    public void validate(OrderDtoRequest request) {
        // implementação vazia para o caso em que não há necessidade de validação adicional
    }
}
