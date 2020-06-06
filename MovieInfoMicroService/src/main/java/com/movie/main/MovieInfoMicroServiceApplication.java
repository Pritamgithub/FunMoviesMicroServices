package com.movie.main;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
public class MovieInfoMicroServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(MovieInfoMicroServiceApplication.class, args);
	}

}
