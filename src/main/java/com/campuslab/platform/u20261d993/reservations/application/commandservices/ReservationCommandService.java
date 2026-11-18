package com.campuslab.platform.u20261d993.reservations.application.commandservices;

import com.campuslab.platform.u20261d993.reservations.application.commands.CreateReservationCommand;
import com.campuslab.platform.u20261d993.reservations.domain.model.aggregates.Reservation;

public interface ReservationCommandService {
    Reservation handle(CreateReservationCommand command);
}
