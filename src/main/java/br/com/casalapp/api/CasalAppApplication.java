package br.com.casalapp.api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class CasalAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(CasalAppApplication.class, args);
	}
}
