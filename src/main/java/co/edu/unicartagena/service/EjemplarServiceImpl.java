package co.edu.unicartagena.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicartagena.model.Ejemplar;
import co.edu.unicartagena.repository.EjemplarRepository;

@Service
public class EjemplarServiceImpl implements EjemplarService{
	
	private static final int ESTADO_DISPONIBLE = 1;
	
	@Autowired
	EjemplarRepository ejemplarRepository;
	
	@Override
	public Ejemplar save(Ejemplar entity) throws Exception {
		
		//Coloca el estado como dispnible
		entity.setIdestado(ESTADO_DISPONIBLE);
		
		return ejemplarRepository.save(entity);
		
	}

	@Override
	public Ejemplar update(Ejemplar entity) throws Exception {
		return ejemplarRepository.save(entity);
	}

	@Override
	public void delete(Ejemplar entity) throws Exception {
		ejemplarRepository.delete(entity);		
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		ejemplarRepository.deleteById(id);
	}

	@Override
	public Optional<Ejemplar> findById(Integer id) {
		return ejemplarRepository.findById(id);
	}

	@Override
	public List<Ejemplar> findAll() {
		return ejemplarRepository.findAll();
	}

	@Override
	public Optional<Ejemplar> findByDescripcionContainingIgnoreCase(String descripcion) {
		return ejemplarRepository.findByDescripcionContainingIgnoreCase(descripcion);
	}

}
