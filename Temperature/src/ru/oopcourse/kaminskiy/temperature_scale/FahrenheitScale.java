package ru.oopcourse.kaminskiy.temperature_scale;

public class FahrenheitScale implements TemperatureScale {
    public static final String NAME = "Fahrenheit";

    public FahrenheitScale() {
    }

    @Override
    public double toCelsius(double temperature) {
        return (temperature - 32) / (9.0 / 5.0);
    }

    @Override
    public double fromCelsius(double temperature) {
        return (temperature * 9.0 / 5.0) + 32;
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