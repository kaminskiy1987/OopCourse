package ru.oopcourse.kaminskiy.temperature_scale;

public class KelvinScale implements TemperatureScale {
    public static final String NAME = "Kelvin";

    public KelvinScale() {
    }

    @Override
    public double toCelsius(double temperature) {
        return temperature - 273.15;
    }

    @Override
    public double fromCelsius(double temperature) {
        return temperature + 273.15;
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