package ru.oopcourse.kaminskiy.temperature_calculator;

import ru.oopcourse.kaminskiy.temperature_scale.TemperatureScale;

public class TemperatureCalculator {
    public double convert(double temperature, TemperatureScale temperatureScaleToCelsius, TemperatureScale temperatureScaleFromCelsius) {
        double temperatureConversionToCelsius = temperatureScaleToCelsius.toCelsius(temperature);

        return temperatureScaleFromCelsius.fromCelsius(temperatureConversionToCelsius);
    }
}