package br.com.compass.uol.order.domain.dto.response;

import br.com.compass.uol.order.domain.entity.Items;
import br.com.compass.uol.order.domain.enums.OrderStatus;
import br.com.compass.uol.order.domain.enums.PaymentStatus;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.util.List;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class OrderDtoResponse {
    private ObjectId id;
    private String cpf;
    private List<Items> items;
    private Double amount;
    private OrderStatus orderStatus;
    private PaymentStatus paymentStatus;
}
