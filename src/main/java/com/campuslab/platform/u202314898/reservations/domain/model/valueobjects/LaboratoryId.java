package com.campuslab.platform.u202314898.reservations.domain.model.valueobjects;

import com.campuslab.platform.u202314898.shared.MessageHelper;
import java.util.UUID;
public record LaboratoryId(UUID value) {

    public LaboratoryId {

        if (value == null) {

            throw new IllegalArgumentException(MessageHelper.get("laboratory.id.null"));

        }

    }

    public static LaboratoryId of(UUID value) { return new LaboratoryId(value); }

    public static LaboratoryId of(String value) {

        if (value == null || value.isBlank()) {

            throw new IllegalArgumentException(MessageHelper.get("laboratory.id.null"));

        }

        return new LaboratoryId(UUID.fromString(value));

    }

}