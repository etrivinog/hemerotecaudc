package co.edu.unicartagena.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicartagena.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Integer> {

	public Optional<List<Estudiante>> findByNombresContainingIgnoreCaseOrderByNombres(String nombre);
	
	public Optional<List<Estudiante>> findByEmailAndPass(String email, String pass);

	public List<Estudiante> findAllByOrderByNombres();

}
