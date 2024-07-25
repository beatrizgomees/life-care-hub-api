package com.github.beatrizgomees.api.authentication.domain.Doctor;


import com.github.beatrizgomees.api.authentication.domain.medicalSpecialty.MedicalSpecialty;
import jakarta.persistence.*;
import org.hibernate.annotations.BatchSize;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.UUID;

@Document(collection = "doctor")
public class Doctor {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    private String firstName;
    private String lastName;

    @ManyToOne
    @JoinColumn(name = "medical_specialty_id")
    private MedicalSpecialty medicalSpecialty;

    private String description;

    @BatchSize(size = 11)
    private String phoneNumber;

    public UUID getId() {
        return id;
    }

    public String getFirstname() {
        return firstName;
    }

    public void setFirstname(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public MedicalSpecialty getMedicalSpecialty() {
        return medicalSpecialty;
    }

    public void setMedicalSpecialty(MedicalSpecialty medicalSpecialty) {
        this.medicalSpecialty = medicalSpecialty;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public String toString() {
        return "Doctor{" +
                "id=" + id +
                ", name='" + firstName + '\'' +
                ", lastname='" + lastName + '\'' +
                ", medicalSpecialty='" + medicalSpecialty + '\'' +
                ", description='" + description + '\'' +
                ", phoneNumber=" + phoneNumber +
                '}';
    }
}
