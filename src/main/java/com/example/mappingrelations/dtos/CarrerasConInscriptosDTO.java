package com.example.mappingrelations.dtos;

public class CarrerasConInscriptosDTO {
    private int id;
    private String carrera;
    private int inscriptos;

    public CarrerasConInscriptosDTO(int id, String carrera, Long inscriptos) {
        this.id = id;
        this.carrera = carrera;
        this.inscriptos = inscriptos.intValue();
    }

    @Override
    public String toString() {
        return
            "\nID: " + id +
            "\nCarrera: " + carrera +
            "\nInscriptos: " + inscriptos;
    }
}
