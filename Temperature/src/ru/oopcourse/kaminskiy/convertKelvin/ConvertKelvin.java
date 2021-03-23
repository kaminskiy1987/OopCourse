package ru.oopcourse.kaminskiy.convertKelvin;

import ru.oopcourse.kaminskiy.controller.Controller;
import ru.oopcourse.kaminskiy.view.View;

public class ConvertKelvin extends Controller {
    public ConvertKelvin(View temperatureConverter) {
        super(temperatureConverter);
    }

    public double toFahrenheit(double value) {
        return 1.8 * (value - 273) + 32;
    }

    public double toCelsius(double value) {
        return value - 273.16;
    }

    public double toKelvin(double value) {
        return value;
    }
}