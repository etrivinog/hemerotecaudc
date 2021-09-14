package co.edu.unicartagena.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import co.edu.unicartagena.model.Estudiante;
import co.edu.unicartagena.repository.EstudianteRepository;

/**
 * @author AdrianaOtero
 *
 */
@Service
public class EstudianteServiceImpl implements EstudianteService{

	@Autowired
	EstudianteRepository estudianteRepository;

	@Override
	public Estudiante save(Estudiante estudiante) throws Exception {
		
		//Se establece la contraseña por defecto como la identificación del estudiante
		estudiante.setPass(estudiante.getIdentificacion());
		
		return estudianteRepository.save(estudiante);
	}

	@Override
	public Estudiante update(Estudiante entity) throws Exception {
		
		Estudiante e = estudianteRepository.findById(entity.getIdEstudiante()).get();
		
		entity.setPass(e.getPass());
		
		return estudianteRepository.save(entity);
		
	}

	@Override
	public void delete(Estudiante entity) throws Exception {
		
		estudianteRepository.delete(entity);
		
	}

	@Override
	public void deleteById(Integer id) throws Exception {
		
		estudianteRepository.deleteById(id);
		
	}

	@Override
	public Optional<Estudiante> findById(Integer id) {
		return estudianteRepository.findById(id);
	}

	@Override
	public List<Estudiante> findAll() {
		return estudianteRepository.findAll();
	}
	
	@Override
	public Optional<List<Estudiante>> findByNombresContainingIgnoreCaseOrderByNombres(String nombres) {
		return estudianteRepository.findByNombresContainingIgnoreCaseOrderByNombres(nombres);
	}

	@Override
	public List<Estudiante> findAllByOrderByNombre() {
		System.out.println(estudianteRepository.findByEmailAndPass("aoterot@unicartagena.edu.co", "1143397343").get().get(0).getNombres());
		return estudianteRepository.findAllByOrderByNombres();
	}

	@Override
	public Optional<List<Estudiante>> findByEmailAndPass(String email, String pass) {
		return estudianteRepository.findByEmailAndPass(email, pass);
	}

	@Override
	public Optional<Estudiante> findByCodigo_estudiantil(String codigo) {
		return estudianteRepository.findByCodigoestudiantil(codigo);
	}

}
