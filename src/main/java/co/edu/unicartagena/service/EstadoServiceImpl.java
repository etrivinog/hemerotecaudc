/**
 * 
 */
package co.edu.unicartagena.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicartagena.model.Estado;
import co.edu.unicartagena.repository.EstadoRepository;

/**
 * @author AdrianaOtero
 *
 */
@Service
public class EstadoServiceImpl implements EstadoService {
	
	@Autowired
	EstadoRepository estadoRepository;
	
	@Override
	public Estado save(Estado entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Estado update(Estado entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Estado entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Estado> findById(Integer id) {
		return estadoRepository.findById(id);
	}

	@Override
	public List<Estado> findAll() {
		return estadoRepository.findAll();
	}

}
