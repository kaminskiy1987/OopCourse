package ru.oopcourse.kaminskiy.temperature_scale;

public class CelsiusScale implements TemperatureScale {
    public static final String NAME = "Celsius";

    public CelsiusScale() {
    }

    @Override
    public double toCelsius(double temperature) {
        return temperature;
    }

    @Override
    public double fromCelsius(double temperature) {
        return temperature;
    }

    @Override
    public String getName() {
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}