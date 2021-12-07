package com.example.weatherforcast.dtos;

import com.example.weatherforcast.domain.ShortInterval;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ForecastResponseDto {

    private String location;
    private double temp;
    private double feelsLike;
    private String weatherSymbolCode;
    private String isCloudy;
    private String isSunny;
    private String dateTime;

    public static ForecastResponseDto toResponseDto(ShortInterval shortInterval, String locationId){
        ForecastResponseDto dto = new ForecastResponseDto();
        dto.setLocation(locationId);
        dto.setFeelsLike(shortInterval.getFeelsLike().getValue());
        dto.setTemp(shortInterval.getTemperature().getValue());
        dto.setWeatherSymbolCode(shortInterval.getSymbolCode().getNext1Hour());
        dto.setDateTime(shortInterval.getStart().substring(0,10));
        if(shortInterval.getSymbolCode().getNext1Hour().contains("cloud"))
            dto.setIsCloudy("yes");
        else
            dto.setIsCloudy("No");
        if(shortInterval.getSymbolCode().getNext1Hour().contains("clearsky"))
            dto.setIsSunny("yes");
        else
            dto.setIsSunny("No");
        return dto;
    }
}
