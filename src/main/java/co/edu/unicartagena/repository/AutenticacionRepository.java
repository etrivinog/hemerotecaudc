package co.edu.unicartagena.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicartagena.model.Autenticacion;

public interface AutenticacionRepository  extends JpaRepository<Autenticacion, Integer>{
	
	public Optional<List<Autenticacion>> findByNombreAndCodigoDeInicio(String nombre, String codigo);

}
