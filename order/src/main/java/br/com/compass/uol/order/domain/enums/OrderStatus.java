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

    public static boolean isValid(String status) {
        for (OrderStatus orderStatus : OrderStatus.values()) {
            if (orderStatus.getStatus().equalsIgnoreCase(status)) {
                return true;
            }
        }
        return false;
    }

}
