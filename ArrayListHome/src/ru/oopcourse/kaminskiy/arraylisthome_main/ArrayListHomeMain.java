package ru.oopcourse.kaminskiy.arraylisthome_main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayListHomeMain {
    public static ArrayList<String> getFileLines(String fileName) {
        ArrayList<String> newList = new ArrayList<>();
        
        try (Scanner scanner = new Scanner(new File(fileName))) {
            while (scanner.hasNextLine()) {
                newList.add(scanner.nextLine());
            }
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }

        return newList;
    }

    public static void removeEvenNumbers(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) % 2 == 0) {
                list.remove(i);

                i--;
            }
        }
    }

    public static ArrayList<Integer> getListWithoutDuplicates(ArrayList<Integer> list) {
        ArrayList<Integer> newList = new ArrayList<>(list.size());

        for (Integer element : list) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }

        return newList;
    }

    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(12, 24, 63, 24, 15, 12, 121));

        String fileName = "input2.txt";

        System.out.println("fileLines: " + getFileLines(fileName));

        System.out.println("Duplicates in ArrayList: " + getListWithoutDuplicates(list));

        removeEvenNumbers(list);

        System.out.println("ArrayList  without EvenNumbers: " + list);
    }
}