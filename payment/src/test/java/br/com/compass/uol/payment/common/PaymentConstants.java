package br.com.compass.uol.payment.common;

import br.com.compass.uol.payment.domain.document.Payment;
import br.com.compass.uol.payment.domain.dto.PaymentDtoResponse;
import org.bson.types.ObjectId;

import java.util.Arrays;
import java.util.List;

public class PaymentConstants {
    static ObjectId orderId = new ObjectId("123456789012345678901234");
    public static final Payment PAYMENT = new Payment(){{
       setOrderId(orderId);
       setTotalOrder(100.8);
       setPaymentStatus("APPROVED");
    }};
    public static final List<PaymentDtoResponse> PAYMENT_DTO_RESPONSE = Arrays.asList(
      new PaymentDtoResponse()  {{
          setOrderId(orderId);
          setTotalOrder(100.8);
          setPaymentStatus("APPROVED");
      }}
    );


}
