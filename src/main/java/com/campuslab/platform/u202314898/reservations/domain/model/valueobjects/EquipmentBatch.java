package com.campuslab.platform.u202314898.reservations.domain.model.valueobjects;

import com.campuslab.platform.u202314898.shared.MessageHelper;

public record EquipmentBatch(Integer quantity, String unit) {
    public EquipmentBatch {
        if (quantity == null || quantity <= 0) {
            throw new IllegalArgumentException(MessageHelper.get("batch.quantity.invalid"));
        }
        if (unit == null || unit.isBlank()) {
            throw new IllegalArgumentException(MessageHelper.get("batch.unit.invalid"));
        }
    }

    public EquipmentBatch addUnits(Integer additionalQuantity) {
        if (additionalQuantity == null || additionalQuantity <= 0) {
            throw new IllegalArgumentException(MessageHelper.get("batch.quantity.invalid"));
        }
        long sum = (long) this.quantity + additionalQuantity;

        if (sum > Integer.MAX_VALUE) {
            throw new IllegalArgumentException("Total quantity exceeds Integer.MAX_VALUE");
        }
        return new EquipmentBatch((int) sum, this.unit);
    }
}