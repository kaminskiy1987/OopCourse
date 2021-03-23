package ru.oopcourse.kaminskiy.view;

import ru.oopcourse.kaminskiy.controller.Controller;
import ru.oopcourse.kaminskiy.convertCelsius.ConvertCelsius;
import ru.oopcourse.kaminskiy.convertFahrenheit.ConvertFahrenheit;
import ru.oopcourse.kaminskiy.convertKelvin.ConvertKelvin;

import javax.swing.*;
import java.awt.*;

public class DesktopView implements View {

    private double temperature;

    private final JFormattedTextField textInput = new JFormattedTextField(15);

    private final JFormattedTextField textOutput = new JFormattedTextField(15);

    public DesktopView(Controller controller) {
    }

    @Override
    public void start() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Конвертер температур");
            frame.setSize(500, 300);

            JLabel data = new JLabel("Данные: ");
            JLabel result = new JLabel("Результат: ");

            JButton convertButton = new JButton("Перевести температуру");

            JLabel l1 = new JLabel("Из");
            JLabel l2 = new JLabel("В");

            String[] fromValue = {"Celsius", "Kelvin", "Fahrenheit"};
            String[] toValue = {"Celsius", "Kelvin", "Fahrenheit"};

            JComboBox jb1 = new JComboBox(fromValue);
            JComboBox jb2 = new JComboBox(toValue);

            frame.setSize(400, 400);

            frame.setLocationRelativeTo(null);
            frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

            frame.setLayout(new FlowLayout());

            frame.add(l1);
            frame.add(jb1);
            frame.add(l2);
            frame.add(jb2);
            System.out.println("");
            frame.add(data);
            frame.add(textInput);

            frame.add(result);
            frame.add(textOutput);
            convertButton.setBounds(130, 100, 100, 40);
            frame.add(convertButton);

            convertButton.setBackground(Color.green);
            frame.setVisible(true);

            textOutput.setBackground(Color.cyan);
            textInput.setForeground(Color.blue);

            convertButton.addActionListener(e -> {
                try {
                    convertButton.setAction(new ConvertFahrenheit(this));
                    convertButton.setAction(new ConvertCelsius(this));
                    convertButton.setAction(new ConvertKelvin(this));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(frame, "Температура должна быть числом");
                }
            });

            frame.add(convertButton);

            frame.setVisible(true);
        });
    }

    @Override
    public double getValue() {
        return temperature;
    }

    @Override
    public void setFahrenheit(double value) {
        textInput.setValue(value);
    }

    @Override
    public void setCelsius(double value) {
        textInput.setValue(value);
    }

    @Override
    public void setKelvin(double value) {
        textInput.setValue(value);
    }
}