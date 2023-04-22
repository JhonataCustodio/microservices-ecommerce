package br.com.compass.uol.order.domain.repository;

import br.com.compass.uol.order.domain.dto.request.OrderDtoRequest;

public interface OrderValidator {
    void validate(OrderDtoRequest request);
}
