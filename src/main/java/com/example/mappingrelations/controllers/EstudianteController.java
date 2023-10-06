package com.example.mappingrelations.controllers;

import com.example.mappingrelations.dtos.InscripcionDTO;
import com.example.mappingrelations.dtos.UpdateFechaGraduacionDTO;
import com.example.mappingrelations.models.Carrera;
import com.example.mappingrelations.models.Estudiante;
import com.example.mappingrelations.models.Inscripcion;
import com.example.mappingrelations.services.CarreraService;
import com.example.mappingrelations.services.EstudianteService;
import com.example.mappingrelations.services.InscripcionService;
import org.apache.tomcat.util.json.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping(value = "/estudiantes")
public class EstudianteController {
    private EstudianteService estudianteService;
    private CarreraService carreraService;
    private InscripcionService inscripcionService;

    @Autowired
    public EstudianteController(EstudianteService estudianteService, CarreraService carreraService, InscripcionService inscripcionService){
        this.estudianteService = estudianteService;
        this.carreraService = carreraService;
        this.inscripcionService = inscripcionService;
    }

    @PostMapping("")
    public ResponseEntity<?> crearEstudiante(@RequestBody Estudiante estudiante){
        try{
            return ResponseEntity.status(201).body(estudianteService.crearEstudiante(estudiante));
        }catch (Exception err){
            return ResponseEntity.status(404).body(err.getMessage());
        }
    }

    @GetMapping("")
    public ResponseEntity<?> traerTodos(){
        try{
            return ResponseEntity.status(200).body(this.estudianteService.traerTodos());
        }catch (Exception e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/genero/{genero}")
    public ResponseEntity<?> traerTodosPorGenero(@PathVariable String genero){
        try{
            return ResponseEntity.status(200).body(this.estudianteService.traerPorGenero(genero));
        }catch (Exception e){
            return ResponseEntity.status(404).body(e.getMessage());
        }
    }

    @GetMapping("/legajo/{id}")
    public ResponseEntity<?> traerPorId(@PathVariable long id){
        try{
            Optional<Estudiante> estudiante = this.estudianteService.traerPorId(id);
            // Si el estudiante existe,lo devolverá, caso contrario devolverá un estudiante vacio
            if(estudiante.isPresent())
                return ResponseEntity.status(200).body(estudiante.get());
            else
                return ResponseEntity.status(200).body("");
        }catch (Exception err){
            return ResponseEntity.status(404).body(err.getMessage());
        }
    }

    @PostMapping("/graduacion")
    public ResponseEntity<?> updateGraduacion(@RequestBody UpdateFechaGraduacionDTO data){
        try {
            return ResponseEntity.status(200).body(carreraService.updateGraduacion(data));
        } catch (Exception err){
            return ResponseEntity.status(404).body(err.getMessage());
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable long id){
        try{
            estudianteService.eliminarPorId(id);
            return ResponseEntity.status(200).body("Estudiante eliminado!");
        }catch (Exception err){
            return ResponseEntity.status(404).body(err.getMessage());
        }
    }

    @PostMapping("/matricular")
    public ResponseEntity<?> matricular(@RequestBody InscripcionDTO inscripcion_dto){
        try{
            return ResponseEntity.status(200).body(estudianteService.crearInscripcion(inscripcion_dto));
        }catch (Exception err){
            return ResponseEntity.status(404).body(err.getMessage());
        }
    }

    /*
    @PutMapping("")
    public ResponseEntity<?> editar(@RequestBody Estudiante estudiante){
        try{
            return ResponseEntity.status(200).body(estudianteService.editar(estudiante));
        }catch (Exception err){
            return ResponseEntity.status(404).body(err);
        }
    }
    */

}
