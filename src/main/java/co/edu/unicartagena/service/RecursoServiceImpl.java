package co.edu.unicartagena.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicartagena.model.Recurso;
import co.edu.unicartagena.repository.RecursoRepository;

/**
 * @author AdrianaOtero
 *
 */
@Service
public class RecursoServiceImpl implements RecursoService{

	@Autowired
	RecursoRepository recursoRepository;

	@Override
	public Recurso save(Recurso entity) throws Exception {
		
		return recursoRepository.save(entity);
	}
	@Override
	public Recurso update(Recurso entity) throws Exception {
		return recursoRepository.save(entity);
	}

	@Override
	public void delete(Recurso entity) throws Exception {
		recursoRepository.delete(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		recursoRepository.deleteById(id);
	}

	@Override
	public Optional<Recurso> findById(Integer id) {
		return recursoRepository.findById(id);
	}

	@Override
	public List<Recurso> findAll() {
		return recursoRepository.findAll();
	}
	@Override
	public List<Recurso> findByTituloContainingIgnoreCaseOrderByTitulo(String titulo) {
		return recursoRepository.findByTituloContainingIgnoreCaseOrderByTitulo(titulo);
	}
	
}
