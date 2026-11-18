package com.campuslab.platform.u202314898.reservations.infrastructure.repositories;

import com.campuslab.platform.u202314898.reservations.infrastructure.entities.EquipmentReservationPersistenceEntity;
import org.hibernate.internal.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EquipmentReservationJpaRepository extends JpaRepository<EquipmentReservationPersistenceEntity, Long> {
    Optional<EquipmentReservationPersistenceEntity> findByReservationCode(String reservationCode);
}
