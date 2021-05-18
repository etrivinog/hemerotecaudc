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
		
		Object object = "Hola!";
		
		return object;
	}

	@Override
	public Libro save(Libro entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Libro update(Libro entity) throws Exception {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Libro entity) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Optional<Libro> findById(Integer id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Libro> findAll() {
		return libroRepository.findAll();
	}

}
