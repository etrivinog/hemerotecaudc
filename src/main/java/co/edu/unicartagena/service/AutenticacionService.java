/**
 * 
 */
package co.edu.unicartagena.service;

import co.edu.unicartagena.model.Autenticacion;

/**
 * @author AdrianaOtero
 *
 */
public interface AutenticacionService extends GenericService<Autenticacion, Integer> {

	public Object login(String nombre, String codigo);
	
}
