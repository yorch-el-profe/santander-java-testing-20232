package org.bedu.sesion05;

import java.util.Scanner;

import org.bedu.sesion05.model.Temperature;

public class Application {
    public static void main(String... args) {
        Scanner scanner = new Scanner(System.in);
        WeatherAPI api = new WeatherAPI();

        System.out.println("Ingresa la latitud:");
        double latitude = scanner.nextDouble();
        scanner.nextLine();

        System.out.println("Ingresa la longitud:");
        double longitude = scanner.nextDouble();
        scanner.nextLine();

        Temperature result = api.getCurrentWeather(latitude, longitude);

        System.out.println("La temperatura es: " + result.getTemperature() + "°C");
        scanner.close();
    }
}
