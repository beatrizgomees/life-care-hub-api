package com.github.beatrizgomees.api.authentication.domain.Doctor;

import com.github.beatrizgomees.api.authentication.domain.medicalSpecialty.MedicalSpecialty;

import java.util.UUID;

public record DoctorResponse (UUID id, String firstName, String lastname, String description, MedicalSpecialty medicalSpecialty, String phoneNumber) {
}
