package co.edu.unicartagena.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicartagena.model.Autenticacion;
import co.edu.unicartagena.repository.AutenticacionRepository;

/**
 * @author AdrianaOtero
 *
 */
@Service
public class AutenticacionServiceImpl implements AutenticacionService{

	@Autowired
	AutenticacionRepository autenticacionRepository;

	@Override
	public Autenticacion save(Autenticacion entity) throws Exception {
		return autenticacionRepository.save(entity);
	}

	@Override
	public Autenticacion update(Autenticacion entity) throws Exception {
		return autenticacionRepository.save(entity);
	}

	@Override
	public void delete(Autenticacion entity) throws Exception {
		autenticacionRepository.delete(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		autenticacionRepository.deleteById(id);
	}

	@Override
	public Optional<Autenticacion> findById(Integer id) {
		return autenticacionRepository.findById(id);
	}

	@Override
	public List<Autenticacion> findAll() {
		return autenticacionRepository.findAll();
	}

	@Override
	public Object login(String nombre, String codigo) {
		
		if(autenticacionRepository.findByNombreAndCodigoDeInicio(nombre, codigo).isPresent()) {
			return "OK";
		}
		
		return "";
	}
	
}
