package com.example.mappingrelations.models;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Embeddable
@Getter
@NoArgsConstructor              // Genera el constructor vacio
public class InscripcionPK implements Serializable {
    @Column(name = "id_estudiante")
    private long id_estudiante_pk;

    @Column(name = "id_carrera")
    private long id_carrera_pk;

    public InscripcionPK(long id_estudiante, long id_carrera){
        this.id_estudiante_pk = id_estudiante;
        this.id_carrera_pk = id_carrera;
    }
}
