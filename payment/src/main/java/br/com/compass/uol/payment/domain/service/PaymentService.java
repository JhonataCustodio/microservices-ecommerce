package br.com.compass.uol.payment.domain.service;

import br.com.compass.uol.payment.config.RabbitMQConfig;
import br.com.compass.uol.payment.domain.document.Payment;
import br.com.compass.uol.payment.domain.dto.PaymentDtoRequest;
import br.com.compass.uol.payment.domain.dto.PaymentDtoResponse;
import br.com.compass.uol.payment.domain.repository.PaymentRepository;
import org.modelmapper.ModelMapper;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
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
        return payments.stream()
                .map(payment -> new PaymentDtoResponse(
                        payment.getOrderId(),
                        payment.getTotalOrder(),
                        payment.getPaymentStatus()
                )).collect(Collectors.toList());
    }
    @RabbitListener(queues = RabbitMQConfig.QUEUE)
    public void receiveMessage(PaymentDtoRequest request) {
        Payment payment = new Payment();
        payment.setTotalOrder(request.getAmount());
        payment.setPaymentStatus("APPROVED");
        paymentRepository.save(payment);
    }
}
