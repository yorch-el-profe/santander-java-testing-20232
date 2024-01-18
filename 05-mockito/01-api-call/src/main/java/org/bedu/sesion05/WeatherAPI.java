package org.bedu.sesion05;

import org.bedu.sesion05.model.Temperature;
import org.bedu.sesion05.model.ThermalSensation;
import org.bedu.sesion05.model.Weather;
import org.bedu.sesion05.util.Axios;

public class WeatherAPI {

    private Axios axios;

    public WeatherAPI(Axios axios) {
        this.axios = axios;
    }

    public WeatherAPI() {
        axios = new Axios();
    }

    public Temperature getCurrentWeather(double latitude, double longitude) {
        try {
            String url = "https://api.open-meteo.com/v1/forecast?latitude=" + latitude + "&longitude=" + longitude
                    + "&current_weather=true";

            Weather result = axios.request(url, Weather.class);

            double temperature = result.getCurrent_weather().getTemperature();
            ThermalSensation sensation = getThermalSensation(temperature);

            return new Temperature(temperature, sensation);
        } catch (Exception ex) {
            return null;
        }
    }

    public ThermalSensation getThermalSensation(double temperature) {
        if (temperature < 12) {
            return ThermalSensation.COLD;
        } else if (temperature > 25) {
            return ThermalSensation.HOT;
        } else {
            return ThermalSensation.WARM;
        }
    }
}
