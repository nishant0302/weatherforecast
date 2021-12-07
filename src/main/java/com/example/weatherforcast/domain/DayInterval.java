package com.example.weatherforcast.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class DayInterval {
    private String[] twelveHourSymbols;
    private String[] sixHourSymbols;
    private String symbolConfidence;
    private Precipitation precipitation;
    private Temperature temperature;
    private Wind wind;
}
