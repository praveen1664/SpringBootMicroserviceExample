package com.jat.UserService.external.services;

import com.jat.UserService.entities.Hotel;
import lombok.experimental.PackagePrivate;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "HOTEL-SERVICE")
@Service
public interface HotelService
{
@GetMapping("/hotels/{hotelId}")
    public Hotel getHotel(@PathVariable("hotelId") String hotelId);

}

