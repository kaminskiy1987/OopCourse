package ru.oopcourse.kaminskiy.temperature_view;

import ru.oopcourse.kaminskiy.temperature_controller.TemperatureController;

import javax.swing.*;
import java.awt.*;

public class TemperatureDesktopView extends JPanel {
    public TemperatureDesktopView() {
        JButton convertButton = new JButton("Convert Temperature");

        JLabel fromLabel = new JLabel("From");
        JLabel toLabel = new JLabel("To");

        JLabel data = new JLabel("Data  : ");
        JLabel result = new JLabel("Result is : ");

        JTextField textInput = new JTextField(10);

        JTextField textOutput = new JTextField(10);

        String[] strings = {"Celsius", "Kelvin", "Fahrenheit"};

        @SuppressWarnings("unchecked")
        JComboBox fromCombo = new JComboBox(strings);
        fromCombo.setVisible(true);

        @SuppressWarnings("unchecked")
        JComboBox toCombo = new JComboBox(strings);
        toCombo.setVisible(true);

        convertButton.addActionListener(new TemperatureController(fromCombo, toCombo, textInput, textOutput));

        add(fromLabel);
        add(fromCombo);
        add(toLabel);
        add(toCombo);
        System.out.println();
        add(data);
        add(textInput);

        add(result);
        add(textOutput);
        convertButton.setBounds(130, 100, 100, 40);

        add(convertButton);
        convertButton.setBackground(Color.green);
        setVisible(true);

        textOutput.setBackground(Color.cyan);
        textInput.setForeground(Color.blue);
    }
}