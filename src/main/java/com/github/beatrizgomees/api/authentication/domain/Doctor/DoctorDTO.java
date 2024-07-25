package com.github.beatrizgomees.api.authentication.domain.Doctor;


import com.github.beatrizgomees.api.authentication.domain.medicalSpecialty.MedicalSpecialtyDTO;
import jakarta.validation.constraints.NotNull;
import org.hibernate.annotations.BatchSize;

import java.io.Serializable;
import java.util.UUID;

public record DoctorDTO (UUID id,
                         String firstName,
                         String lastName,
                         @NotNull
                         MedicalSpecialtyDTO medicalSpecialty,
                         @BatchSize(size = 11)
                         String phoneNumber,
                         String description)
        implements Serializable {}