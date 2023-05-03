package br.com.compass.uol.order.domain.dto.request;

import br.com.compass.uol.order.domain.entity.Items;
import br.com.compass.uol.order.domain.enums.OrderStatus;
import br.com.compass.uol.order.domain.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.lang3.builder.EqualsBuilder;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class OrderDtoRequest {
    private String cpf;
    private Items items;
    private Double amount;
    private OrderStatus orderStatus;
    private PaymentStatus paymentStatus;
    public OrderDtoRequest(String cpf, List<Items> items, Double amount, OrderStatus orderStatus, PaymentStatus paymentStatus) {
        this.cpf = cpf;
        this.amount = amount;
        this.orderStatus = orderStatus;
        this.paymentStatus = paymentStatus;
    }
    @Override
    public boolean equals(Object object){
        return EqualsBuilder.reflectionEquals(object, this);
    }
}
