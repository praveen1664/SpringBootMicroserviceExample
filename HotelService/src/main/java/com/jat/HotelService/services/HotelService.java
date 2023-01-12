package com.jat.HotelService.services;

import com.jat.HotelService.entities.Hotel;

import java.util.List;

public interface HotelService {

//    Create method
    Hotel create(Hotel hotel);
//    Get all method
    List<Hotel> getAll();
//    Single get
    Hotel getHotel(String id);
}
