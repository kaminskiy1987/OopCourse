package ru.oopcourse.kaminskiy.range_main;

import ru.oopcourse.kaminskiy.range.Range;

import java.util.Arrays;
import java.util.Scanner;

public class RangeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число для проверки: ");
        double number = scanner.nextDouble();

        Range[] ranges = new Range[]{new Range(10, 30), new Range(15, 25)};

        System.out.println(Arrays.toString(ranges));

        System.out.println();
        System.out.println("from: " + ranges[0].getFrom());
        System.out.println("to: " + ranges[0].getTo());
        System.out.println("rangeLength: " + ranges[0].getLength());
        System.out.println("numberIsInsideRange: " + ranges[0].isInside(number));

        ranges[0].setFrom(5);
        ranges[0].setTo(50);

        System.out.println();
        System.out.println("from: " + ranges[0].getFrom());
        System.out.println("to: " + ranges[0].getTo());
        System.out.println("rangeLength: " + ranges[0].getLength());
        System.out.println("numberIsInsideRange: " + ranges[0].isInside(number));

        System.out.println("getIntersection " + ranges[0].getIntersection(ranges[1]));
        System.out.println("getUnion " + Arrays.toString(ranges[0].getUnion(ranges[1])));
        System.out.println("getDifference " + Arrays.toString(ranges[0].getDifference(ranges[1])));
    }
}