package com.example.mappingrelations.services;

import com.example.mappingrelations.dtos.UpdateFechaGraduacionDTO;
import com.example.mappingrelations.models.Carrera;
import com.example.mappingrelations.models.Estudiante;
import com.example.mappingrelations.models.Inscripcion;
import com.example.mappingrelations.repositories.CarreraRepository;
import com.example.mappingrelations.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarreraService {
    private final CarreraRepository carreraRepository;
    private final EstudianteRepository estudianteRepository;

    @Autowired
    public CarreraService(CarreraRepository carreraRepository, EstudianteRepository estudianteRepository){
        this.carreraRepository = carreraRepository;
        this.estudianteRepository = estudianteRepository;
    }

    public Iterable<Carrera> traerTodos(){
        return this.carreraRepository.findAll();
    }

    public Optional<Carrera> traerPorId(long id){
        return  this.carreraRepository.findById(id);
    }

    public Carrera crearCarrera(Carrera carrera){
        return carreraRepository.save(carrera);
    }

    public void eliminarPorId(long id){
        carreraRepository.deleteById(id);
    }

    public boolean existeCarreraPorId(long id){ return carreraRepository.existsById(id); }

    public Iterable<Carrera> traerCarrerasConInscriptos(){
        return carreraRepository.traerCarrerasConInscriptos();
    }

    public Inscripcion updateGraduacion(UpdateFechaGraduacionDTO data) throws Exception{
        try {
            if(!this.existeCarreraPorId(data.getId_carrera())) throw new Exception("La carrera no existe...");
            if(!this.estudianteRepository.existsById(data.getId_carrera())) throw new Exception("El estudiante no existe...");

            return this.carreraRepository.updateGraduacion(data.getId_estudiante(), data.getId_carrera(), data.getAnio_graduacion());
        }catch (Exception err){
            throw new Exception(err.getMessage());
        }
    }
}
