/**
 * 
 */
package co.edu.unicartagena.service;

import java.util.Optional;

import co.edu.unicartagena.model.Libro;

/**
 * @author AdrianaOtero
 *
 */
public interface LibroService extends GenericService<Libro, Integer> {
	
	public Object test();
	
	public Optional<Libro> findByNombreContaining(String nombre);

}
