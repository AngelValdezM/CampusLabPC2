package com.campuslab.platform.u20261d993.reservations.infrastructure.persistence.jpa.mappers;

import com.campuslab.platform.u20261d993.reservations.domain.model.aggregates.Reservation;

public class ReservationPersistenceMapper {
    private ReservationPersistenceMapper(){

    }

    public static Reservation toDomain(ReservationEntity entity) {
        if (entity == null) {
            return null;
        }
        return new Reservation(
                entity.getId(),
                new ReservationCode(entity.getReservationCode()),
                new LaboratoryId(entity.getLaboratoryId()),
                new ReservationPeriod(entity.getReservationPeriodStartDate()),
                new ReservationPeriod(entity.getReservationPeriodEndDate()),
                new EquipmentBatchQuantity(entity.getEquipmentBatchQuantity()),
                new EquipmentBatchUnit(entity.getEquipmentBatchUnit()),
                entity.getAccessLevel(),
                new ReservationStatus(entity.getStatus()),
                entity.getReservationNotes()
        );
    }

    public statis ReservationPersistenceEntity toEntity(Reservation reservation) {
        if (reservation == null) {
            return null;
        }
        return new ReservationEntity(
                reservation.getId(),
                reservation.getReservationCode().value(),
                reservation.getLaboratoryId().value(),
                reservation.getReservationPeriodStartDate().value(),
                reservation.getReservationPeriodEndDate().value(),
                reservation.getEquipmentBatchQuantity().value(),
                reservation.getEquipmentBatchUnit().value(),
                reservation.getAccessLevel(),
                reservation.getStatus().value(),
                reservation.getReservationNotes()
        );
    }
}
