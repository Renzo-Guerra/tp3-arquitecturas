package com.example.mappingrelations.models;

import jakarta.persistence.*;
import lombok.*;
import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;

import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "carrera")
public class Carrera {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    private String nombre;

    @OneToMany(mappedBy = "carrera", fetch = FetchType.LAZY)
    @Cascade(CascadeType.DELETE_ORPHAN)
    private List<Inscripcion> inscripciones;

    public Carrera(String nombre){
        this.nombre = nombre;
        this.inscripciones = new ArrayList<>();
    }
}
