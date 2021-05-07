package com.example.movieapp.resources;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;

import com.example.movieapp.models.CatalogItem;
import com.example.movieapp.models.Movie;
import com.example.movieapp.models.Rating;
import com.example.movieapp.models.UserRating;

@RestController
@RequestMapping("/catalog")
public class MovieCatalogResource {
	
	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/{userId}")
	public List<CatalogItem> getCatalog(@PathVariable("userId") String userId){
		
		UserRating ratings = restTemplate.getForObject("http://localhost:8083/ratingsdata/users/" + userId,UserRating.class); 
				
	    return ratings.getUserRating().stream().map(rating -> {
	    // For each movieId, call movie info service and get details
		Movie movie = restTemplate.getForObject("http://localhost:8082/movies/" + rating.getMovieId(), Movie.class);
		
		/*Movie movie = webClientBuilder.build()
			.get()
			.uri("http://localhost:8082/movies/" + rating.getMovieId())
			.retrieve()
			.bodyToMono(Movie.class)
			.block();*/
		// Putting all together
		 return new CatalogItem(movie.getName(),"Test",rating.getRating());
		 }).collect(Collectors.toList());

	}

}
