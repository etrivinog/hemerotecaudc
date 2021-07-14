package co.edu.unicartagena.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicartagena.model.Prestamo;

public interface PrestamoRepository  extends JpaRepository<Prestamo, Integer>{
	
	public List<Prestamo> findByCodEstudiante(Integer cod);

}
