package com.jat.rating.controllers;

import com.jat.rating.entities.Rating;
import com.jat.rating.services.RatingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ratings")
@CrossOrigin(origins = "*", maxAge = 3600)
public class RatingController {
    @Autowired
    private RatingService ratingService;
//    Create Rating
    @CrossOrigin(origins = "*", maxAge = 3600)
    @PostMapping
    public ResponseEntity<Rating> create(@RequestBody Rating rating){
    return ResponseEntity.status(HttpStatus.OK).body(ratingService.create(rating));
    }

//    Get All Ratings
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping
    public ResponseEntity<List<Rating>> getAllRatings(){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatings());
    }
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByUserId(userId));
    }
    @CrossOrigin(origins = "*", maxAge = 3600)
    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(ratingService.getRatingByHotelId(hotelId));
    }

}
