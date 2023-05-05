package br.com.compass.uol.payment.domain.service;

import br.com.compass.uol.payment.common.PaymentConstants;
import br.com.compass.uol.payment.domain.document.Payment;
import br.com.compass.uol.payment.domain.dto.PaymentDtoResponse;
import br.com.compass.uol.payment.domain.repository.PaymentRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Collections;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
public class PaymentServiceTest {
    @InjectMocks
    private PaymentService paymentService;
    @Mock
    private PaymentRepository paymentRepository;
    @Test
    public void getAll_WithValidData_ReturnsListOfPayments() {
        Payment payment = PaymentConstants.PAYMENT;
        when(paymentRepository.findAll()).thenReturn(Collections.singletonList(payment));
        List<PaymentDtoResponse> result = paymentService.getAll();

        assertThat(result).isNotNull().isNotEmpty();
        assertThat(result.get(0).getOrderId()).isEqualTo(payment.getOrderId());
        assertThat(result.get(0).getTotalOrder()).isEqualTo(payment.getTotalOrder());
        assertThat(result.get(0).getPaymentStatus()).isEqualTo(payment.getPaymentStatus());
    }
}
