package restiapi.projeto1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;

/*
 * A anotação @SpringBootApplication é geralmente utilizada na classe principal da aplicação para habilitar a
 * configuração automática, a varredura de componentes e outras funcionalidades essenciais do Spring Boot.
 * */
@SpringBootApplication
public class RestapiprojApplication {
	public static void main(String[] args) {
		SpringApplication.run(RestapiprojApplication.class, args);
	}
}