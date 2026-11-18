package com.campuslab.platform.u202314898.reservations.infrastructure.adapters;

import com.campuslab.platform.u202314898.reservations.domain.model.aggregates.EquipmentReservation;
import com.campuslab.platform.u202314898.reservations.domain.repositories.EquipmentReservationRepository;
import com.campuslab.platform.u202314898.reservations.infrastructure.entities.EquipmentReservationPersistenceEntity;
import com.campuslab.platform.u202314898.reservations.infrastructure.repositories.EquipmentReservationJpaRepository;
import org.hibernate.internal.util.Optional;
import org.springframework.stereotype.Component;

@Component
public class EquipmentReservationRepositoryImpl implements EquipmentReservationRepository {
    private final EquipmentReservationJpaRepository jpaRepository;

    public EquipmentReservationRepositoryImpl(EquipmentReservationJpaRepository jpaRepository) {
        this.jpaRepository = jpaRepository;
    }

    @Override
    public Optional<EquipmentReservation> findByReservationCode(String reservationCode) {
       return jpaRepository .findByReservationCode(reservationCode)
                .map(EquipmentReservationPersistenceEntity::toDomainModel);
    }
    @Override
    public EquipmentReservation save(EquipmentReservation reservation){
        var saved = jpaRepository.save(new EquipmentReservationPersistenceEntity(reservation));
        return saved.toDomainModel();
    }
}
