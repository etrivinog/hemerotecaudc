package co.edu.unicartagena.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicartagena.model.Prestamo;
import co.edu.unicartagena.repository.PrestamoRepository;

/**
 * @author AdrianaOtero
 *
 */
@Service
public class PrestamoServiceImpl implements PrestamoService{

	@Autowired
	PrestamoRepository prestamoRepository;

	@Override
	public Prestamo save(Prestamo entity) throws Exception {
		return prestamoRepository.save(entity);
	}

	@Override
	public Prestamo update(Prestamo entity) throws Exception {
		return prestamoRepository.save(entity);
	}

	@Override
	public void delete(Prestamo entity) throws Exception {
		prestamoRepository.delete(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		prestamoRepository.deleteById(id);
	}

	@Override
	public Optional<Prestamo> findById(Integer id) {
		return prestamoRepository.findById(id);
	}

	@Override
	public List<Prestamo> findAll() {
		return prestamoRepository.findAll();
	}

	@Override
	public List<Prestamo> findByCodEstudiante(Integer cod) {
		return prestamoRepository.findByCodEstudiante(cod);
	}
	
}
