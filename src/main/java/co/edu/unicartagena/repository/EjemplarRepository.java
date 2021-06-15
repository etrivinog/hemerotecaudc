/**
 * 
 */
package co.edu.unicartagena.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicartagena.model.Ejemplar;

/**
 * @author AdrianaOtero
 *
 */
public interface EjemplarRepository extends JpaRepository<Ejemplar, Integer> {
	
	public Optional<Ejemplar> findByDescripcionContainingIgnoreCase(String descripcion);
	
}
