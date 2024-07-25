package com.github.beatrizgomees.api.authentication.domain.medicine;


import com.github.beatrizgomees.api.authentication.domain.medicalSpecialty.MedicalSpecialtyDTO;

import java.time.LocalDateTime;
import java.util.UUID;

public record MedicineRequest(
        UUID id,
        String name,
        int amount,
        LocalDateTime reminder,
        String description,
        MedicalSpecialtyDTO medicalSpecialty
) {
}
