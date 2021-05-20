package ru.oopcourse.kaminskiy.temperature_calculator;

import ru.oopcourse.kaminskiy.temperature_scale.TemperatureScale;

public class TemperatureCalculator {
    public double convert(double temperature, TemperatureScale scaleFromWhichTransfer, TemperatureScale scaleToWhichTransfer) {
        double temperatureInCelsius = scaleFromWhichTransfer.toCelsius(temperature);

        return scaleToWhichTransfer.fromCelsius(temperatureInCelsius);
    }
}
