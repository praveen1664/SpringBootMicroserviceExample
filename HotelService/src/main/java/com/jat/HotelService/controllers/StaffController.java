package com.jat.HotelService.controllers;

import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/staffs")
@CrossOrigin(origins = "*", maxAge = 3600)
public class StaffController {
    @GetMapping
    public ResponseEntity<List<String>> getStaffs ()
    {
        List<String> list = Arrays.asList("Praveen","Priyanka","Samarth","Lakshika");
        return new ResponseEntity<>(list, HttpStatus.OK);


    }
}
