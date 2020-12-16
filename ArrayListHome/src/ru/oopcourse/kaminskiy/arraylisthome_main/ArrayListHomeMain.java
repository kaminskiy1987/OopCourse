package ru.oopcourse.kaminskiy.arraylisthome_main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHomeMain {
    public static ArrayList<String> getLinesOfFile(ArrayList<String> list) {
        try (Scanner scanner = new Scanner(new File("input2.txt"))) {
            while (scanner.hasNextLine()) {
                list.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("Файл не найден: " + e.getMessage());
        }

        return list;
    }

    public static void removeEvenNumbers(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);

                i--;
            }
        }
    }

    public static ArrayList<Integer> getListWithoutDuplicates(ArrayList<Integer> list, int capacity) {
        ArrayList<Integer> newList = new ArrayList<>(capacity);

        for (Integer element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }

        return newList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(12, 24, 63, 24, 15, 12, 121));

        ArrayList<String> listLines = new ArrayList<>();

        System.out.println("linesFile: " + getLinesOfFile(listLines));

        System.out.println("Duplicates in ArrayList: " + getListWithoutDuplicates(list, list.size()));

        removeEvenNumbers(list);

        System.out.println("ArrayList  without EvenNumbers: " + list);
    }
}