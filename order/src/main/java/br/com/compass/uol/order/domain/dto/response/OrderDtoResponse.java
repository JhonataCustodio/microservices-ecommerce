package br.com.compass.uol.order.domain.dto.response;

import br.com.compass.uol.order.domain.entity.Items;
import br.com.compass.uol.order.domain.enums.OrderStatus;
import br.com.compass.uol.order.domain.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
public class OrderDtoResponse {
    private Integer id;
    private String cpf;
    private List<ItemsDtoResponse> items;
    private Double amount;
    private OrderStatus orderStatus;
    private PaymentStatus paymentStatus;

    public OrderDtoResponse(String cpf, List<ItemsDtoResponse> items, Double amount, OrderStatus orderStatus, PaymentStatus paymentStatus) {
        this.cpf = cpf;
        this.items = items;
        this.amount = amount;
        this.orderStatus = orderStatus;
        this.paymentStatus = paymentStatus;
    }

}
