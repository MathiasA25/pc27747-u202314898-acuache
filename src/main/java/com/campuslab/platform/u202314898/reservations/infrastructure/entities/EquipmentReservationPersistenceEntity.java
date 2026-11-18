package com.campuslab.platform.u202314898.reservations.infrastructure.entities;


import com.campuslab.platform.u202314898.reservations.domain.model.aggregates.EquipmentReservation;
import com.campuslab.platform.u202314898.reservations.domain.model.enums.ReservationStatus;
import jakarta.persistence.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedDate;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.time.Instant;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name = "equipment_reservations")
@EntityListeners(AuditingEntityListener.class)
public class EquipmentReservationPersistenceEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String reservationCode;

    @Column (nullable = false)
    private UUID laboratoryId;

    @Column(nullable = false)
    private LocalDate reservationPeriodStartDate;

    @Column(nullable = false)
    private LocalDate reservationPeriodEndDate;

    @Column (nullable = false)
    private Integer equipmentBatchQuantity;

    @Column (nullable = false)
    private String equipmentBatchUnit;

    @Column (nullable = false)
    private Integer accessLevel;

    @Enumerated(EnumType.STRING)
    @Column (nullable = false)
    private ReservationStatus status;

    @Column
    private String reservationNotes;

    @CreatedDate
    @Column(nullable = false, updatable = false)
    private Instant createdAt;

    @LastModifiedDate
    @Column (nullable = false)
    private Instant updatedAt;

    public EquipmentReservationPersistenceEntity(){}

    public EquipmentReservationPersistenceEntity(EquipmentReservation r) {

        this.id = r.getId();
        this.reservationCode = r.getReservationCode().code();
        this.laboratoryId = r.getLaboratoryId().value();
        this.reservationPeriodStartDate = r.getReservationPeriod().startDate();
        this.reservationPeriodEndDate = r.getReservationPeriod().endDate();
        this.equipmentBatchQuantity = r.getEquipmentBatch().quantity();
        this.equipmentBatchUnit = r.getEquipmentBatch().unit();
        this.accessLevel = r.getAccessLevel();
        this.status = r.getStatus();
        this.reservationNotes = r.getReservationNotes();

    }

    public EquipmentReservation toDomainModel() {
        EquipmentReservation r = new EquipmentReservation();
        r.setId(this.id);
        r.setReservationCode(this.reservationCode);
        r.setLaboratoryId(this.laboratoryId);
        r.setReservationPeriod(this.reservationPeriodStartDate, this.reservationPeriodEndDate);
        r.setEquipmentBatch(this.equipmentBatchQuantity, this.equipmentBatchUnit);
        r.setAccessLevel(this.accessLevel);
        r.setStatus(this.status);
        r.setReservationNotes(this.reservationNotes);
        return r;

    }

}
