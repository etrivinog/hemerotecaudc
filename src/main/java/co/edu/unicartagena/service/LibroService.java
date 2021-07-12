/**
 * 
 */
package co.edu.unicartagena.service;

import java.util.List;
import java.util.Optional;

import co.edu.unicartagena.model.Libro;

/**
 * @author AdrianaOtero
 *
 */
public interface LibroService extends GenericService<Libro, Integer> {
	
	public Object test();
	
	public Optional<List<Libro>> findByNombreContainingIgnoreCaseOrderByNombre(String nombre);
	
	public List<Libro> findAllByOrderByNombre();

}
