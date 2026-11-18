package com.campuslab.platform.u202314898.reservations.domain.model.valueobjects;

import com.campuslab.platform.u202314898.shared.MessageHelper;

public record ReservationCode(String code) {

    public ReservationCode {

        if (code == null || code.isBlank()) {

            throw new IllegalArgumentException(MessageHelper.get("reservation.code.invalid"));

        }

    }

}