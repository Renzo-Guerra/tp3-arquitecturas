package com.example.mappingrelations.controllers;

import com.example.mappingrelations.models.Carrera;
import com.example.mappingrelations.models.Estudiante;
import com.example.mappingrelations.services.CarreraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping( value = "/carrera")
public class CarreraController {
    private final CarreraService carreraService;

    @Autowired
    public CarreraController(CarreraService carreraService){
        this.carreraService = carreraService;
    }

    @PostMapping("")
    public ResponseEntity<?> crearCarrera(@RequestBody Carrera carrera){
        try{
            return ResponseEntity.status(201).body(carreraService.crearCarrera(carrera));
        }catch (Exception err){
            return ResponseEntity.status(404).body(err);
        }
    }

    @GetMapping("")
    public ResponseEntity<?> traerTodos(){
        try{
            return ResponseEntity.status(200).body(this.carreraService.traerTodos());
        }catch (Exception e){
            return ResponseEntity.status(404).body(e);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> traerPorId(@PathVariable long id){
        try{
            Optional<Carrera> carrera = this.carreraService.traerPorId(id);
            // Si el estudiante existe,lo devolverá, caso contrario devolverá un estudiante vacio
            if(carrera.isPresent())
                return ResponseEntity.status(200).body(carrera.get());
            else
                return ResponseEntity.status(200).body(null);   // Como podemos devolver {}?
        }catch (Exception err){
            return ResponseEntity.status(404).body(err);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> eliminarPorId(@PathVariable long id){
        try{
            carreraService.eliminarPorId(id);
            return ResponseEntity.status(200).body("Carrera eliminada!");
        }catch (Exception err){
            return ResponseEntity.status(404).body(err.getMessage());
        }
    }

    @GetMapping("/conInscriptos")
    public ResponseEntity<?> traerCarrerasConInscriptos(){
        try{
            return ResponseEntity.status(200).body(carreraService.traerCarrerasConInscriptos());
        }catch (Exception err){
            return ResponseEntity.status(404).body(err.getMessage());
        }
    }
}
