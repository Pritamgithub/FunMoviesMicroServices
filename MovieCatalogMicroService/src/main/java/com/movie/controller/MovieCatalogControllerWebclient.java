/*
 * package com.movie.controller;
 * 
 * import java.util.Arrays; import java.util.List; import
 * java.util.stream.Collectors;
 * 
 * import org.springframework.beans.factory.annotation.Autowired; import
 * org.springframework.web.bind.annotation.PathVariable; import
 * org.springframework.web.bind.annotation.RequestMapping; import
 * org.springframework.web.bind.annotation.RestController; import
 * org.springframework.web.client.RestTemplate; import
 * org.springframework.web.reactive.function.client.WebClient;
 * 
 * import com.movie.models.CatalogItem; import com.movie.models.Movie; import
 * com.movie.models.Rating;
 * 
 * @RestController
 * 
 * @RequestMapping("/catalog") public class MovieCatalogControllerWebclient {
 * 
 * @Autowired private RestTemplate restTemplate;
 * 
 * @Autowired private WebClient.Builder webClientBuilder;
 * 
 * @RequestMapping("/{userId}") public List<CatalogItem>
 * getCatalog(@PathVariable("userid") String userid) { //WebClient.Builder
 * builder= WebClient.builder();
 * 
 * List<Rating> ratings= Arrays.asList(new Rating(movieId:"1234", rating:4), new
 * Rating(movieId:"5678", rating:3));
 * 
 * return ratings.stream().map(rating->{
 * 
 * //Movie movie=restTemplate.getForObject(url:"http://localhost:8082/movies/"
 * +rating.getMovieId(), Movie.class); Movie movie=
 * webClientBuilder.build().get().uri(s:"http://localhost:8082/movies/"
 * +rating.getMovieId()) .retrieve().bodyToMono( Movie.class). block(); return
 * new CatalogItem(movie.getName(), desc:"Test", rating.getRating()); })
 * .collect(Collectors.toList()); //get all rated movie Ids // for each movie
 * ID, call movie info service and get details //Put all them together //return
 * Collections.singletonList(new CatalogItem(name:"Transformers", desc:"Test",
 * rating:4));
 * 
 * }
 * 
 * }
 */