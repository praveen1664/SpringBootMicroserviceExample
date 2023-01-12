package com.jat.HotelService.controllers;

import com.jat.HotelService.entities.Hotel;
import com.jat.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/hotels")
public class HotelController {
    @Autowired
    private HotelService hotelService;
//    create
//    ResponseEntity could be used to send the status

    @PostMapping
    @CrossOrigin(origins = "*", maxAge = 3600)
    public ResponseEntity createHotel(@RequestBody Hotel hotel) {
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));

    }
//    get single
   @GetMapping("/{hotelId}")
   @CrossOrigin(origins = "*", maxAge = 3600)
   public ResponseEntity getSingle(@PathVariable String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getHotel(hotelId));
   }
//    get all
    @GetMapping
    @CrossOrigin(origins = "*", maxAge = 3600)
    public  ResponseEntity<List<Hotel>> getAll(){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.getAll());
    }
}
