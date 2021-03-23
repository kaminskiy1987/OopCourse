package ru.oopcourse.kaminskiy.convertCelsius;

import ru.oopcourse.kaminskiy.controller.Controller;
import ru.oopcourse.kaminskiy.view.View;

public class ConvertCelsius extends Controller {
    public ConvertCelsius(View temperatureConverter) {
        super(temperatureConverter);
    }

    public double toFahrenheit(double value) {
        return (value * 9) / 5 + 32;
    }

    public double toCelsius(double value) {
        return value;
    }

    public double toKelvin(double value) {
        return toCelsius(value) + 273.16;
    }
}