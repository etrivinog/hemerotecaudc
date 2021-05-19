package co.edu.unicartagena;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicartagena.model.Libro;
import co.edu.unicartagena.service.LibroService;

@SpringBootApplication
@RestController
public class HemerotecaudcApplication {
	
	@Autowired
	LibroService libroService;

	@GetMapping("/test")
	public Object test() {
		
		return libroService.test();
		
	}

	@GetMapping("/error")
	public Object error() {
		
		return "Error";
		
	}

	@GetMapping("/findAllBooks")
	public List<Libro> findAll() {
		return libroService.findAll();
	}

	@GetMapping("/searchBook")
	public Optional<Libro> searchBook(@RequestParam(name = "name") String nombre) {
		return libroService.findByNombreContaining(nombre);
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HemerotecaudcApplication.class, args);
	}

}
