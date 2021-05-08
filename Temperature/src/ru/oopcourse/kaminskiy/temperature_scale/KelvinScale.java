package ru.oopcourse.kaminskiy.temperature_scale;

public class KelvinScale implements TemperatureScale {
    @Override
    public double toCelsius(double temperature) {
        return temperature - 273.15;
    }

    @Override
    public double fromCelsius(double temperature) {
        return temperature + 273.15;
    }

    @Override
    public String toString() {
        return "Kelvin";
    }
}