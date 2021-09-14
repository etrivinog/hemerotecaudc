package co.edu.unicartagena.service;

import java.util.List;
import java.util.Optional;

import co.edu.unicartagena.dao.EjemplarDescriptionDao;
import co.edu.unicartagena.model.Ejemplar;

public interface EjemplarService extends GenericService<Ejemplar, Integer> {
	
	public Optional<Ejemplar> findByDescripcionContainingIgnoreCase(String descripcion);

	public Object findByLibroid(Integer libroid);

	public Integer countByLibroidAndEstado(Integer libroid, Integer estado);
	
	public List<EjemplarDescriptionDao> getEjemplarListByLibro(Integer libroId);

	public List<Ejemplar> findByLibroidAndIdestado(Integer libroId, Integer idEstado);
}
