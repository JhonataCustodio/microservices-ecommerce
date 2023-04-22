package br.com.compass.uol.order.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum OrderStatus {
    IN_PROGRESS("in_progress"),
    FINISHED("finished"),
    CANCELED("canceled");

    private final String status;

    public static OrderStatus fromString(String status) {
        return valueOf(status.toUpperCase());
    }

}
