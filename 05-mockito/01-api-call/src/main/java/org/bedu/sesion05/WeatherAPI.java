package org.bedu.sesion05;

import org.bedu.sesion05.model.Weather;
import org.bedu.sesion05.util.Axios;

public class WeatherAPI {

    private Axios axios;

    public WeatherAPI() {
        axios = new Axios();
    }

    public double getCurrentWeather(double latitude, double longitude) {
        try {
            String url = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude
                    + "&current_weather=true";

            Weather result = axios.request(url, Weather.class);

            return result.getCurrent_weather().getTemperature();
        } catch (Exception ex) {
            return -1;
        }
    }
}
