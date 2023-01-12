package com.jat.HotelService.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.HashMap;
import java.util.Map;

public class GlobalExceptionHandler {
   public ResponseEntity<Map<String,Object>> notFoundError(ResourceNotFoundException ex){
       Map map= new HashMap();
       map.put("message",ex.getMessage());
       map.put("Cause",ex.getCause());
       map.put("Success",false);
       map.put("Status", HttpStatus.NOT_FOUND);

       return ResponseEntity.status(HttpStatus.NOT_FOUND).body(map);
   }
}
