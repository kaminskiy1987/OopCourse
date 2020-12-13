package ru.oopcourse.kaminskiy.array_list_main;

import ru.oopcourse.kaminskiy.array_list.ArrayList;

import java.util.Arrays;

public class ArrayListMain {
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList<>(6);
        arrayList.add(1);
        arrayList.add(5);
        arrayList.add(14);
        arrayList.add(9);
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");

        ArrayList arrayList1 = new ArrayList<>(6);
        arrayList.add(1);
        arrayList.add(5);
        arrayList.add(14);
        arrayList.add(9);
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");

        System.out.println("arrayList : " + Arrays.toString(arrayList.toArray()));
        //noinspection unchecked
        System.out.println("set : " + arrayList.set(2, 12));
        System.out.println("get : " + arrayList.get(3));
        System.out.println("size : " + arrayList.size());
        System.out.println("isEmpty : " + arrayList.isEmpty());
        System.out.println("remove : " + arrayList.remove(3));
        System.out.println("indexOf : " + arrayList.indexOf("a"));
        System.out.println("lastIndexOf : " + arrayList.lastIndexOf("1"));
        System.out.println("contains : " + arrayList.contains("w"));
        //noinspection unchecked
        System.out.println("containsAll : " + arrayList1.containsAll(arrayList));

        arrayList.ensureCapacity(10);
        arrayList.trimToSize();
        arrayList.add(4);
        arrayList.clear();
        arrayList.add(14);
        System.out.println("get : " + arrayList.get(0));
    }
}