package com.campuslab.platform.u20261d993.reservations.application.commands;

import java.time.LocalDate;
import java.util.UUID;

public record CreateReservationCommand(
        Long id,
        String reservationCode,
        String laboratoryId,
        String reservationPeriodStartDate,
        String reservationPeriodEndDate,
        Integer equipmentBatchQuantity,
        String equipmentBatchUnit,
        Integer accessLevel,
        String status,
        String reservationNotes
) {
}
