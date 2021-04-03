package ru.oopcourse.kaminskiy.temperature_controller;

import ru.oopcourse.kaminskiy.temperature_calculator.TemperatureCalculator;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TemperatureController implements ActionListener {
    private final JComboBox fromCombo;
    private final JComboBox toCombo;
    private final JTextField textInput;
    private final JTextField textOutput;

    public TemperatureController(JComboBox fromCombo, JComboBox toCombo, JTextField textInput, JTextField textOutput) {
        this.fromCombo = fromCombo;
        this.toCombo = toCombo;
        this.textInput = textInput;
        this.textOutput = textOutput;
    }

    public void actionPerformed(ActionEvent e) {
        try {
            TemperatureCalculator from = TemperatureCalculator.selectTemperature((String) fromCombo.getSelectedItem());
            TemperatureCalculator to = TemperatureCalculator.selectTemperature((String) toCombo.getSelectedItem());

            double temperatureValue = Double.parseDouble(textInput.getText());
            textInput.setText(Double.toString(temperatureValue));

            double convertedTemperature = from.convertTemperature(temperatureValue, to);
            textOutput.setText(Double.toString(convertedTemperature));
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(textInput, "The temperature must be a number");
        }
    }
}