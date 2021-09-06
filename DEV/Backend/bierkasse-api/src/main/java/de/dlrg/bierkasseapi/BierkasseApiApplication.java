package de.dlrg.bierkasseapi;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(info = @Info(title = "SakilaGEO API", version = "2.0", description = "GEO Information"))
public class BierkasseApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(BierkasseApiApplication.class, args);
	}

}
