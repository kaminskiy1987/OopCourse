package ru.oopcourse.range1;

public class Range {
    private double from;
    private double to;

    public Range(double from, double to) {
        this.from = from;
        this.to = to;
    }

    public void print() {
        System.out.printf("%f %f", from, to);
    }

    public double getFrom() {
        return from;
    }

    public void setFrom(double from) {
        this.from = from;
    }

    public double getTo() {
        return to;
    }

    public void setTo(double to) {
        this.to = to;
    }

    public void crossing(Range range) {
        double x = Math.max(from, range.getFrom());
        double y = Math.min(to, range.getTo());

        if (x < y) {
            System.out.printf("Интервалы пересекаются (%f, %f)", x, y);
            System.out.println();
        } else {
            System.out.println("Интервалы не пересекаются");
            System.out.println(-1);
        }
    }

    public void combine(Range range) {
        if (from < range.getTo() && range.getFrom() < to) {
            double x = Math.min(from, range.getFrom());
            double y = Math.max(to, range.getTo());

            System.out.println("Обьединение");
            System.out.printf("Интервалы (%f, %f)", x, y);
        } else {
            System.out.println("Обьединение");
            System.out.printf("Интервалы (%f, %f), (%f, %f)", from, to, range.getFrom(), range.getTo());
        }

        System.out.println();
    }

    public void difference(Range range) {
        double x = Math.max(from, range.getFrom());
        double y = Math.min(to, range.getTo());

        if (x < y) {
            if (x == range.getFrom() && y == range.getTo()) {
                System.out.println("Разность");
                System.out.printf("Интервалы (%f, %f), (%f, %f)", from, x, y, to);
            } else if (from > range.getFrom() && to > range.getTo()) {
                System.out.printf("Интервал (%f, %f)", y, to);
            } else {
                System.out.printf("Интервал (%f, %f)", from, x);
            }
        } else {
            System.out.println("Интервалы не пересекаются разности нет");
        }
    }
}