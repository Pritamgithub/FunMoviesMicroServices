package com.movie.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

@SpringBootApplication
public class MovieCatalogMicroServiceApplication {

	@Bean
	public RestTemplate getRestTemplate() {
		return new RestTemplate();

	}
	
	/*
	 * @Bean public WebClient.Builder getWebClientBuilder() { return new
	 * WebClient.builder();
	 * 
	 * }
	 */


	public static void main(String[] args) {
		SpringApplication.run(MovieCatalogMicroServiceApplication.class, args);
	}

}