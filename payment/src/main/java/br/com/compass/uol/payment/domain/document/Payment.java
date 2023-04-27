package br.com.compass.uol.payment.domain.document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payment")
@Getter @Setter
@NoArgsConstructor
public class Payment {
    @Id
    private ObjectId orderId;
    private Double totalOrder;
    private String paymentStatus;

    public Payment(ObjectId orderId, Double totalOrder, String paymentStatus) {
        this.orderId = orderId;
        this.totalOrder = totalOrder;
        this.paymentStatus = paymentStatus;
    }

}
