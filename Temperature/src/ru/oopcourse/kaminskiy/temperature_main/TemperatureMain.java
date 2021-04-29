package ru.oopcourse.kaminskiy.temperature_main;

import ru.oopcourse.kaminskiy.temperature_scale.CelsiusScale;
import ru.oopcourse.kaminskiy.temperature_scale.FahrenheitScale;
import ru.oopcourse.kaminskiy.temperature_scale.KelvinScale;
import ru.oopcourse.kaminskiy.temperature_scale.TemperatureScale;
import ru.oopcourse.kaminskiy.temperature_view.TemperatureDesktopView;

public class TemperatureMain {
    public static void main(String[] args) {
        TemperatureScale[] temperatureScales = {
                new CelsiusScale(),
                new KelvinScale(),
                new FahrenheitScale(),
        };

        new TemperatureDesktopView(temperatureScales);
    }
}