package com.github.beatrizgomees.api.authentication.service.medicalSpecialty;

import com.github.beatrizgomees.api.authentication.auth.AuthController;
import com.github.beatrizgomees.api.authentication.domain.User.User;
import com.github.beatrizgomees.api.authentication.domain.medicalSpecialty.MedicalSpecialty;
import com.github.beatrizgomees.api.authentication.domain.medicalSpecialty.MedicalSpecialtyDTO;
import com.github.beatrizgomees.api.authentication.exceptions.FindByIdException;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class MedicalSpecialtyServiceImpl   {


    private final MedicalSpecialtyRepository service;


    @Autowired
    public MedicalSpecialtyServiceImpl(MedicalSpecialtyRepository service ) {
        this.service = service;

    }


    public MedicalSpecialtyDTO create(MedicalSpecialtyDTO medicalSpecialtyDTO) {
            var entity = new MedicalSpecialty(
                    UUID.randomUUID(),
                    medicalSpecialtyDTO.name(),
                    medicalSpecialtyDTO.description()

            );

        service.save(entity);
        return medicalSpecialtyDTO;


    }

    public List<MedicalSpecialty> getAll() {
        List<MedicalSpecialty> documentList = service.findAll();
        return documentList;
    }

    public Optional findById(UUID id) {
        return Optional.ofNullable(service.findById(id));
    }


    public void delete(UUID id) {
        var idExist = existById(id);
        if(idExist.isPresent()) {
            service.deleteById(id);
        }
    }


    public Optional<MedicalSpecialty> update(UUID id, MedicalSpecialtyDTO updateMedicalSpecialtyDTO) {
        MedicalSpecialty medicalSpecialty = service.findById(id);
        try {
            if (id == null) {
                throw new FindByIdException("Medical specialty not found");
            }
            medicalSpecialty.setName(updateMedicalSpecialtyDTO.name());
            medicalSpecialty.setDescription(updateMedicalSpecialtyDTO.description());
            service.save(medicalSpecialty);

        } catch (FindByIdException e) {
            throw new IllegalStateException("Error finding medical specialty by ID", e);
        }
        return Optional.of(medicalSpecialty);
    }


    public Optional<Boolean> existById(UUID id) {
        return Optional.empty();
    }


}
