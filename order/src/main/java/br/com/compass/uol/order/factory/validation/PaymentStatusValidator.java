package br.com.compass.uol.order.factory.validation;

import br.com.compass.uol.order.domain.dto.request.OrderDtoRequest;
import br.com.compass.uol.order.domain.repository.OrderValidator;
import org.springframework.stereotype.Component;

@Component
public class PaymentStatusValidator implements OrderValidator {
    @Override
    public void validate(OrderDtoRequest request) {
        throw new RuntimeException("Error the payment status field needs to be filled");
    }
}
