package co.edu.unicartagena.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicartagena.model.Libro;

public interface LibroRepository  extends JpaRepository<Libro, Integer>{
	
	public Optional<List<Libro>> findByNombreContainingIgnoreCaseOrderByNombre(String nombre);
	
	public List<Libro> findAllByOrderByNombre();

}
