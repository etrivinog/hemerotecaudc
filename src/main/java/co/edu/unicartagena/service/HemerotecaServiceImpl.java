package co.edu.unicartagena.service;

import org.springframework.stereotype.Service;

/**
 * @author AdrianaOtero
 *
 */
@Service
public class HemerotecaServiceImpl implements HemerotecaService{

	@Override
	public Object test() {
		
		Object object = "Hola!";
		
		return object;
	}

}
