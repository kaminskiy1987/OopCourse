package ru.oopcourse.kaminskiy.view;

import ru.oopcourse.kaminskiy.controller.Controller;

import javax.swing.*;
import java.awt.*;

public class DesktopView implements View {
    private final Controller controller;

    private JLabel kelvinCelsiusTemperatureLabel;

    private JLabel kelvinFahrenheitTemperatureLabel;

    private JLabel celsiusKelvinTemperatureLabel;

    private JLabel fahrenheitCelsiusTemperatureLabel;

    private JLabel fahrenheitKelvinTemperatureLabel;

    private JLabel celsiusFahrenheitTemperatureLabel;

    public DesktopView(Controller controller) {
        this.controller = controller;
    }

    @Override
    public void start() {

        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Конвертер температур");
            frame.setSize(500, 300);
            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            frame.setLayout(new FlowLayout());

            JLabel degreesLabel = new JLabel("Введите температуру в градусах: ");
            frame.add(degreesLabel);

            JRadioButton celsiusToKelvinRadio = new JRadioButton("Celsius to Kelvin");
            frame.add(celsiusToKelvinRadio);

            JRadioButton kelvinToCelsiusRadio = new JRadioButton("Kelvin to Celsius");
            frame.add(kelvinToCelsiusRadio);

            JRadioButton celsiusToFahrenheitRadio = new JRadioButton("Celsius to Fahrenheit");
            frame.add(celsiusToFahrenheitRadio);

            JRadioButton fahrenheitToCelsiusRadio = new JRadioButton("Fahrenheit to Celsius");
            frame.add(fahrenheitToCelsiusRadio);

            JRadioButton fahrenheitToKelvinRadio = new JRadioButton("Fahrenheit to Kelvin");
            frame.add(fahrenheitToKelvinRadio);

            JRadioButton kelvinToFahrenheitRadio = new JRadioButton("Kelvin to Fahrenheit");
            frame.add(kelvinToFahrenheitRadio);

            JTextField temperatureField = new JTextField(10);
            frame.add(temperatureField);

            JButton convertButton = new JButton("Перевести температуру");

            convertButton.addActionListener(e -> {
                try {
                    double temperature = Double.parseDouble(temperatureField.getText());

                    if (celsiusToKelvinRadio.isSelected()) {
                        controller.convertTemperatureFromCelsiusToKelvin(temperature);
                    } else if (kelvinToCelsiusRadio.isSelected()) {
                        controller.convertTemperatureFromKelvinToCelsius(temperature);
                    } else if (celsiusToFahrenheitRadio.isSelected()) {
                        controller.convertTemperatureFromCelsiusToFahrenheit(temperature);
                    } else if (fahrenheitToCelsiusRadio.isSelected()) {
                        controller.convertTemperatureFromFahrenheitToCelsius(temperature);
                    } else if (fahrenheitToKelvinRadio.isSelected()) {
                        controller.convertTemperatureFromFahrenheitToKelvin(temperature);
                    } else {
                        controller.convertTemperatureFromKelvinToFahrenheit(temperature);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Температура должна быть числом");
                }
            });

            frame.add(convertButton);

            kelvinCelsiusTemperatureLabel = new JLabel();
            frame.add(kelvinCelsiusTemperatureLabel);

            kelvinFahrenheitTemperatureLabel = new JLabel();
            frame.add(kelvinFahrenheitTemperatureLabel);

            celsiusKelvinTemperatureLabel = new JLabel();
            frame.add(celsiusKelvinTemperatureLabel);

            celsiusFahrenheitTemperatureLabel = new JLabel();
            frame.add(celsiusFahrenheitTemperatureLabel);

            fahrenheitCelsiusTemperatureLabel = new JLabel();
            frame.add(fahrenheitCelsiusTemperatureLabel);

            fahrenheitKelvinTemperatureLabel = new JLabel();
            frame.add(fahrenheitKelvinTemperatureLabel);

            frame.setVisible(true);

        });
    }

    @Override
    public void setKelvinCelsiusTemperature(double kelvinTemperature) {
        kelvinCelsiusTemperatureLabel.setText("Результат в градусах Кельвина: " + kelvinTemperature);
    }

    @Override
    public void setCelsiusKelvinTemperature(double celsiusTemperature) {
        celsiusKelvinTemperatureLabel.setText("Результат в градусах Цельсия: " + celsiusTemperature);
    }

    @Override
    public void setFahrenheitCelsiusTemperature(double fahrenheitTemperature) {
        fahrenheitCelsiusTemperatureLabel.setText("Результат в градусах Фаренгейта: " + fahrenheitTemperature);
    }

    @Override
    public void setCelsiusFahrenheitTemperature(double celsiusTemperature) {
        celsiusFahrenheitTemperatureLabel.setText("Результат в градусах Цельсия: " + celsiusTemperature);
    }

    @Override
    public void setKelvinFahrenheitTemperature(double kelvinTemperature) {
        kelvinFahrenheitTemperatureLabel.setText("Результат в градусах Кельвина: " + kelvinTemperature);
    }

    @Override
    public void setFahrenheitKelvinTemperature(double fahrenheitTemperature) {
        fahrenheitKelvinTemperatureLabel.setText("Результат в градусах Фаренгейта: " + fahrenheitTemperature);
    }
}