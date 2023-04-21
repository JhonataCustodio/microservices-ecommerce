package br.com.compass.uol.order.domain.repository;

import br.com.compass.uol.order.domain.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemsRepository extends JpaRepository<Items, Integer> {
}
