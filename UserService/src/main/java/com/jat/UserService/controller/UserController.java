package com.jat.UserService.controller;

import com.jat.UserService.entities.User;
import com.jat.UserService.services.UserService;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.ratelimiter.annotation.RateLimiter;
import io.github.resilience4j.retry.annotation.Retry;
import org.slf4j.ILoggerFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/users")
public class UserController
{
    private Logger logger= LoggerFactory.getLogger(UserController.class);
    @Autowired
    private UserService userservice;
//    user  create
//    @CrossOrigin(origins = "*")
//    @CrossOrigin
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user)
    {
    User user1=userservice.saveUser(user);
    return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }
//    Single User get
    int retryCount=1;
//    @CrossOrigin(origins = "*")
    @GetMapping("/{userId}")
//    @CircuitBreaker(name="ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
    @Retry(name = "ratingHotelBreaker",fallbackMethod = "ratingHotelFallback")
//    @RateLimiter(name = "userRateLimiter",fallbackMethod = "ratingHotelFallback")
    public ResponseEntity<User> getSingleUser(@PathVariable String userId) {
        logger.info("Retry Count is {}",retryCount);
        retryCount++;
        User user=userservice.getUser(userId);
        return ResponseEntity.ok(user);
    }

//    Creating fall back method for Circuit breaker
    public ResponseEntity<User> ratingHotelFallback(String userId,Exception ex)
    {
        logger.info("FallBack is excuted becuase service is down",ex.getMessage());

        User user=User.builder()
                .email("dummy@dummy.com")
                .name("dummy")
                .About("This is dummy User becuase some serviers are down")
                .userId("123456")
                .build();
        return new ResponseEntity<>(user,HttpStatus.OK);
    }
//    All user get
//@CrossOrigin(origins = "*")
@GetMapping()
@CircuitBreaker(name="rateHotelBreakerAllUsers",fallbackMethod = "rateHotelBreakerAllUsersFallback")
    public ResponseEntity<List<User>> getAllUsers(){
        List<User> alluser = userservice.getallUsers();
        return ResponseEntity.ok(alluser);
    }
    public ResponseEntity<List<User>> rateHotelBreakerAllUsersFallback(Exception ex){
        logger.info("FallBack excueted for all users",ex.getMessage());
        User u1=User.builder().email("Dummay").userId("12163264").name("dummy").About("This is dummy List").build();
        List<User> users= Arrays.asList(u1);
        return ResponseEntity.ok(users);
    }
}


