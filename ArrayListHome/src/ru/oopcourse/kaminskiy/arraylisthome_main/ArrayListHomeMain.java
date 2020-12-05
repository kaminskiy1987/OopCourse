package ru.oopcourse.kaminskiy.arraylisthome_main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHomeMain {
    public static ArrayList<String> readFile() throws FileNotFoundException {
        ArrayList<String> list1 = new ArrayList<>();
        try (Scanner scanner = new Scanner(new File("input2.txt"))) {
            while (scanner.hasNextLine()) {
                list1.add(scanner.nextLine());
            }
        }

        return list1;
    }

    public static ArrayList<Integer> removeEvenNumbers(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);

                i--;
            }
        }

        return list;
    }

    public static ArrayList<Integer> getRemoveDuplicates(ArrayList<Integer> list) {
        ArrayList<Integer> newList = new ArrayList<>(10);

        for (Integer element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }

        return newList;
    }

    public static void main(String[] args) throws FileNotFoundException {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(12, 24, 63, 24, 15, 12, 121));

        System.out.println("readFile: " + readFile());

        System.out.println("ArrayList  with duplicates: " + getRemoveDuplicates(list));

        System.out.println("ArrayList  without EvenNumbers: " + removeEvenNumbers(list));
    }
}