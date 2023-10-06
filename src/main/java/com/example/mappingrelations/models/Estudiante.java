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
@Table(name = "estudiante")
public class Estudiante {
    @Id
    @Column(name = "id")
    private long legajo;
    @Column(nullable = false)
    private String nombre;
    @Column(nullable = false)
    private String apellido;
    @Column(nullable = false)
    private String ciudad;
    private long dni;
    private int edad;
    @Column(nullable = false)
    private String genero;

    // Al dar de baja un estudiante, se dan de baja sus inscripciones
    @OneToMany(mappedBy = "estudiante", fetch = FetchType.LAZY)
    @Cascade(CascadeType.DELETE_ORPHAN)
    private List<Inscripcion> inscripciones;

    public Estudiante(long legajo, String nombre, String apellido, String ciudad, long dni, int edad, String genero) {
        this.legajo = legajo;
        this.nombre = nombre;
        this.apellido = apellido;
        this.ciudad = ciudad;
        this.dni = dni;
        this.edad = edad;
        this.genero = genero;
        this.inscripciones = new ArrayList<>();
    }

}
