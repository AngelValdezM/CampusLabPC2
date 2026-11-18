package com.campuslab.platform.u20261d993.reservations.domain.repositories;

import com.campuslab.platform.u20261d993.reservations.domain.model.aggregates.Reservation;

import java.util.Optional;

public interface ReservationRepository {
    Reservation save(Reservation reservation);
    Optional<Reservation> findById(Long id);
    boolean existsbyReservationCode(String reservationCode);
    Optional<Reservation> findByReservationCode(String reservationCode);
    void delete(Reservation reservation);
}
