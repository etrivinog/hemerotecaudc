/**
 * 
 */
package co.edu.unicartagena.service;

import java.util.List;

import co.edu.unicartagena.model.Prestamo;
import co.edu.unicartagena.model.Recurso;

/**
 * @author AdrianaOtero
 *
 */
public interface RecursoService extends GenericService<Recurso, Integer> {

	public List<Recurso> findByTituloContainingIgnoreCaseOrderByTitulo(String titulo);
	
}
