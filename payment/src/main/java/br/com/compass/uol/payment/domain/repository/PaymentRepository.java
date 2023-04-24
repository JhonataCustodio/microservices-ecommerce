package br.com.compass.uol.payment.domain.repository;

import br.com.compass.uol.payment.domain.document.Payment;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface PaymentRepository extends MongoRepository<Payment, ObjectId> {
}
