package co.edu.unicartagena.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicartagena.model.Recurso;

public interface RecursoRepository  extends JpaRepository<Recurso, Integer>{
	
	public List<Recurso> findByTituloContainingIgnoreCaseOrderByTitulo(String titulo);

}
