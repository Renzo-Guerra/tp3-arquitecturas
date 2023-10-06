package com.example.mappingrelations.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@AllArgsConstructor
public class InscripcionDTO {
    private long id_estudiante;
    private long id_carrera;
    private int anio_inscripcion;
    private Integer anio_graduacion;

    public InscripcionDTO(long id_estudiante, long id_carrera, int anio_inscripcion) {
        this.id_estudiante = id_estudiante;
        this.id_carrera = id_carrera;
        this.anio_inscripcion = anio_inscripcion;
        this.anio_graduacion = null;
    }
}
