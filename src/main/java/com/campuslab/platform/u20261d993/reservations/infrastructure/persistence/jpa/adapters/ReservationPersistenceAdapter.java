package com.campuslab.platform.u20261d993.reservations.infrastructure.persistence.jpa.adapters;

import com.campuslab.platform.u20261d993.reservations.domain.model.aggregates.Reservation;
import com.campuslab.platform.u20261d993.reservations.domain.repositories.ReservationRepository;
import org.springframework.stereotype.Repository;

@Repository
public class ReservationPersistenceAdapter implements ReservationRepository {
    private final ReservationJpaRepository reservationJpaRepository;

    public ReservationPersistenceAdapter(ReservationJpaRepository reservationJpaRepository) {
        this.reservationJpaRepository = reservationJpaRepository;
    }

    @Override
    public Reservation save(Reservation reservation) {
        var saved = reservationJpaRepository.save(ReservationPersistenceMapper.toEntity(reservation));
        return ReservationPersistenceMapper.toDomain(saved);
    }

    @Override
    public Reservation findById(Long id) {
        var reservationEntity = reservationJpaRepository.findById(id);
        return ReservationPersistenceMapper.toDomain(reservationEntity);
    }

    @Override
    public boolean existsbyReservationCode(String reservationCode) {
        return reservationJpaRepository.existsByReservationCode(reservationCode);
}
