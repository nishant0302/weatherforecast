package com.example.weatherforcast.service;

import com.example.weatherforcast.client.WeatherForecastClient;
import com.example.weatherforcast.domain.Forecast;
import com.example.weatherforcast.domain.Interval;
import com.example.weatherforcast.domain.ShortInterval;
import com.example.weatherforcast.dtos.ForecastResponseDto;
import com.example.weatherforcast.exception.ForecastException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
public class ForecastService {

    @Autowired
    private WeatherForecastClient client;

    /**
     * method to get weather forecast for particular time morning and lunch
     * @param locationId id of location
     * @param interval duration for weather forecast need to retrieve.
     * @return object of ShortInterval for given interval
     */
    public ShortInterval getForecastByLocation(String locationId, String interval){
        //todo: add validation
        Forecast  forecast = client.getForecastByLocation(locationId);
        List<ShortInterval> shortIntervals = forecast.getShortIntervals();
        LocalDateTime dateToForecast = LocalDateTime.now();
        int currentHour = dateToForecast.getHour();
        // check if beyond interval time range then collect plus one day data
        if((Interval.valueOf(interval.toUpperCase()) == Interval.MORNING && currentHour > 8) ||
                (Interval.valueOf(interval.toUpperCase()) == Interval.LUNCH && currentHour > 12))
        {
            dateToForecast = dateToForecast.plusDays(1);
        }
        ForecastResponseDto response = new ForecastResponseDto();
        LocalDateTime finalDateToForecast = dateToForecast;
        Optional<ShortInterval> shortInterval = shortIntervals.stream()
                .filter(shortInterval1 -> checkIfValidInterval(interval,shortInterval1, finalDateToForecast))
                .findAny();
        if(!shortInterval.isPresent()){
            throw new ForecastException("not a valid interval");
        }
        return shortInterval.get();
    }

    private boolean checkIfValidInterval(String interval, ShortInterval shortInterval, LocalDateTime dateToForecast) {
        LocalDateTime dateAt7 = dateToForecast.with(LocalTime.of(7, 0));
        LocalDateTime dateAt8 = dateToForecast.with(LocalTime.of(8, 0));
        LocalDateTime dateAt11 = dateToForecast.with(LocalTime.of(11, 0));
        LocalDateTime dateAt12 = dateToForecast.with(LocalTime.of(12, 0));
        return (Interval.valueOf(interval.toUpperCase()) == Interval.MORNING &&
                shortInterval.getStart().contains(dateAt7.toString()) &&
                shortInterval.getEnd().contains(dateAt8.toString()))
                || (Interval.valueOf(interval.toUpperCase()) == Interval.LUNCH &&
                        shortInterval.getStart().contains(dateAt11.toString()) &&
                        shortInterval.getEnd().contains(dateAt12.toString()));
    }
}
