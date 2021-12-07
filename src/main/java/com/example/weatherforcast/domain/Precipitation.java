package com.example.weatherforcast.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Precipitation {
    private double max;
    private double min;
    private double value;
    private double probability;
    private int pop;
}
