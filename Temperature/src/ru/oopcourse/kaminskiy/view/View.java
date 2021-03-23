package ru.oopcourse.kaminskiy.view;

public interface View {
    void start();

    double getValue();

    void setFahrenheit(double value);

    void setCelsius(double value);

    void setKelvin(double value);
}