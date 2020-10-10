package ru.oopcourse.range1;

public class RangeMain {
    public static void main(String[] args) {
        Range[] ranges = new Range[2];
        ranges[0] = new Range(10, 50);
        ranges[1] = new Range(20, 70);

        for (int i = 0; i < ranges.length - 1; i++) {
            ranges[i].crossing(ranges[i + 1]);
            ranges[i].combine(ranges[i + 1]);
            ranges[i].difference(ranges[i + 1]);
        }
    }
}