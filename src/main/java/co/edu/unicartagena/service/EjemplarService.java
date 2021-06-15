package co.edu.unicartagena.service;

import java.util.Optional;

import co.edu.unicartagena.model.Ejemplar;

public interface EjemplarService extends GenericService<Ejemplar, Integer> {
	
	public Optional<Ejemplar> findByDescripcionContainingIgnoreCase(String descripcion);
	
}
