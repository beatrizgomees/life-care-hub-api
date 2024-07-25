package com.github.beatrizgomees.api.authentication.domain.medicalSpecialty;

import jakarta.validation.constraints.NotNull;

import java.util.UUID;


public record MedicalSpecialtyDTO(
        UUID id,
        @NotNull
        String name,
        String description) {
}


