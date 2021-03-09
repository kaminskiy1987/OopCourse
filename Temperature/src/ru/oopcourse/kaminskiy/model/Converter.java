package ru.oopcourse.kaminskiy.model;

public class Converter {
    public double convertFromCelsiusToKelvin(double celsiusTemperature) {
        return celsiusTemperature + 273.15;
    }

    public double convertFromKelvinToCelsius(double kelvinTemperature) {
        return kelvinTemperature - 273.15;
    }

    public double convertFromCelsiusToFahrenheit(double celsiusTemperature) {
        return 9 * (celsiusTemperature + 32) / 5;
    }

    public double convertFromFahrenheitToCelsius(double fahrenheitTemperature) {
        return 5 * (fahrenheitTemperature - 32) / 9;
    }

    public double convertFromFahrenheitToKelvin(double fahrenheitTemperature) {
        return (5 * (fahrenheitTemperature - 32) / 9) + 273.15;
    }

    public double convertFromKelvinToFahrenheit(double kelvinTemperature) {
        return (9 * (kelvinTemperature - 273.15) / 5) + 32;
    }
}