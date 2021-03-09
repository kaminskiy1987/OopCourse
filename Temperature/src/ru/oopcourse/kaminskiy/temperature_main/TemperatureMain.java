package ru.oopcourse.kaminskiy.temperature_main;

import ru.oopcourse.kaminskiy.controller.Controller;
import ru.oopcourse.kaminskiy.model.Converter;
import ru.oopcourse.kaminskiy.view.DesktopView;
import ru.oopcourse.kaminskiy.view.View;

public class TemperatureMain {
    public static void main(String[] args) {
        Converter temperatureConverter = new Converter();

        Controller controller = new Controller(temperatureConverter);
        View view = new DesktopView(controller);

        controller.setView(view);

        view.start();
    }
}