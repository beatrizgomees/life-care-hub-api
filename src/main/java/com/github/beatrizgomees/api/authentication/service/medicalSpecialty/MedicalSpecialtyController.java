package com.github.beatrizgomees.api.authentication.service.medicalSpecialty;

import com.github.beatrizgomees.api.authentication.auth.AuthController;
import com.github.beatrizgomees.api.authentication.domain.User.User;
import com.github.beatrizgomees.api.authentication.domain.medicalSpecialty.MedicalSpecialty;
import com.github.beatrizgomees.api.authentication.domain.medicalSpecialty.MedicalSpecialtyDTO;
import com.github.beatrizgomees.api.authentication.domain.medicalSpecialty.MedicalSpecialtyMapper;
import com.github.beatrizgomees.api.authentication.domain.medicalSpecialty.MedicalSpecialtyRequest;
import com.github.beatrizgomees.api.authentication.exceptions.FindByIdException;
import jakarta.validation.Valid;
import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.token.TokenService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/medicalSpecialty")
public class MedicalSpecialtyController {

    @Autowired
    MedicalSpecialtyServiceImpl medicalSpecialtyService;
    private final AuthController authController;
    TokenService tokenService;

    public MedicalSpecialtyController(AuthController authController) {
        this.authController = authController;
    }

    @PostMapping
    public ResponseEntity createMedicalSpecialty(@Valid @RequestBody MedicalSpecialtyRequest medicalSpecialtyRequest){
        try {
            if (medicalSpecialtyRequest.name() == null) {
                throw new NullPointerException("Name cannot be null");
            }
            MedicalSpecialtyMapper medicalSpecialtyMapper = new MedicalSpecialtyMapper();
            var dto = medicalSpecialtyMapper.convertRequestToDTO(medicalSpecialtyRequest);

            Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

            //Mapeamento de usuario para cada entidade de serviço.
            // Um usuario pode ter uma lista de remedios e uma lista de
            // especialidades

            return ResponseEntity.ok(medicalSpecialtyService.create(dto)).status(201).build();

        } catch (NullPointerException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @GetMapping()
    public ResponseEntity getMedicalSpecialty(){
    List<MedicalSpecialty> documentList = medicalSpecialtyService.getAll();
    return ResponseEntity.ok(documentList).status(200).build();

    }


    @GetMapping("/{id}")
    public ResponseEntity findMedicalSpecialty(@RequestParam("id") UUID id)  throws FindByIdException {
        Optional<Document> medicalSpecialtyRequest = medicalSpecialtyService.findById(id);
        return ResponseEntity.ok(medicalSpecialtyRequest).status(200).build();

    }

    @DeleteMapping("/{id}")
    public ResponseEntity deleteMedicalSpecialty(@RequestParam("id") UUID id){
        medicalSpecialtyService.delete(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Deleted successfully");
    }

    @PutMapping("/{id}")
    public ResponseEntity updateMedicalSpecialty(@RequestParam("id") String id, MedicalSpecialtyRequest medicalSpecialtyRequest) throws FindByIdException {
        MedicalSpecialtyMapper mapper = new MedicalSpecialtyMapper();
        MedicalSpecialtyDTO medicalSpecialtyDTO = mapper.convertRequestToDTO(medicalSpecialtyRequest);
        medicalSpecialtyService.update(UUID.fromString(id), medicalSpecialtyDTO);
        return ResponseEntity.ok(medicalSpecialtyRequest).status(200).build();
    }

}
