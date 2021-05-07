package com.example.ratingmovies.resources;

import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.ratingmovies.models.Rating;
import com.example.ratingmovies.models.UserRating;

@RestController
@RequestMapping("/ratingsdata")
public class RatingsResource {

    @RequestMapping("/{movieId}")
    public Rating getMovieRating(@PathVariable("movieId") String movieId) {
        return new Rating(movieId, 9);
    }
    
    @RequestMapping("users/{userId}")
    public UserRating getUserRating(@PathVariable("userId") String userId) {
    	List<Rating> ratings = Arrays.asList(
    			new Rating("1234", 3),
                new Rating("5678", 4)
    	);
    	UserRating userRating = new UserRating();
    	userRating.setUserRating(ratings);
    	return userRating;
    }
}