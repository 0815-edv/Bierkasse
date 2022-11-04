package de.dlrg.backend;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.context.annotation.Bean;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication(exclude={SecurityAutoConfiguration.class})
public class BackendApplication {
	//Starten der SpringApplication
	public static void main(String[] args) {
		SpringApplication.run(BackendApplication.class, args);
	}
	@Bean //Konfiguration der CORS Einstellungen
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**")
						.allowedOrigins("*") //Erlaubten Zugriffe
						.allowedMethods("GET", "PUT", "POST", "PATCH", "DELETE", "OPTIONS"); //Erlaubten Zugriffsmethoden
			}
		};
	}

}
