package com.example.mappingrelations.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Getter
public class UpdateFechaGraduacionDTO {
    private long id_estudiante;
    private long id_carrera;
    private Integer anio_graduacion;
}
