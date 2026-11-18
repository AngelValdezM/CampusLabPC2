package com.campuslab.platform.u20261d993.reservations.domain.model.valueobjects;

import java.time.LocalDate;

public record ReservationPeriod(LocalDate startDate, LocalDate endDate) {
    public ReservationPeriod {
        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException("ReservationPeriod dates cannot be null");
        }
        if (endDate.isBefore(startDate)) {
            throw new IllegalArgumentException("ReservationPeriod end date cannot be before start date");
        }
    }
}
