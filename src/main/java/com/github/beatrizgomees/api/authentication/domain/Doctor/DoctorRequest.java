package com.github.beatrizgomees.api.authentication.domain.Doctor;


import com.github.beatrizgomees.api.authentication.domain.medicalSpecialty.MedicalSpecialtyDTO;

import java.util.UUID;

public record DoctorRequest (UUID id, String firstName, String lastname, String description, MedicalSpecialtyDTO medicalSpecialty,
                             String phoneNumber){
}
