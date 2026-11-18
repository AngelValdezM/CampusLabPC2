package com.campuslab.platform.u20261d993.reservations.infrastructure.persistence.jpa.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "reservations")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReservationPersistenceEntity extends com.acme.platform.u202000000.shared.infrastructure.persistence.jpa.entities.AuditableAbstractPersistenceEntity {

    @Convert(converter = reservationCodePersistenceConverter.class)
    @Column(name = "reservationCode", nullable = false, length = 100)
    private String reservationCode;
    @Convert(converter = laboratoryIdPersistenceConverter.class)
    @Column(name = "laboratoryId", nullable = false)
    private Long laboratoryId;
    @Convert(converter = reservationPeriodStartDatePersistenceConverter.class)
    @Column(name = "reservationPeriodStartDate", nullable = false)
    private String reservationPeriodStartDate;
    @Convert(converter = reservationPeriodEndDatePersistenceConverter.class)
    @Column(name = "reservationPeriodEndDate", nullable = false)
    private String reservationPeriodEndDate;
    @Convert(converter = equipmentBatchQuantityPersistenceConverter.class)
    @Column(name = "equipmentBatchQuantity", nullable = false)
    private Integer equipmentBatchQuantity;
    @Convert(converter = equipmentBatchUnitPersistenceConverter.class)
    @Column(name = "equipmentBatchUnit", nullable = false)
    private String equipmentBatchUnit;
    @Convert(converter = accessLevelPersistenceConverter.class)
    @Column(name = "accessLevel", nullable = false)
    private Integer accessLevel;
    @Convert(converter = statusPersistenceConverter.class)
    @Column(name = "status", nullable = false)
    private String status;
    @Convert(converter = reservationNotesPersistenceConverter.class)
    @Column(name = "reservationNotes", nullable = true)
    private String reservationNotes; {
}
