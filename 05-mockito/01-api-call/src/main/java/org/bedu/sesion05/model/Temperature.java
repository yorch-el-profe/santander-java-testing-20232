package org.bedu.sesion05.model;

import lombok.Data;

@Data
public class Temperature {
    private final double temperature;
    private final ThermalSensation sensation;
}
