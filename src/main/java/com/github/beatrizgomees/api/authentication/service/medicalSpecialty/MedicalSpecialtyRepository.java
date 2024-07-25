package com.github.beatrizgomees.api.authentication.service.medicalSpecialty;

import com.github.beatrizgomees.api.authentication.domain.medicalSpecialty.MedicalSpecialty;
import org.bson.Document;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;


@Repository
public interface MedicalSpecialtyRepository extends MongoRepository<MedicalSpecialty, Document> {

    MedicalSpecialty findById(UUID id);

    void deleteById(UUID id);

}
