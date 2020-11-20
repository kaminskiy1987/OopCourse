package ru.oopcourse.kaminskiy.arraylisthome;

import java.util.ArrayList;

public class ArrayListHome {
    private final ArrayList<Integer> items;

    public ArrayListHome(ArrayList<Integer> items) {
        this.items = items;
    }

    public int size() {
        return items.size();
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public void removeEvenNumbers() {
        for (int i = 0; i < items.size(); i++) {
            int evenNumbersCount = items.get(i) % 2;

            if (evenNumbersCount == 0) {
                items.remove(i);

                i--;
            }
        }
    }

    public static <Integer> ArrayList<Integer> removeDuplicates(ArrayList<Integer> items) {
        ArrayList<Integer> newList = new ArrayList<Integer>();

        for (Integer element : items) {
            if (!newList.contains(element)) {
                newList.add(element);
            }
        }
        return newList;
    }
}