package com.campuslab.platform.u202314898.reservations.domain.repositories;

import com.campuslab.platform.u202314898.reservations.domain.model.aggregates.EquipmentReservation;
import org.hibernate.internal.util.Optional;

public interface EquipmentReservationRepository {
    Optional<EquipmentReservation>findByReservationCode(String reservationCode);
    EquipmentReservation save(EquipmentReservation reservation);
}
