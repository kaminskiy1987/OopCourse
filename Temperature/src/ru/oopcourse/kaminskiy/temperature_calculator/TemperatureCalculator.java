package ru.oopcourse.kaminskiy.temperature_calculator;

import ru.oopcourse.kaminskiy.temperature_scale.TemperatureScale;

public class TemperatureCalculator {
    public TemperatureCalculator() {
    }

    public static double convert(double temperature, TemperatureScale temperatureScale1, TemperatureScale temperatureScale2) {
        double in = temperatureScale1.toCelsius(temperature);

        return temperatureScale2.fromCelsius(in);
    }
}