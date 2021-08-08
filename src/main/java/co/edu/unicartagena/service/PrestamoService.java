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

	public Prestamo approve(Integer idPrestamo)  throws Exception;
	
	public Prestamo reject(Integer idPrestamo)  throws Exception;
	
	public Prestamo finalize(Integer idPrestamo) throws Exception;
	
}