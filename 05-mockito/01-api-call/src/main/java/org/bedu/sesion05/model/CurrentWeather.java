package org.bedu.sesion05.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CurrentWeather {
    private String time;
    private int interval;
    private double temperature;
    private double windspeed;
    private int winddirection;
    private int is_day;
    private int weathercode;
}
