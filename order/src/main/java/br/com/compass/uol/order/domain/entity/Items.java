package br.com.compass.uol.order.domain.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Table(name = "items")
@Getter @Setter
@NoArgsConstructor
public class Items {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private String description;
    private LocalDate creationDate;
    private LocalDate expirationDate;
    private Double amount;
    @ManyToOne
    @JoinColumn(name = "order_id")
    @JsonBackReference
    private Order order;

    public Items(Integer id, String name, String description, LocalDate creationDate, LocalDate expirationDate, Double amount) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.creationDate = creationDate;
        this.expirationDate = expirationDate;
        this.amount = amount;
    }
}
