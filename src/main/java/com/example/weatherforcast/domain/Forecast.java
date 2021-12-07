package com.example.weatherforcast.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Forecast {
    private List<DayInterval> dayIntervals;
    private List<ShortInterval> shortIntervals;
    private String created;
    private String update;
}
