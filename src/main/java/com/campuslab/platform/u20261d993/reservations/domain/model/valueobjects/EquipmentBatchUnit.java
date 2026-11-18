package com.campuslab.platform.u20261d993.reservations.domain.model.valueobjects;

public record EquipmentBatchUnit(String value) {
    public EquipmentBatchUnit {
        if (value == null || value.isEmpty()) {
            throw new IllegalArgumentException("EquipmentBatchUnit value cannot be null or empty");
        }
    }
}
