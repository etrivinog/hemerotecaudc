package co.edu.unicartagena.service;

import java.sql.Date;
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
		
		entity.setEstado("E");
		
		return prestamoRepository.save(entity);
	}

	@Override
	public Prestamo approve(Integer idPrestamo) throws Exception {

		Optional<Prestamo> prestamoOp = prestamoRepository.findById(idPrestamo);
		
		Prestamo prestamo;
		
		if(prestamoOp.isPresent()) {
			prestamo = prestamoOp.get();
			
			java.util.Date date = new java.util.Date();
			
			Date sqlDate = new Date(date.getTime());
			
			prestamo.setFechaInicio(sqlDate);
			prestamo.setEstado("A");
			
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
	public List<Prestamo> findByCodEstudiante(Integer cod) {
		return prestamoRepository.findByCodEstudiante(cod);
	}
	
}
