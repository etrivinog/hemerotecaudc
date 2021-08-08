package co.edu.unicartagena.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicartagena.dao.LibroDao;
import co.edu.unicartagena.model.Ejemplar;
import co.edu.unicartagena.model.Libro;
import co.edu.unicartagena.repository.EjemplarRepository;
import co.edu.unicartagena.repository.LibroRepository;

/**
 * @author AdrianaOtero
 *
 */
@Service
public class LibroServiceImpl implements LibroService{

	@Autowired
	LibroRepository libroRepository;

	@Autowired
	EjemplarRepository ejemplarRepository;
	
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
	public List<LibroDao> findAllByOrderByNombre(){

		List<Libro> libros = libroRepository.findAllByOrderByNombre();
		
		List<LibroDao> librosDao =  new ArrayList<LibroDao>();
		
		LibroDao lib;
		for(Libro libro: libros) {
			lib = new LibroDao(
					libro.getLibroId(),
					libro.getNombre(),
					libro.getReferencia(),
					libro.getFechaIngreso(),
					libro.getAnio(),
					ejemplarRepository.countByLibroidAndIdestado(libro.getLibroId(), 1),
					libro.getTipoRegistro(),
					libro.getNumRegistro(),
					libro.getTipoDivulgacion()
					);
			librosDao.add(lib);
		}
		
		//int disponibles = ejemplarRepository.countByLibroidAndEstado(libroid, estado);
		
		return librosDao;
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
