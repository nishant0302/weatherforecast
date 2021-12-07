package com.example.weatherforcast.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Wind {
    private int direction;
    private double speed;
    private double min;
    private double max;
    private double maxGust;
    private Probability probability;
}
