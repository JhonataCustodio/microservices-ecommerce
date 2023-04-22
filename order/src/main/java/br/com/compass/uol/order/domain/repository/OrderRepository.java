package br.com.compass.uol.order.domain.repository;

import br.com.compass.uol.order.domain.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrderRepository extends JpaRepository<Order, Integer> {
    List<Order> searchByCpf(String cpf);
    List<Order> findAllByOrderByAmountAsc();
}
