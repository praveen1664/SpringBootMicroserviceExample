package com.jat.rating.services;

import com.jat.rating.entities.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {

//    create
    Rating create(Rating rating);
//    getallRatings
    List<Rating> getRatings();
//    getUserRating
    List<Rating> getRatingByUserId(String userId);
//    get all by hotels
    List<Rating> getRatingByHotelId(String hotelId);
}
