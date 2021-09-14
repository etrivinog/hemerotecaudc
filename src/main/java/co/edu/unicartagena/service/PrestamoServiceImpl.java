package co.edu.unicartagena.service;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicartagena.dao.PrestamoDao;
import co.edu.unicartagena.dao.RestMessage;
import co.edu.unicartagena.dao.exceptions.GeneralException;
import co.edu.unicartagena.model.Ejemplar;
import co.edu.unicartagena.model.Estado;
import co.edu.unicartagena.model.Libro;
import co.edu.unicartagena.model.Prestamo;
import co.edu.unicartagena.repository.EjemplarRepository;
import co.edu.unicartagena.repository.EstudianteRepository;
import co.edu.unicartagena.repository.LibroRepository;
import co.edu.unicartagena.repository.PrestamoRepository;

/**
 * @author AdrianaOtero
 *
 */
@Service
public class PrestamoServiceImpl implements PrestamoService{

	@Autowired
	PrestamoRepository prestamoRepository;

	@Autowired
	EjemplarService ejemplarService;
	
	@Autowired
	EstudianteService estudianteService;

	@Autowired
	LibroRepository libroRepository;

	@Override
	public Prestamo save(Prestamo entity) throws GeneralException {
		
		entity.setEstado("E");
		
		return prestamoRepository.save(entity);
	}

	@Override
	public Prestamo approve(Integer idPrestamo, Integer idEjemplar) throws Exception {

		Optional<Prestamo> prestamoOp = prestamoRepository.findById(idPrestamo);
		
		Prestamo prestamo;
		
		if(prestamoOp.isPresent()) {
			prestamo = prestamoOp.get();
			
			java.util.Date date = new java.util.Date();
			
			Date sqlDate = new Date(date.getTime());
			
			prestamo.setFechaInicio(sqlDate);
			prestamo.setEstado("A");
			
			//Actualiza el estado del ejemplar prestado TODO
			Optional<Ejemplar> ejemplarOpt = ejemplarService.findById(idEjemplar);
			if (ejemplarOpt.isPresent()) {
				
				// Valida si el ejemplar está disponible
				if (ejemplarOpt.get().getIdestado() == Estado.UNAVAILABLE_STATUS) {
					throw new Exception("El ejemplar seleccionado no está disponible!");
				}
				
				// Actualiza el ejemplar del préstamo
				prestamo.setIdEjemplar(idEjemplar);
				
				// Cambia el estado del ejemplar
				Ejemplar ejemplar = ejemplarOpt.get();
				ejemplar.setIdestado(Estado.UNAVAILABLE_STATUS);
				ejemplarService.update(ejemplar);
			}
			
			return prestamoRepository.save(prestamo);
		}
		
		return null;
		
	}

	@Override
	public Prestamo finalize(Integer idPrestamo) throws Exception {

		Optional<Prestamo> prestamoOp = prestamoRepository.findById(idPrestamo);
		
		Prestamo prestamo;
		
		if(prestamoOp.isPresent()) {
			prestamo = prestamoOp.get();
			
			java.util.Date date = new java.util.Date();
			
			Date sqlDate = new Date(date.getTime());
			
			prestamo.setFechaFin(sqlDate);
			prestamo.setEstado("T");
			
			// Actualiza el estado del ejemplar
			Optional<Ejemplar> ejemplarOpt = ejemplarService.findById(prestamo.getIdEjemplar());
			if (ejemplarOpt.isPresent()) {
				Ejemplar ejemplar = ejemplarOpt.get();
				ejemplar.setIdestado(Estado.AVAILABLE_STATUS);
				ejemplarService.save(ejemplar);
			}
			
			return prestamoRepository.save(prestamo);
		}
		
		return null;
		
	}

	@Override
	public Prestamo reject(Integer idPrestamo) throws Exception {

		Optional<Prestamo> prestamoOp = prestamoRepository.findById(idPrestamo);
		
		Prestamo prestamo;
		
		if(prestamoOp.isPresent()) {
			prestamo = prestamoOp.get();
			
			prestamo.setEstado("R");
			
			return prestamoRepository.save(prestamo);
		}
		
		return null;
		
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
	public List<Prestamo> findByCodEstudiante(String cod) {
		return prestamoRepository.findByCodEstudiante(cod);
	}

	@Override
	public List<PrestamoDao> findAllByOrderByEstado() {
		
		List<Prestamo> prestamos = prestamoRepository.findAllByOrderByEstado();
		List<PrestamoDao> prestamosDao = new ArrayList<PrestamoDao>();
		
		String libroTittle = "", ejemplarDesc = "";
		Integer idLibro = null;
		Optional<Ejemplar> ejemplar;
		Optional<Libro> libro;
		
		// Hace el mapeo de Ejemplar a EjemplarDao
		for (Prestamo prestamo : prestamos) {
			
			if (prestamo.getIdEjemplar() != null) {
				ejemplar = ejemplarService.findById(prestamo.getIdEjemplar());
				
				if (ejemplar.isPresent()) {
					ejemplarDesc = ejemplar.get().getDescripcion();
					
					idLibro = ejemplar.get().getLibroid();
					libro = libroRepository.findById(idLibro);
					
					if (libro.isPresent()) {
						libroTittle = libro.get().getNombre();
					}
				}
			}
			
			prestamosDao.add(new PrestamoDao(prestamo.getIdprestamos(), prestamo.getFechaInicio(), prestamo.getFechaFin(), 
					idLibro, libroTittle, prestamo.getIdEjemplar(), ejemplarDesc, prestamo.getCodEstudiante().toString(), prestamo.getEstado()));
		}
		
		return prestamosDao;
	}

	@Override
	public Object save(PrestamoDao prestamoDao) throws GeneralException {
		
		if (prestamoDao.getCodEstudiante() == null) {
			throw new GeneralException("Ingrese el código del estudiante!");
		}else if(!estudianteService.findByCodigo_estudiantil(prestamoDao.getCodEstudiante()).isPresent() ) {
			throw new GeneralException("No exite un estudiante con el código ingresado!");
		}else if(ejemplarService.countByLibroidAndEstado(prestamoDao.getIdLibro(), Estado.AVAILABLE_STATUS) <= 0) {
			throw new GeneralException("No hay ejemplares disponibles para este libro!");
		}
		
		Prestamo prestamo = new Prestamo();
		prestamo.setIdprestamos(prestamoDao.getIdprestamos());
		try {
			prestamo.setCodEstudiante(prestamoDao.getCodEstudiante());
		} catch (NumberFormatException e) {
			throw new GeneralException("No exite un estudiante con el código ingresado!");
		}
		prestamo.setEstado(prestamoDao.getEstado());
		prestamo.setFechaFin(prestamoDao.getFechaFin());
		prestamo.setFechaInicio(prestamoDao.getFechaInicio());
		
		System.out.println("prestamoDao.getIdLibro(): "+prestamoDao.getIdLibro());
		
		//Busca un ejemplar disponible
		List<Ejemplar> ejemplares = ejemplarService.findByLibroidAndIdestado(prestamoDao.getIdLibro(), Estado.AVAILABLE_STATUS);
		System.out.println("ejemplares.size(): "+ejemplares.size());
		
		if (ejemplares.isEmpty()) {
			throw new GeneralException("No hay ejemplares disponibles para este libro!");
		}
		else {
			prestamo.setIdEjemplar(ejemplares.get(0).getIdEjemplar());
			prestamo.getIdEjemplar();
		}
		
		prestamo = save(prestamo);
		
		//Actualiza el ID del préstamo con el generado por la DB
		prestamoDao.setIdprestamos(prestamo.getIdprestamos());
		
		return prestamoDao;
	}
	
}
