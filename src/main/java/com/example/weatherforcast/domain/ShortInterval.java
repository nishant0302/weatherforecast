package com.example.weatherforcast.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ShortInterval {
    private Symbol symbol;
    private SymbolCode symbolCode;
    private Precipitation precipitation;
    private Temperature temperature;
    private Wind wind;
    private FeelsLike feelsLike;
    private Pressure pressure;
    private CloudCover cloudCover;
    private Humidity humidity;
    private DewPoint dewPoint;
    private UvIndex uvIndex;
    private String start;
    private String end;
    private String nominalStart;
    private String nominalEnd;

}
