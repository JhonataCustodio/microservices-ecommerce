package br.com.compass.uol.payment.controller;

import br.com.compass.uol.payment.domain.dto.PaymentDtoResponse;
import br.com.compass.uol.payment.domain.service.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PaymentController {
    @Autowired
    private PaymentService paymentService;
    @GetMapping("/api/payment")
    public ResponseEntity<List<PaymentDtoResponse>> getAll(){
        List<PaymentDtoResponse> paymentDtoResponse = paymentService.getAll();
        return ResponseEntity.ok(paymentDtoResponse);
    }
}
