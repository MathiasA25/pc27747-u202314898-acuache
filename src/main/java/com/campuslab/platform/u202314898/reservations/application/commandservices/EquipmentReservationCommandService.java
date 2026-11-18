package com.campuslab.platform.u202314898.reservations.application.commandservices;

import com.campuslab.platform.u202314898.reservations.domain.model.aggregates.EquipmentReservation;
import com.campuslab.platform.u202314898.reservations.domain.model.commands.CreateEquipmentReservationCommand;
import com.campuslab.platform.u202314898.shared.domain.model.Result;

public interface EquipmentReservationCommandService {
    Result<EquipmentReservation> handle(CreateEquipmentReservationCommand command);
}
