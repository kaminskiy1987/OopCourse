package ru.oopcourse.kaminskiy.controller;

import ru.oopcourse.kaminskiy.view.View;

import javax.swing.*;
import java.awt.event.ActionEvent;

public abstract class Controller extends AbstractAction {
    private final View temperatureConverter;

    public Controller(View temperatureConverter) {
        this.temperatureConverter = temperatureConverter;
    }

    public void setView(View view) {
    }

    public void actionPerformed(ActionEvent e) {
        double value = temperatureConverter.getValue();
        temperatureConverter.setFahrenheit(toFahrenheit(value));
        temperatureConverter.setCelsius(toCelsius(value));
        temperatureConverter.setKelvin(toKelvin(value));

    }

    public abstract double toFahrenheit(double value);

    public abstract double toCelsius(double value);

    public abstract double toKelvin(double value);
}