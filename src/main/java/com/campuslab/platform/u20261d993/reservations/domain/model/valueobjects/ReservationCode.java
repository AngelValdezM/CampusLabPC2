package com.campuslab.platform.u20261d993.reservations.domain.model.valueobjects;

public record ReservationCode(String value) {
    public ReservationCode {
        if (value == null || value.isBlank()) {
            throw new IllegalArgumentException("ReservationCode cannot be null or blank");
        }
    }
}
