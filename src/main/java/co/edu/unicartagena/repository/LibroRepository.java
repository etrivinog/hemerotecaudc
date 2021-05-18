package co.edu.unicartagena.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import co.edu.unicartagena.model.Libro;

public interface LibroRepository  extends JpaRepository<Libro, Integer>{

}
