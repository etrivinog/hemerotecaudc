package co.edu.unicartagena;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicartagena.dao.EjemplarDescriptionDao;
import co.edu.unicartagena.dao.LibroDao;
import co.edu.unicartagena.dao.PrestamoDao;
import co.edu.unicartagena.dao.exceptions.GeneralException;
import co.edu.unicartagena.model.Autor;
import co.edu.unicartagena.model.Ejemplar;
import co.edu.unicartagena.model.Estado;
import co.edu.unicartagena.model.Estudiante;
import co.edu.unicartagena.model.Libro;
import co.edu.unicartagena.model.Prestamo;
import co.edu.unicartagena.model.Recurso;
import co.edu.unicartagena.service.AutenticacionService;
import co.edu.unicartagena.service.AutorService;
import co.edu.unicartagena.service.EjemplarService;
import co.edu.unicartagena.service.EstadoService;
import co.edu.unicartagena.service.EstudianteService;
import co.edu.unicartagena.service.LibroService;
import co.edu.unicartagena.service.PrestamoService;
import co.edu.unicartagena.service.RecursoService;

@SpringBootApplication
@RestController
@CrossOrigin(origins = "*", methods= {RequestMethod.GET,RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE})
public class HemerotecaudcApplication {
	
	@Autowired
	LibroService libroService;

	@Autowired
	AutorService autorService;

	@Autowired
	EstudianteService estudianteService;

	@Autowired
	EjemplarService ejemplarService;

	@Autowired
	PrestamoService prestamoService;

	@Autowired
	AutenticacionService autenticacionService;
	
	@Autowired
	EstadoService estadoService;
	
	@Autowired
	RecursoService recursoService;

	@GetMapping("/api/v1/verifyServer")
	public Object test() {
		
		return libroService.test();
		
	}

	@GetMapping("/error")
	public Object error() {
		
		return "Error";
		
	}

	/************************************* Books requests ****************************************/
	@GetMapping("/api/v1/books/findAll")
	public List<LibroDao> findAllBooks() {
		return libroService.findAllByOrderByNombre();
	}
	
	@GetMapping("/api/v1/books/search")
	public Optional<List<Libro>> searchBook(@RequestParam(name = "name") String nombre) {
		return libroService.findByNombreContainingIgnoreCaseOrderByNombre(nombre);
	}

	@PostMapping("/api/v1/books/save")
	@ResponseBody
	public Libro saveBook(@RequestBody Libro libro) throws Exception {
		try {
			System.out.println("libro.nombre: "+libro.getNombre());
			return libroService.save(libro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			throw e;
		}
		
	}

	@PutMapping("/api/v1/books/update")
	@ResponseBody
	public Libro updateBook(@RequestBody Libro libro) {
		try {
			System.out.println("libro.nombre: "+libro.getNombre());
			return libroService.update(libro);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

	@DeleteMapping("/api/v1/books/delete")
	public void deleteBookById(@RequestParam(name = "libroId") Integer libroId) {
		try {
			libroService.deleteById(libroId);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		SpringApplication.run(HemerotecaudcApplication.class, args);
	}
	
	/************************************* Author requests ****************************************/

	@GetMapping("/api/v1/author/findAll")
	public List<Autor> findAllAuthor() {
		return autorService.findAll();
	}

	@GetMapping("/api/v1/author/search")
	public Optional<Autor> searchAuthor(@RequestParam(name = "name") String nombre) {
		return autorService.findByNombreContainingIgnoreCase(nombre);
	}

	@PostMapping("/api/v1/author/save")
	@ResponseBody
	public Autor saveAuthor(@RequestBody Autor autor) {
		try {
			System.out.println("autor.nombre: "+autor.getNombre());
			return autorService.save(autor);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	/************************************* Ejemplar requests ****************************************/
	
	@GetMapping("/api/v1/ejemplar/findAll")
	public List<Ejemplar> findAllEjemplar() {
		return ejemplarService.findAll();
	}

	@GetMapping("/api/v1/ejemplar/findByBook")
	public Object findByBook(@RequestParam(name = "book") Integer libroid) {
		return ejemplarService.findByLibroid(libroid);
	}
	
	@GetMapping("/api/v1/ejemplar/getCopyDescByBook")
	public List<EjemplarDescriptionDao> getCopyDescByBook(@RequestParam(name = "book") Integer libroid) {
		return ejemplarService.getEjemplarListByLibro(libroid);
	}

	@GetMapping("/api/v1/ejemplar/search")
	public Optional<Ejemplar> searchEjemplar(@RequestParam(name = "description") String description) {
		return ejemplarService.findByDescripcionContainingIgnoreCase(description);
	}

	@PostMapping("/api/v1/ejemplar/save")
	@ResponseBody
	public Ejemplar saveEjemplar(@RequestBody Ejemplar elemplar) {
		try {
			return ejemplarService.save(elemplar);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@PutMapping("/api/v1/ejemplar/update")
	@ResponseBody
	public Ejemplar updateEjemplar(@RequestBody Ejemplar ejemplar) {
		try {
			return ejemplarService.update(ejemplar);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@DeleteMapping("/api/v1/ejemplar/delete")
	public void deleteEjemplarById(@RequestParam(name = "idEjemplar") Integer idEjemplar) {
		try {
			ejemplarService.deleteById(idEjemplar);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/************************************* Estudiantes requests ****************************************/
	

	@GetMapping("/api/v1/students/findAll")
	public List<Estudiante> findAllStudents() {
		return estudianteService.findAllByOrderByNombre();
	}
	
	@GetMapping("/api/v1/students/search")
	public Optional<List<Estudiante>> searchStudent(@RequestParam(name = "name") String nombres) {
		return estudianteService.findByNombresContainingIgnoreCaseOrderByNombres(nombres);
	}

	@PostMapping("/api/v1/students/save")
	@ResponseBody
	public Estudiante saveStudent(@RequestBody Estudiante estudiante) {
		try {
			System.out.println("estudiante.nombres: "+estudiante.getNombres());
			return estudianteService.save(estudiante);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@PutMapping("/api/v1/students/update")
	@ResponseBody
	public Estudiante updateStudent(@RequestBody Estudiante estudiante) {
		try {
			System.out.println("libro.nombre: "+estudiante.getNombres());
			return estudianteService.update(estudiante);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@DeleteMapping("/api/v1/students/delete")
	public void deleteStudentById(@RequestParam(name = "idEstudiante") Integer idEstudiante) {
		try {
			estudianteService.deleteById(idEstudiante);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/************************************* Prestamos requests ****************************************/
	

	@GetMapping("/api/v1/lends/findAll")
	public List<PrestamoDao> findAllLends() {
		return prestamoService.findAllByOrderByEstado();
	}

	@GetMapping("/api/v1/lends/findByStudentCode")
	public List<Prestamo> listLendsByStudentCode(@RequestParam(name = "code") String code) {
		return prestamoService.findByCodEstudiante(code);
	}
	
	@PostMapping("/api/v1/lends/save")
	@ResponseBody
	public Object saveLend(@RequestBody PrestamoDao prestamo) throws GeneralException{
		
		return prestamoService.save(prestamo);
		
	}

	@PutMapping("/api/v1/lends/approve")
	@ResponseBody
	public Prestamo approveLend(@RequestParam(name = "idprestamos") Integer idPrestamo, @RequestParam(name = "idEjemplar") Integer idEjemplar) throws Exception {
		return prestamoService.approve(idPrestamo, idEjemplar);
	}

	@DeleteMapping("/api/v1/lends/reject")
	public void rejectL(@RequestParam(name = "idprestamos") Integer idPrestamo) throws Exception {
		prestamoService.reject(idPrestamo);
	}

	@DeleteMapping("/api/v1/lends/finalize")
	public void finalizeLend(@RequestParam(name = "idprestamos") Integer idPrestamo) throws Exception {
		prestamoService.finalize(idPrestamo);
	}

	/************************************* Autentica requests ****************************************/

	@GetMapping("/api/v1/auth/login")
	public Object listLendsByStudentCode(
													@RequestParam(name = "user") String nombre,
													@RequestParam(name = "pass") String codigo
												) {
		return autenticacionService.login(nombre, codigo);
	}
	
	
	/************************************* Statuses requests ****************************************/
	
	@GetMapping("/api/v1/status/findAll")
	public List<Estado> findAllStatus() {
		return estadoService.findAll();
	}
	

	/************************************* Recurso requests ****************************************/
	@GetMapping("/api/v1/tesis/findAll")
	public List<Recurso> findAll() {
		return recursoService.findAll();
	}
	
	@PostMapping("/api/v1/tesis/save")
	@ResponseBody
	public Recurso saveTesis(@RequestBody Recurso tesis) {
		try {
			return recursoService.save(tesis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@PutMapping("/api/v1/tesis/update")
	@ResponseBody
	public Recurso updateStudent(@RequestBody Recurso tesis) {
		try {
			return recursoService.update(tesis);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	@DeleteMapping("/api/v1/tesis/delete")
	public void deleteRecursoById(@RequestParam(name = "recursoId") Integer recursoId) {
		try {
			recursoService.deleteById(recursoId);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@GetMapping("/api/v1/tesis/search")
	public List<Recurso> searchTesis(@RequestParam(name = "tittle") String title) {
		return recursoService.findByTituloContainingIgnoreCaseOrderByTitulo(title);
	}

}
