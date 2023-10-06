package com.example.mappingrelations.repositories;

import com.example.mappingrelations.models.Estudiante;
import com.example.mappingrelations.models.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstudianteRepository extends CrudRepository<Estudiante, Long> {
    Iterable<Estudiante> getAllByGenero(String genero);
}
