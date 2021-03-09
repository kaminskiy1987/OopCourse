package ru.oopcourse.kaminskiy.controller;

import ru.oopcourse.kaminskiy.model.Converter;
import ru.oopcourse.kaminskiy.view.View;

public class Controller {
    private View view;
    private final Converter temperatureConverter;

    public Controller(Converter temperatureConverter) {
        this.temperatureConverter = temperatureConverter;
    }

    public void setView(View view) {
        this.view = view;
    }

    public void convertTemperatureFromCelsiusToKelvin(double celsiusTemperature) {
        double result = temperatureConverter.convertFromCelsiusToKelvin(celsiusTemperature);
        view.setKelvinCelsiusTemperature(result);
    }

    public void convertTemperatureFromKelvinToCelsius(double kelvinTemperature) {
        double result = temperatureConverter.convertFromKelvinToCelsius(kelvinTemperature);
        view.setCelsiusKelvinTemperature(result);
    }

    public void convertTemperatureFromCelsiusToFahrenheit(double celsiusTemperature) {
        double result = temperatureConverter.convertFromCelsiusToFahrenheit(celsiusTemperature);
        view.setFahrenheitCelsiusTemperature(result);
    }

    public void convertTemperatureFromFahrenheitToCelsius(double fahrenheitTemperature) {
        double result = temperatureConverter.convertFromFahrenheitToCelsius(fahrenheitTemperature);
        view.setCelsiusFahrenheitTemperature(result);
    }

    public void convertTemperatureFromFahrenheitToKelvin(double fahrenheitTemperature) {
        double result = temperatureConverter.convertFromFahrenheitToKelvin(fahrenheitTemperature);
        view.setKelvinFahrenheitTemperature(result);
    }

    public void convertTemperatureFromKelvinToFahrenheit(double kelvinTemperature) {
        double result = temperatureConverter.convertFromKelvinToFahrenheit(kelvinTemperature);
        view.setFahrenheitKelvinTemperature(result);
    }
}