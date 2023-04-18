package br.com.compass.uol.order.domain.dto.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import java.time.LocalDate;

@Getter @Setter
@NoArgsConstructor
@AllArgsConstructor
public class ItemsDtoRequest {
    private String name;
    private String description;
    private LocalDate creationDate;
    private LocalDate expirationDate;
    private Double amount;
}
