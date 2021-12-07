package com.example.weatherforcast.client;

import com.example.weatherforcast.domain.Forecast;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(value = "weather-forecast", url = "${feign.client.config.weather-forecast.url}")
public interface WeatherForecastClient {

    @GetMapping(value = "/api/v0/locations/{locationId}/forecast")
    Forecast getForecastByLocation(@PathVariable  String locationId);
}
