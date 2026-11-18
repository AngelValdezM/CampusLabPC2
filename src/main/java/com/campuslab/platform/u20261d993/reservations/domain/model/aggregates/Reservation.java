package com.campuslab.platform.u20261d993.reservations.domain.model.aggregates;

import com.campuslab.platform.u20261d993.reservations.domain.model.valueobjects.*;

public class Reservation {
    private Long id;
    private final ReservationCode reservationCode;
    private final LaboratoryId laboratoryId;
    private final ReservationPeriod reservationPeriodStartDate;
    private final ReservationPeriod reservationPeriodEndDate;
    private final EquipmentBatchQuantity equipmentBatchQuantity;
    private final EquipmentBatchUnit equipmentBatchUnit;
    private final Integer accessLevel;
    private final ReservationStatus status;
    private final String reservationNotes;

    public Reservation(ReservationCode reservationCode, LaboratoryId laboratoryId, ReservationPeriod reservationPeriodStartDate, ReservationPeriod reservationPeriodEndDate, EquipmentBatchQuantity equipmentBatchQuantity, EquipmentBatchUnit equipmentBatchUnit, Integer accessLevel, ReservationStatus status, String reservationNotes) {
        this.reservationCode = reservationCode;
        this.laboratoryId = laboratoryId;
        this.reservationPeriodStartDate = reservationPeriodStartDate;
        this.reservationPeriodEndDate = reservationPeriodEndDate;
        this.equipmentBatchQuantity = equipmentBatchQuantity;
        this.equipmentBatchUnit = equipmentBatchUnit;
        this.accessLevel = accessLevel;
        this.status = status;
        this.reservationNotes = reservationNotes;
    }

    public Reservation(Long id, ReservationCode reservationCode, LaboratoryId laboratoryId, ReservationPeriod reservationPeriodStartDate, ReservationPeriod reservationPeriodEndDate, EquipmentBatchQuantity equipmentBatchQuantity, EquipmentBatchUnit equipmentBatchUnit, Integer accessLevel, ReservationStatus status, String reservationNotes) {
        this(reservationCode, laboratoryId, reservationPeriodStartDate, reservationPeriodEndDate, equipmentBatchQuantity, equipmentBatchUnit, accessLevel, status, reservationNotes);
        this.id = id;
    }

}
