package br.com.compass.uol.order.domain.repository;

import br.com.compass.uol.order.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OrderRepository extends JpaRepository<Order, Integer> {
}
