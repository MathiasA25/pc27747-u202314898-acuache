package com.campuslab.platform.u202314898.reservations.domain.model.commands;

public record CreateEquipmentReservationCommand(
        String reservationCode,
        String laboratoryId,
        String reservationPeriodStartDate,
        String reservationPeriodEndDate,
        String equipmentBatchUnit,
        Integer accessLevel,
        String status,
        String reservationNotes
) {
    public Integer equipmentBatchQuantity() {
        return null;
    }
}
