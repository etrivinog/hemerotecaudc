package co.edu.unicartagena;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import co.edu.unicartagena.service.HemerotecaService;

@SpringBootApplication
@RestController
public class HemerotecaudcApplication {
	
	@Autowired
	HemerotecaService hemeroteca;

	@GetMapping("/test")
	public Object test() {
		
		return hemeroteca.test();
		
	}

	@GetMapping("/error")
	public Object error() {
		
		return "Error";
		
	}
	
	public static void main(String[] args) {
		SpringApplication.run(HemerotecaudcApplication.class, args);
	}

}
