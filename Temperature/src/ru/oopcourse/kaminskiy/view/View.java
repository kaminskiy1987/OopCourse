package ru.oopcourse.kaminskiy.view;

public interface View {
    void start();

    void setKelvinCelsiusTemperature(double kelvinTemperature);

    void setCelsiusKelvinTemperature(double celsiusTemperature);

    void setFahrenheitCelsiusTemperature(double fahrenheitTemperature);

    void setCelsiusFahrenheitTemperature(double celsiusTemperature);

    void setKelvinFahrenheitTemperature(double kelvinTemperature);

    void setFahrenheitKelvinTemperature(double fahrenheitTemperature);
}