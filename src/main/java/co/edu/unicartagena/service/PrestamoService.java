/**
 * 
 */
package co.edu.unicartagena.service;

import java.util.List;

import co.edu.unicartagena.dao.PrestamoDao;
import co.edu.unicartagena.dao.exceptions.GeneralException;
import co.edu.unicartagena.model.Prestamo;

/**
 * @author AdrianaOtero
 *
 */
public interface PrestamoService extends GenericService<Prestamo, Integer> {

	public List<PrestamoDao> findByCodEstudiante(String cod) throws GeneralException;

	public Prestamo approve(Integer idPrestamo, Integer idEjemplar)  throws Exception;
	
	public Prestamo reject(Integer idPrestamo)  throws Exception;
	
	public Prestamo finalize(Integer idPrestamo) throws Exception;

	public List<PrestamoDao> findAllByOrderByEstado();
	
	public Object save(PrestamoDao prestamo) throws GeneralException;
	
}
