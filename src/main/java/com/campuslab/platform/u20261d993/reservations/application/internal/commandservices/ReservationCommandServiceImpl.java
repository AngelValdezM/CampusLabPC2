package com.campuslab.platform.u20261d993.reservations.application.internal.commandservices;

import com.campuslab.platform.u20261d993.reservations.application.commands.CreateReservationCommand;
import com.campuslab.platform.u20261d993.reservations.domain.model.aggregates.Reservation;
import com.campuslab.platform.u20261d993.reservations.domain.repositories.ReservationRepository;
import org.springframework.stereotype.Service;

@Service
public class ReservationCommandServiceImpl {
    private final ReservationRepository reservationRepository;

    public ReservationCommandServiceImpl(ReservationRepository reservationRepository) {
        this.reservationRepository = reservationRepository;
    }

    @Override
    public Reservation handle(CreateReservationCommand command) {
        if (command == null) {
            throw new IllegalArgumentException("Command cannot be null");
        }

        var id = command.id();
        var reservationCode = command.reservationCode();
        var laboratoryId = command.laboratoryId();
        var reservationPeriodStartDate = command.reservationPeriodStartDate();
        var reservationPeriodEndDate = command.reservationPeriodEndDate();
        var equipmentBatchQuantity = command.equipmentBatchQuantity();
        var equipmentBatchUnit = command.equipmentBatchUnit();
        var accessLevel = command.accessLevel();
        var status = command.status();
        var reservationNotes = command.reservationNotes();

        if(reservationRepository.existsbyReservationCode(reservationCode)) {
            throw new IllegalArgumentException("Reservation with code %s already exists".formatted(reservationCode));
        }
        var reservation = new Reservation(id, reservationCode, laboratoryId, reservationPeriodStartDate, reservationPeriodEndDate, equipmentBatchQuantity, equipmentBatchUnit, accessLevel, status, reservationNotes);
        return reservationRepository.save(reservation);
    }
}
