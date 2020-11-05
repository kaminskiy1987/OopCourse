package ru.oopcourse.kaminskiy.range_main.RangeMain;

import ru.oopcourse.kaminskiy.range.Range.Range;

import java.util.Arrays;
import java.util.Scanner;

public class RangeMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число для проверки: ");
        double number = scanner.nextDouble();

        Range[] ranges = new Range[2];
        ranges[0] = new Range(10, 30);
        ranges[1] = new Range(25, 50);

        System.out.println(Arrays.toString(ranges));

        System.out.println();
        System.out.println("from: " + ranges[0].getFrom());
        System.out.println("to: " + ranges[0].getTo());
        System.out.println("rangeLength: " + ranges[0].getLength());
        System.out.println("numberIsInsideRange: " + ranges[0].isInside(number));

        ranges[0].setFrom(10);
        ranges[0].setTo(30);

        System.out.println();
        System.out.println("from: " + ranges[0].getFrom());
        System.out.println("to: " + ranges[0].getTo());
        System.out.println("rangeLength: " + ranges[0].getLength());
        System.out.println("numberIsInsideRange: " + ranges[0].isInside(number));

        for (int i = 0; i < ranges.length - 1; i++) {
            System.out.println("getIntersection " + ranges[i].getIntersection(ranges[i + 1]));
            System.out.println("getUnion " + (Arrays.toString(ranges[i].getUnion(ranges[i + 1]))));
            System.out.println("getDifference " + Arrays.toString(ranges[i].getDifference(ranges[i + 1])));
        }
    }
}