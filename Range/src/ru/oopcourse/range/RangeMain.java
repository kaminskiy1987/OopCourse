package ru.oopcourse.range;

import java.util.Scanner;

public class RangeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число для проверки: ");
        double number = scanner.nextDouble();

        Range range = new Range(10, 50);
        range.print();

        System.out.println();
        System.out.println("from: " + range.getFrom());
        System.out.println("to: " + range.getTo());
        System.out.println("rangeLength: " + range.getLength());
        System.out.println("rangeInNumber: " + range.isInside(number));

        range.setFrom(10);
        range.setTo(50);

        System.out.println();
        System.out.println("from: " + range.getFrom());
        System.out.println("to: " + range.getTo());
        System.out.println("rangeLength: " + range.getLength());
        System.out.println("rangeInNumber: " + range.isInside(number));
    }
}