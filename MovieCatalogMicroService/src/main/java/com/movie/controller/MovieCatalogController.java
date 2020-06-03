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

@RestController
@RequestMapping("/catalog")
public class MovieCatalogController {

	@Autowired
	private RestTemplate restTemplate;

	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userid") String userId)
	{ 
		
		UserRating ratings=restTemplate.getForObject("http://localhost:8083/ratingsdata/users/" +userId, UserRating.class);
	
		
		// for each movie ID, call movie info service and get details
		return ratings.getUserRating().stream().map(rating->{
			
			Movie movie=restTemplate.getForObject("http://localhost:8082/movies/" +rating.getMovieId(), Movie.class);
			//Put all them together
			return new CatalogItem(movie.getName(), movie.getDescription(), rating.getRating());
			})
				.collect(Collectors.toList());
		//get all rated movie Ids
		//return Collections.singletonList(new CatalogItem(name:"Transformers", desc:"Test", rating:4));
		
	}

}
