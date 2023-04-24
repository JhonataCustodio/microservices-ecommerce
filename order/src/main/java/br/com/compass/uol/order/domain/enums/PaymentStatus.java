package br.com.compass.uol.order.domain.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum PaymentStatus {
    PROCESSING("processing"),
    REJECTED("rejected"),
    APPROVED("approved");
    private final String status;

    public static boolean isValid(String status) {
        for (PaymentStatus paymentStatus : PaymentStatus.values()) {
            if (paymentStatus.getStatus().equalsIgnoreCase(status)) {
                return true;
            }
        }
        return false;
    }
}
