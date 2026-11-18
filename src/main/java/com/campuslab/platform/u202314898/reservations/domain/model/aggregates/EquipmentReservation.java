package com.campuslab.platform.u202314898.reservations.domain.model.aggregates;

import com.campuslab.platform.u202314898.reservations.domain.model.commands.CreateEquipmentReservationCommand;
import com.campuslab.platform.u202314898.reservations.domain.model.enums.ReservationStatus;
import com.campuslab.platform.u202314898.reservations.domain.model.valueobjects.EquipmentBatch;
import com.campuslab.platform.u202314898.reservations.domain.model.valueobjects.LaboratoryId;
import com.campuslab.platform.u202314898.reservations.domain.model.valueobjects.ReservationCode;
import com.campuslab.platform.u202314898.reservations.domain.model.valueobjects.ReservationPeriod;
import com.campuslab.platform.u202314898.shared.MessageHelper;

import java.time.LocalDate;
import java.util.UUID;

public class EquipmentReservation {

    private Long id;
    private ReservationCode reservationCode;
    private LaboratoryId laboratoryId;
    private ReservationPeriod reservationPeriod;
    private EquipmentBatch equipmentBatch;
    private Integer accessLevel;
    private ReservationStatus status;
    private String reservationNotes;

    public EquipmentReservation(){}

    public static EquipmentReservation create(CreateEquipmentReservationCommand command) {
        if (command.reservationPeriodStartDate() == null || command.reservationPeriodEndDate() == null) {
            throw new IllegalArgumentException(MessageHelper.get("period.dates.null"));
        }
        if (command.accessLevel() == null || command.accessLevel() < 1 || command.accessLevel() > 5) {
            throw new IllegalArgumentException(MessageHelper.get("access.level.invalid"));
        }
        if (command.status() == null || command.status().isBlank()) {
            throw new IllegalArgumentException(MessageHelper.get("status.invalid"));
        }
        ReservationStatus parsedStatus;
        try {
            parsedStatus = ReservationStatus.valueOf(command.status().trim());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(MessageHelper.get("status.invalid"));
        }

        EquipmentReservation r = new EquipmentReservation();
        r.reservationCode = new ReservationCode(command.reservationCode());
        r.laboratoryId = LaboratoryId.of(command.laboratoryId());
        r.reservationPeriod = new ReservationPeriod(
                LocalDate.parse(command.reservationPeriodStartDate()),
                LocalDate.parse(command.reservationPeriodEndDate())
        );
        r.equipmentBatch = new EquipmentBatch(command.equipmentBatchQuantity(), command.equipmentBatchUnit());
        r.accessLevel = command.accessLevel();
        r.status = parsedStatus;
        r.reservationNotes = command.reservationNotes();
        return r;

    }

    public Long getId() { return id; }
    public ReservationCode getReservationCode() { return reservationCode; }
    public LaboratoryId getLaboratoryId() { return laboratoryId; }
    public ReservationPeriod getReservationPeriod() { return reservationPeriod; }
    public EquipmentBatch getEquipmentBatch() { return equipmentBatch; }
    public Integer getAccessLevel() { return accessLevel; }
    public ReservationStatus getStatus() { return status; }
    public String getReservationNotes() { return reservationNotes; }


    public void setId(Long id) { this.id = id; }
    public void setReservationCode(String code) { this.reservationCode = new ReservationCode(code); }
    public void setLaboratoryId(UUID labId) { this.laboratoryId = LaboratoryId.of(labId); }
    public void setReservationPeriod(LocalDate start, LocalDate end) { this.reservationPeriod = new ReservationPeriod(start, end); }
    public void setEquipmentBatch(Integer qty, String unit) { this.equipmentBatch = new EquipmentBatch(qty, unit); }
    public void setAccessLevel(Integer accessLevel) { this.accessLevel = accessLevel; }
    public void setStatus(ReservationStatus status) { this.status = status; }
    public void setReservationNotes(String notes) { this.reservationNotes = notes; }

}

