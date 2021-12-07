package com.example.weatherforcast.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Temperature {
    private double value;
    private double max;
    private double min;
    private Probability probability;
    private Precipitation precipitation;
}
