package ru.oopcourse.kaminskiy.temperature_main;

import ru.oopcourse.kaminskiy.temperature_view.TemperatureDesktopView;

import javax.swing.*;
import java.awt.*;

public class TemperatureMain {
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(500, 300);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setTitle("Temperature Converter");
        frame.setContentPane(new TemperatureDesktopView());
        frame.setVisible(true);
        frame.getContentPane().setBackground(Color.white);
    }
}