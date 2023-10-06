package com.example.mappingrelations.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Data
@NoArgsConstructor
@Table(name = "inscripcion")
public class Inscripcion {
    @EmbeddedId
    private InscripcionPK id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id_estudiante")
    @JoinColumn(name = "id_estudiante")
    private Estudiante estudiante;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("id_carrera")
    @JoinColumn(name = "id_carrera")
    private Carrera carrera;

    private Integer anio_graduacion;
    private int anio_inscripcion;

    public Inscripcion(Estudiante estudiante, Carrera carrera, int anio_inscripcion, Integer anio_graduacion) {
        this.id = new InscripcionPK(estudiante.getLegajo(), carrera.getId());
        this.anio_graduacion = anio_graduacion;
        this.anio_inscripcion = anio_inscripcion;
    }


}
