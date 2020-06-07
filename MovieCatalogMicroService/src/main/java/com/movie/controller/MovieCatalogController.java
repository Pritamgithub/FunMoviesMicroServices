package com.movie.controller;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.movie.models.CatalogItem;
import com.movie.models.Movie;
import com.movie.models.Rating;
import com.movie.models.UserRating;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/{userId}")
	@HystrixCommand(fallbackMethod = "getFallbackCatalog")
	public List<CatalogItem> getCatalog(@PathVariable("userid") String userId)
	{ 
		
		UserRating ratings=getForObject(userId);
	
		
		// for each movie ID, call movie info service and get details
		return ratings.getUserRating().stream().map(rating->{
			
			Movie movie=getCatalogItem(rating);
			//Put all them together
			return getCatalogItem(rating, movie);
			})
				.collect(Collectors.toList());
		//get all rated movie Ids
		//return Collections.singletonList(new CatalogItem(name:"Transformers", desc:"Test", rating:4));
		
	}
	/*
	 * // public List<CatalogItem> getFallbackCatalog(@PathVariable("userid")
	 * String userId){ // return Arrays.asList(new CatalogItem("No movie", "",""
	 * )); // // // }
	 */

	private CatalogItem getCatalogItem(Rating rating, Movie movie) {
		return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
	}

	private Movie getCatalogItem(Rating rating) {
		return restTemplate.getForObject("http://localhost:8082/movies/" +rating.getMovieId(), Movie.class);
	}

	private UserRating getForObject(String userId) {
		return restTemplate.getForObject("http://localhost:8083/ratingsdata/users/" +userId, UserRating.class);
	}
}
