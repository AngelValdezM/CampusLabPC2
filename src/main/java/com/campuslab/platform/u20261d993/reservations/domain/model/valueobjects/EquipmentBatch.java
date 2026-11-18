package com.campuslab.platform.u20261d993.reservations.domain.model.valueobjects;

public record EquipmentBatch(Integer value) {
    public EquipmentBatch {
        if (value == null || value <= 0) {
            throw new IllegalArgumentException("EquipmentBatch value must be a positive integer");
        }
    }
}
