package org.bedu.sesion05.model;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class CurrentWeatherUnit {
    private String time;
    private String interval;
    private String temperature;
    private String windspeed;
    private String winddirection;
    private String is_day;
    private String weathercode;
}
