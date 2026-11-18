package com.campuslab.platform.u20261d993.reservations.infrastructure.persistence.jpa.repositories;

import org.springframework.stereotype.Repository;

@Repository
public interface ReservationJpaRepository extends JpaRepository<ReservationEntity, Long> {
    boolean existsByReservationCode(String reservationCode);
    ReservationEntity findByReservationCode(String reservationCode);
}
