package ru.oopcourse.kaminskiy.arraylisthome_main;

import ru.oopcourse.kaminskiy.arraylisthome.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHomeMain {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(12, 24, 64, 24, 16, 12, 121));

        System.out.println("ArrayList  with duplicates: " + list);

        System.out.println("ArrayList  without duplicates: " + ArrayListHome.removeDuplicates(list));

        //System.out.println("ArrayList without even numbers: " + list.removeEvenNumbers());

        ArrayList<String> newList = new ArrayList<>();
        try (Scanner scanner = new Scanner("input2.txt")) {
            while (scanner.hasNextLine()) {
                newList.add(scanner.nextLine());
            }
        }
    }
}