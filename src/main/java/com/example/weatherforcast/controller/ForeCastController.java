package com.example.weatherforcast.controller;

import com.example.weatherforcast.domain.ShortInterval;
import com.example.weatherforcast.dtos.ForecastResponseDto;
import com.example.weatherforcast.service.ForecastService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/weather")
public class ForeCastController {

    @Autowired
    private ForecastService service;

    @GetMapping("/forecast/by/location/{locationId}")
    public ResponseEntity<ForecastResponseDto> findByLocation(
            @PathVariable String locationId,
            @RequestParam String timeInterval
    ){
        ShortInterval shortInterval = service.getForecastByLocation(locationId, timeInterval);
        return new ResponseEntity<>(ForecastResponseDto.toResponseDto(shortInterval,locationId), HttpStatus.OK);

    }
}
