package com.campuslab.platform.u20261d993.reservations.domain.model.valueobjects;

public record EquipmentBatchQuantity(Integer value) {
    public EquipmentBatchQuantity {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException("EquipmentBatchQuantity value must be a positive integer");
        }
    }
}
