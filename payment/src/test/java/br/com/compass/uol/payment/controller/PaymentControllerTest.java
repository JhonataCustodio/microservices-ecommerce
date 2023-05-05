package br.com.compass.uol.payment.controller;

import br.com.compass.uol.payment.common.PaymentConstants;
import br.com.compass.uol.payment.domain.document.Payment;
import br.com.compass.uol.payment.domain.dto.PaymentDtoResponse;
import br.com.compass.uol.payment.domain.service.PaymentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PaymentControllerTest {
    @InjectMocks
    private PaymentController paymentController;
    @Mock
    private PaymentService paymentService;

    @Test
    public  void getAll_WithValidData_ReturnsListOfPaymentsDtoResponse(){
        List<Payment> payments = Collections.singletonList(PaymentConstants.PAYMENT);
        when(paymentService.getAll()).thenReturn(PaymentConstants.PAYMENT_DTO_RESPONSE);
        ResponseEntity<List<PaymentDtoResponse>> response = paymentController.getAll();

        assertNotNull(response.getBody());
        assertEquals(HttpStatus.OK, response.getStatusCode());
        assertEquals(1, response.getBody().size());

        PaymentDtoResponse paymentDtoResponse = response.getBody().get(0);
        assertEquals(PaymentConstants.PAYMENT.getOrderId(), paymentDtoResponse.getOrderId());
        assertThat(payments.get(0).getTotalOrder()).isEqualTo(paymentDtoResponse.getTotalOrder());
        assertThat(payments.get(0).getPaymentStatus()).isEqualTo(paymentDtoResponse.getPaymentStatus());

    }
}
