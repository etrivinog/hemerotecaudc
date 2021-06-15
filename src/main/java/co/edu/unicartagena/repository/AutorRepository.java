/**
 * 
 */
package co.edu.unicartagena.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicartagena.model.Autor;

/**
 * @author AdrianaOtero
 *
 */
public interface AutorRepository  extends JpaRepository<Autor, Integer>{
						   
	public Optional<Autor> findByNombreContainingIgnoreCase(String nombre);

}
