package ru.oopcourse.kaminskiy.temperature_calculator;

public enum TemperatureCalculator {
    CELSIUS("Celsius", 1, 0),
    FAHRENHEIT("Fahrenheit", 1.8, 32),
    KELVIN("Kelvin", 1, 273);

    private final String label;
    private final double multiply;
    private final double offset;

    TemperatureCalculator(String label, double multiply, double offset) {
        this.label = label;
        this.multiply = multiply;
        this.offset = offset;
    }

    public static TemperatureCalculator selectTemperature(String label) {
        for (TemperatureCalculator temperatureCalculator : TemperatureCalculator.values()) {
            if (temperatureCalculator.label.equals(label)) {
                return temperatureCalculator;
            }
        }

        return null;
    }

    public double convertTemperature(double value, TemperatureCalculator temperatureCalculator) {
        return (((value - offset) / multiply) * temperatureCalculator.multiply) + temperatureCalculator.offset;
    }
}