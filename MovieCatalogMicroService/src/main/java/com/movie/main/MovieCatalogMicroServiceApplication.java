package com.movie.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.context.annotation.Bean;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableCircuitBreaker
public class MovieCatalogMicroServiceApplication {

	@Bean
	public RestTemplate getRestTemplate() {
		// TODO
		// set timeouts to overcome the slow processing of the microservices
		// solution for this is to set Timeout at RestTemplate

		HttpComponentsClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory();
		clientHttpRequestFactory.setConnectTimeout(3000);//Partial solution to remove the slowness of a microservice
		return new RestTemplate(clientHttpRequestFactory);

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
