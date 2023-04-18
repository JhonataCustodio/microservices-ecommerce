package br.com.compass.uol.order.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.bson.types.ObjectId;

import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class Items {
    private ObjectId id;
    private String name;
    private String description;
    private LocalDate creationDate;
    private LocalDate expirationDate;
    private Double amount;
}
