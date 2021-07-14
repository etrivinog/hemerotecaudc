/**
 * 
 */
package co.edu.unicartagena.service;

import java.util.List;

import co.edu.unicartagena.model.Prestamo;

/**
 * @author AdrianaOtero
 *
 */
public interface PrestamoService extends GenericService<Prestamo, Integer> {

	public List<Prestamo> findByCodEstudiante(Integer cod);
	
}
