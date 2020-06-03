package com.movie.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.movie.models.Rating;
import com.movie.models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsDataResource {

	@RequestMapping("/{movieId}")
	public Rating getRating(@PathVariable("movieId") String movieId)
	{
		return new Rating(movieId, rating:4);
		
	}

	@RequestMapping("users/{userId}")
	public UserRating getUserRating(@PathVariable("userId") String userId)
	{
		List<Rating> ratings= Arrays.asList(
				new Rating(movieId:"1234", rating:4),
				new Rating(movieId:"5678", rating:3));
		

		UserRating userRating= new UserRating();
		userRating.setUserRating(ratings);
		return userRating;
	}

}