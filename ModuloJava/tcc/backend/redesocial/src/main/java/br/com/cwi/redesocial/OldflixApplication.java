package br.com.cwi.redesocial;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class OldflixApplication {

	public static void main(String[] args) {
		SpringApplication.run(OldflixApplication.class, args);
	}
}
