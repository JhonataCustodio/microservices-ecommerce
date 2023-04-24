package br.com.compass.uol.payment.domain.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDtoResponse {
    private ObjectId orderId;
    private Double totalOrder;
    private String paymentStatus;
}
