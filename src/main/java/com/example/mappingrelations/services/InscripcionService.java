package com.example.mappingrelations.services;

import com.example.mappingrelations.dtos.InscripcionDTO;
import com.example.mappingrelations.models.Carrera;
import com.example.mappingrelations.models.Estudiante;
import com.example.mappingrelations.models.Inscripcion;
import com.example.mappingrelations.models.InscripcionPK;
import com.example.mappingrelations.repositories.EstudianteRepository;
import com.example.mappingrelations.repositories.InscripcionRepository;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class InscripcionService {
    private final InscripcionRepository inscripcionRepository;

    @Autowired
    public InscripcionService(InscripcionRepository inscripcionRepository){
        this.inscripcionRepository = inscripcionRepository;
    }

    public Inscripcion inscribir(Inscripcion inscripcion){
        return inscripcionRepository.save(inscripcion);
    }
}
