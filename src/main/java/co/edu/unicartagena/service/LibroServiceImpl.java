package co.edu.unicartagena.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicartagena.model.Libro;
import co.edu.unicartagena.repository.LibroRepository;

/**
 * @author AdrianaOtero
 *
 */
@Service
public class LibroServiceImpl implements LibroService{

	@Autowired
	LibroRepository libroRepository;
	
	@Override
	public Object test() {
		
		String object = "OK";
		
		return object;
	}

	@Override
	public Libro save(Libro entity) throws Exception {
		return libroRepository.save(entity);
	}

	@Override
	public Libro update(Libro entity) throws Exception {
		// TODO Validate if exists before
		return libroRepository.save(entity);
	}

	@Override
	public void delete(Libro entity) throws Exception {
		libroRepository.delete(entity);
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		libroRepository.deleteById(id);
	}

	@Override
	public Optional<Libro> findById(Integer id) {
		return libroRepository.findById(id);
	}

	@Override
	public List<Libro> findAll() {
		return libroRepository.findAll();
	}
	
	@Override
	public List<Libro> findAllByOrderByNombre(){
		return libroRepository.findAllByOrderByNombre();
	}

	@Override
	public Optional<List<Libro>> findByNombreContainingIgnoreCaseOrderByNombre(String nombre) {
		
		Optional<List<Libro>> libro = libroRepository.findByNombreContainingIgnoreCaseOrderByNombre(nombre);
		
		if(libro.isPresent()) {
			return libro;
		}
		
		return null;
	}

}
