package com.example.mappingrelations;

import com.example.mappingrelations.models.Carrera;
import com.example.mappingrelations.models.Estudiante;
import com.example.mappingrelations.models.Inscripcion;
import com.example.mappingrelations.repositories.CarreraRepository;
import com.example.mappingrelations.repositories.EstudianteRepository;
import com.example.mappingrelations.repositories.InscripcionRepository;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@RequiredArgsConstructor
public class MappingRelationsApplication {
	private final EstudianteRepository estudianteRepository;
	private final CarreraRepository carreraRespository;
	private final InscripcionRepository inscripcionRepository;

	public static void main(String[] args) {
		SpringApplication.run(MappingRelationsApplication.class, args);
	}

	@PostConstruct
	public void init() {
		/*
		Estudiante es1 = new Estudiante((long)234323, "Miguel", "Campos", "Tandil", (long)34555666, 24, "Masculino");
		Estudiante es2 = new Estudiante((long)445566, "Josefina", "Torres", "Tandil", (long)45666777, 34, "Femenino");

		estudianteRepository.guardar(es1);
		estudianteRepository.guardar(es2);

		Carrera carr1 = new Carrera("TUDAI");
		carreraRespository.guardar(carr1);

		Inscripcion ins1 = new Inscripcion(estudianteRepository.traerPorId((long)445566).get(), carreraRespository.traerPorId((long)1).get(), 2021, 2023);
		Inscripcion ins2 = new Inscripcion(estudianteRepository.traerPorId((long)234323).get(), carreraRespository.traerPorId((long)1).get(), 2015, 2022);
		// Intento nuevamente crear una inscripcion, pero ya existe ese conjunto de PKs, deberia NO guardarla en la db (no tira error)
		Inscripcion ins3 = new Inscripcion(estudianteRepository.traerPorId((long)234323).get(), carreraRespository.traerPorId((long)1).get(), 2015, 2022);

		inscripcionRepository.guardar(ins1);
		inscripcionRepository.guardar(ins2);

		estudianteRepository.eliminarPorId((long)234323);
		*/
	}
}
