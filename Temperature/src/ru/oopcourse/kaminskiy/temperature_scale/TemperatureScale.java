package ru.oopcourse.kaminskiy.temperature_scale;

public interface TemperatureScale {
    double toCelsius(double temperature);

    double fromCelsius(double temperature);
}