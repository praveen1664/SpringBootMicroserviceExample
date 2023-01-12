package com.jat.UserService;

import com.jat.UserService.entities.Rating;
import com.jat.UserService.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.ResponseEntity;

@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {
	}
	@Autowired
	private RatingService ratingService;

	@Test
	void createRating(){
		Rating rating=Rating.builder().rating(10).userId("").feedback("This is generated from test class").hotelId("").build();
		ResponseEntity<Rating> savedRating=ratingService.createRating(rating);

		System.out.println("new rating Created"+savedRating);
	}

}
