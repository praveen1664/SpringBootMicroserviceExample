package com.jat.HotelService.services.impl;

import com.jat.HotelService.entities.Hotel;
import com.jat.HotelService.exceptions.ResourceNotFoundException;
import com.jat.HotelService.repository.HotelRepository;
import com.jat.HotelService.services.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class HotelServiceimpl implements HotelService {
    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        String hotelId=UUID.randomUUID().toString();
        hotel.setId(hotelId);
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel getHotel(String id) {
        return hotelRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Hotel with Given Id did not found"));
    }
}
