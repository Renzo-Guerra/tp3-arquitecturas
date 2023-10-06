package com.example.mappingrelations.dtos;

public class InfoCarreraDTO {
    private String carrera;
    private Integer anio;
    private Integer cant_inscriptos;
    private Integer cant_egresados;

    public InfoCarreraDTO(String carrera, Long anio, Long cant_inscriptos, Long cant_egresados) {
        this.carrera = carrera;
        if (anio != null)
            this.anio = anio.intValue();
        this.cant_inscriptos = cant_inscriptos.intValue();
        this.cant_egresados = cant_egresados.intValue();
    }

    @Override
    public String toString() {
        return
                "CARRERA: " + carrera + " - " +
                        "ANIO: " + anio + " - " +
                        "INSCRIPTOS: " + cant_inscriptos + " - " +
                        "GRADUADOS: " + cant_egresados;
    }
}
