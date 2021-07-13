/**
 * 
 */
package co.edu.unicartagena.service;

import java.util.List;
import java.util.Optional;

import co.edu.unicartagena.model.Estudiante;

/**
 * @author AdrianaOtero
 *
 */
public interface EstudianteService extends GenericService<Estudiante, Integer> {
	
	public Optional<List<Estudiante>> findByNombresContainingIgnoreCaseOrderByNombres(String nombres);

	public Optional<List<Estudiante>> findByEmailAndPass(String email, String pass);
	
	public List<Estudiante> findAllByOrderByNombre();

}
