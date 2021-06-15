/**
 * 
 */
package co.edu.unicartagena.service;

import java.util.Optional;

import co.edu.unicartagena.model.Autor;

/**
 * @author AdrianaOtero
 *
 */
public interface AutorService extends GenericService<Autor, Integer> {

	public Optional<Autor> findByNombreContainingIgnoreCase(String nombre);

}
