package com.campuslab.platform.u202314898.reservations.domain.model.valueobjects;

import com.campuslab.platform.u202314898.shared.MessageHelper;
import java.time.LocalDate;

public record ReservationPeriod(LocalDate startDate, LocalDate endDate) {

    public ReservationPeriod {

        if (startDate == null || endDate == null) {
            throw new IllegalArgumentException(MessageHelper.get("period.dates.null"));
        }

        if (!endDate.isAfter(startDate)) {
            throw new IllegalArgumentException(MessageHelper.get("period.dates.invalid"));
        }
    }

    public boolean contains(LocalDate checkDate) {
        if (checkDate == null) {

            throw new IllegalArgumentException("Check date must not be null");
        }
        return !checkDate.isBefore(startDate) && !checkDate.isAfter(endDate);

    }

}