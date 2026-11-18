package com.campuslab.platform.u20261d993.reservations.domain.model.valueobjects;

import java.util.UUID;

public record LaboratoryId(UUID value) {
    public LaboratoryId {
        if (value == null) {
            throw new IllegalArgumentException("LaboratoryId cannot be null or blank");
        }
    }
}
