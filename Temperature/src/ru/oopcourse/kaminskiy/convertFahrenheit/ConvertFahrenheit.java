package ru.oopcourse.kaminskiy.convertFahrenheit;

import ru.oopcourse.kaminskiy.controller.Controller;
import ru.oopcourse.kaminskiy.view.View;

public class ConvertFahrenheit extends Controller {
    public ConvertFahrenheit(View temperatureConverter) {
        super(temperatureConverter);
    }

    public double toFahrenheit(double value) {
        return value;
    }

    public double toCelsius(double value) {
        return (value - 32) / 1.8;
    }

    public double toKelvin(double value) {
        return toCelsius(value) + 273.16;
    }
}