package com.github.beatrizgomees.api.authentication.domain.medicalSpecialty;

import java.util.UUID;

public record MedicalSpecialtyRequest(
        UUID id, String name, String description) {
}
