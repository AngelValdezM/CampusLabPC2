package com.campuslab.platform.u20261d993.reservations.domain.model.aggregates;

import com.campuslab.platform.u20261d993.reservations.domain.model.valueobjects.*;

public class Reservation {
    private Long id;
    private final ReservationCode reservationCode;
    private final LaboratoryId laboratoryId;
    private final ReservationPeriod reservationPeriod;
    private final EquipmentBatch equipmentBatch;
    private final Integer accessLevel;
    private final ReservationStatus status;
    private final String reservationNotes;

    public Reservation(ReservationCode reservationCode, LaboratoryId laboratoryId, ReservationPeriod reservationPeriod, EquipmentBatch equipmentBatch, Integer accessLevel, ReservationStatus status, String reservationNotes) {
        this.reservationCode = reservationCode;
        this.laboratoryId = laboratoryId;
        this.reservationPeriod = reservationPeriod;
        this.equipmentBatch = equipmentBatch;
        this.accessLevel = accessLevel;
        this.status = status;
        this.reservationNotes = reservationNotes;
    }

    public Reservation(Long id, ReservationCode reservationCode, LaboratoryId laboratoryId, ReservationPeriod reservationPeriod, EquipmentBatch equipmentBatch, Integer accessLevel, ReservationStatus status, String reservationNotes) {
        this(reservationCode, laboratoryId, reservationPeriod, equipmentBatch, accessLevel, status, reservationNotes);
        this.id = id;
    }
}
