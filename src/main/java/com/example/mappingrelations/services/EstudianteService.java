package com.example.mappingrelations.services;

import com.example.mappingrelations.dtos.InscripcionDTO;
import com.example.mappingrelations.models.Carrera;
import com.example.mappingrelations.models.Estudiante;
import com.example.mappingrelations.models.Inscripcion;
import com.example.mappingrelations.repositories.EstudianteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EstudianteService {
    private EstudianteRepository estudianteRepository;
    private CarreraService carreraService;
    private InscripcionService inscripcionService;


    @Autowired
    public EstudianteService(EstudianteRepository estudianteRepository, CarreraService carreraService, InscripcionService inscripcionService){
        this.estudianteRepository = estudianteRepository;
        this.carreraService = carreraService;
        this.inscripcionService = inscripcionService;
    }

    public Iterable<Estudiante> traerTodos(){
        return this.estudianteRepository.findAll();
    }

    public Optional<Estudiante> traerPorId(long id){
        return this.estudianteRepository.findById(id);
    }

    public Iterable<Estudiante> traerPorGenero(String genero){
        return this.estudianteRepository.getAllByGenero(genero);
    }

    public Estudiante crearEstudiante(Estudiante estudiante) throws Exception{
        try {
            Optional<Estudiante> estudiante_existente = this.traerPorId(estudiante.getLegajo());
            // En caso de que el legajo ya esté insertado en la db...
            if(estudiante_existente.isPresent()) throw new Exception("El estudiante que intenta ingresar, ya existe.");

            return estudianteRepository.save(estudiante);
        } catch (Exception err) {
            throw new Exception(err.getMessage());
        }
    }

    public void eliminarPorId(long id){
        estudianteRepository.deleteById(id);
    }

    public boolean existeEstudiantePorId(long id){ return estudianteRepository.existsById(id); }

    public InscripcionDTO crearInscripcion(InscripcionDTO inscripcion_dto) throws Exception{
        try{
            Optional<Estudiante> estudiante = this.traerPorId(inscripcion_dto.getId_estudiante());
            if(estudiante.isEmpty()) throw new Exception("El alumno no existe");
            Optional<Carrera> carrera = carreraService.traerPorId(inscripcion_dto.getId_carrera());
            if(carrera.isEmpty()) throw new Exception("La carrera no existe");
            Inscripcion inscripcion = new Inscripcion(estudiante.get(), carrera.get(), inscripcion_dto.getAnio_inscripcion(), null);
            inscripcion = this.inscripcionService.inscribir(inscripcion);

            return new InscripcionDTO(inscripcion.getId().getId_estudiante_pk(), inscripcion.getId().getId_carrera_pk(), inscripcion.getAnio_inscripcion());
        }catch (Exception err){
            throw new Exception(err.getMessage());
        }
    }

    /*
    public Estudiante editar(Estudiante estudiante){
        return estudianteRepository.updateEstudiante(estudiante);
    }
    */
}
