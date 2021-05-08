package ru.oopcourse.kaminskiy.temperature_scale;

public class CelsiusScale implements TemperatureScale {
    @Override
    public double toCelsius(double temperature) {
        return temperature;
    }

    @Override
    public double fromCelsius(double temperature) {
        return temperature;
    }

    @Override
    public String toString() {
        return "Celsius";
    }
}