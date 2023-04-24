package br.com.compass.uol.payment.domain.document;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "payment")
@Getter @Setter
@AllArgsConstructor
@NoArgsConstructor
public class Payment {
    @Id
    private ObjectId orderId;
    private Double totalOrder;
    private String paymentStatus;
}
