/**
 * 
 */
package co.edu.unicartagena.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicartagena.model.Autor;
import co.edu.unicartagena.repository.AutorRepository;

/**
 * @author AdrianaOtero
 *
 */
@Service
public class AutorServiceImpl implements AutorService {
	
	@Autowired
	AutorRepository autorRepository;
	
	@Override
	public Autor save(Autor entity) throws Exception {
		return autorRepository.save(entity);
	}

	@Override
	public Autor update(Autor entity) throws Exception {
		
		//TODO Validate if author exists before saving
		return autorRepository.save(entity);
	}

	@Override
	public void delete(Autor entity) throws Exception {
		autorRepository.delete(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		autorRepository.deleteById(id);
	}

	@Override
	public Optional<Autor> findById(Integer id) {
		return autorRepository.findById(id);
	}

	@Override
	public List<Autor> findAll() {
		return autorRepository.findAll();
	}

	@Override
	public Optional<Autor> findByNombreContainingIgnoreCase(String nombre) {
		return autorRepository.findByNombreContainingIgnoreCase(nombre);
	}
	
}
