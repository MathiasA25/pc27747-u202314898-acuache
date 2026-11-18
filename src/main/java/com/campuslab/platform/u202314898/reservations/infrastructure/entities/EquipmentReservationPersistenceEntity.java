package com.campuslab.platform.u202314898.reservations.infrastructure.entities;


import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "equipment_reservations")
@EntityListeners(AuditingEntityListener.class)
public class EquipmentReservationPersistenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

}
