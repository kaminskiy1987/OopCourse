package ru.oopcourse.kaminskiy.temperature_view;

import ru.oopcourse.kaminskiy.temperature_calculator.TemperatureCalculator;
import ru.oopcourse.kaminskiy.temperature_scale.TemperatureScale;

import javax.swing.*;
import java.awt.*;

public class TemperatureDesktopView extends JFrame {
    private TemperatureScale[] temperatureScales;
    private TemperatureCalculator temperatureCalculator;

    public TemperatureDesktopView(TemperatureScale[] temperatureScales, TemperatureCalculator temperatureCalculator) {
        this.temperatureScales = temperatureScales;
        this.temperatureCalculator = temperatureCalculator;

        SwingUtilities.invokeLater(() -> {
            setTitle("Temperature Converter");
            Container pane = getContentPane();
            pane.setLayout(new GridLayout(5, 5));

            JButton convertButton = new JButton("Convert");

            JLabel l1 = new JLabel("From", JLabel.CENTER);
            JLabel l2 = new JLabel("To", JLabel.CENTER);
            JLabel data = new JLabel("Data: ", JLabel.CENTER);
            JLabel result = new JLabel("Result is: ", JLabel.CENTER);

            JTextField textInput = new JTextField(20);
            JTextField textOutput = new JTextField(20);

            JComboBox<TemperatureScale> fromComboBox = new JComboBox<>(temperatureScales);
            fromComboBox.setVisible(true);

            JComboBox<TemperatureScale> toComboBox = new JComboBox<>(temperatureScales);
            toComboBox.setVisible(true);

            convertButton.addActionListener(e -> {
                try {
                    TemperatureScale from = ((TemperatureScale) fromComboBox.getSelectedItem());
                    TemperatureScale to = ((TemperatureScale) toComboBox.getSelectedItem());

                    double temperature = Double.parseDouble(textInput.getText());
                    textInput.setText(Double.toString(temperature));

                    double converted = temperatureCalculator.convert(temperature, from, to);
                    textOutput.setText(Double.toString(converted));
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(textInput, "Temperature must be a number");
                }
            });

            pane.add(l1);
            pane.add(fromComboBox);
            pane.add(l2);
            pane.add(toComboBox);
            pane.add(data);
            pane.add(textInput);
            pane.add(result);
            pane.add(textOutput);

            pane.add(convertButton);
            convertButton.setBackground(Color.green);
            setVisible(true);

            textOutput.setBackground(Color.cyan);
            textOutput.setEditable(false);
            textInput.setForeground(Color.blue);

            setSize(400, 200);
            setVisible(true);
            setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
            setResizable(false);
            setLocationRelativeTo(null);
        });
    }
}
