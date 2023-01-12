package com.jat.UserService.services.impl;
import com.jat.UserService.entities.Hotel;
import com.jat.UserService.entities.Rating;
import com.jat.UserService.entities.User;
import com.jat.UserService.exception.ResourceNotFoundException;
import com.jat.UserService.external.services.HotelService;
import com.jat.UserService.repositories.UserRepository;
import com.jat.UserService.services.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userrepository;

    @Autowired
    private HotelService hotelService;

    @Autowired
    private RestTemplate restTemplate;

    private Logger logger= LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user)
    {
        String randomUserId=UUID.randomUUID().toString();
        user.setUserId(randomUserId);
        return userrepository.save(user);
    }

    @Override
    public List<User> getallUsers() {
        List<User> users= userrepository.findAll();
        for (User u : users) {
//        ArrayList<Rating> ratingUser=restTemplate.getForObject("http://localhost:8083/ratings/users/"+u.getUserId(),ArrayList.class);
//        u.setRatings(ratingUser);
            Rating[] ratings = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + u.getUserId(), Rating[].class);
            for (Rating rating : ratings) {
//                ResponseEntity<Hotel> hotelResponseEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class);
//                Hotel h1=hotelResponseEntity.getBody();
//                rating.setHotel(h1);
                Hotel hotel=hotelService.getHotel(rating.getHotelId());
                rating.setHotel(hotel);

            }
            u.setRatings(List.of(ratings));
        }
        return users;
    }

    @Override
    public User getUser(String userId) {
        User user=userrepository.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User not found on server with ID"+userId));
        //        Call user service with this url http://localhost:8083/ratings/users/79c18b2b-eb6a-47e1-81aa-acd2ecec8f41
//        ArrayList<Rating> ratingsOfUser = restTemplate.getForObject("http://localhost:8083/ratings/users/"+user.getUserId(), ArrayList.class);
        Rating[] ratingsOfUser = restTemplate.getForObject("http://RATING-SERVICE/ratings/users/" + user.getUserId(), Rating[].class);
//        user.setRatings(List.of(ratingsOfUser));
        logger.info("{}",ratingsOfUser);
        List<Rating> ratings= Arrays.stream(ratingsOfUser).toList();
//        user.setRatings(List.of(ratingsOfUser));
        List<Rating> ratingList = ratings.stream().map(rating -> {
//             api call to hotel service to get the hotel http://localhost:8082/hotels/2b217131-9a6b-4cf8-a72f-b62724cbc917
//            ResponseEntity<Hotel> forEntity = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/" + rating.getHotelId(), Hotel.class);
//            Hotel hotel = forEntity.getBody();
//            logger.info(" {} ",forEntity.getBody());
            Hotel hotel=hotelService.getHotel(rating.getHotelId());
            rating.setHotel(hotel);
            return rating;
        }).collect(Collectors.toList());
        user.setRatings(ratingList);
        return user;
    }
}
