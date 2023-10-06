package com.example.mappingrelations.repositories;

import com.example.mappingrelations.models.Carrera;
import com.example.mappingrelations.models.Estudiante;
import com.example.mappingrelations.models.Inscripcion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarreraRepository extends CrudRepository<Carrera, Long> {

    /*
    Intentamos implementarlo de esta forma ya que nos pareció la mas eficiente, sin embargo, JPQL no soporta
    las subqueries, por lo tanto teniamos 2 alternativas, utilizar WHERE c.id SOME() o directamente hacer un JOIN
    sin haber achicado los datos, y fuimos por la segunda opcion.
    @Query(
            "SELECT c " +
            "FROM (SELECT i.id.id_carrera_pk " +
                    "FROM Inscripcion i " +
                    "WHERE i.anio_graduacion <> NULL " +
                    "GROUP BY i.id.id_carrera_pk " +
                    "HAVING COUNT(*) > 0) i " +
            "JOIN Carrera c ON c.id = i.id_carrera_pk "
    )
    */
    @Query( """
                SELECT c
                FROM Inscripcion i
                JOIN Carrera c ON i.id.id_carrera_pk = c.id
                WHERE i.anio_graduacion IS NULL
                GROUP BY i.id.id_carrera_pk
            """)
    Iterable<Carrera> traerCarrerasConInscriptos();

    @Query("UPDATE Inscripcion i " +
            "SET i.anio_graduacion =: anio_graduacion " +
            "WHERE i.id.id_carrera_pk =: id_carrera AND i.id.id_estudiante_pk =: id_estudiante")
    Inscripcion updateGraduacion(long id_estudiante, long id_carrera, Integer anio_graduacion);
}
