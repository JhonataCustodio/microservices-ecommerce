package br.com.compass.uol.payment.domain.service;

import br.com.compass.uol.payment.domain.document.Payment;
import br.com.compass.uol.payment.domain.dto.PaymentDtoResponse;
import br.com.compass.uol.payment.domain.repository.PaymentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PaymentService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private PaymentRepository paymentRepository;
    public List<PaymentDtoResponse> getAll(){
        List<Payment> payments = paymentRepository.findAll();
        List<PaymentDtoResponse> paymentDtoResponses = payments.stream()
                .map(payment -> modelMapper.map(payment, PaymentDtoResponse.class)).collect(Collectors.toList());
        return  paymentDtoResponses;
    }
}
