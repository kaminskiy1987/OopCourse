package ru.oopcourse.kaminskiy.hash_table_main;

import ru.oopcourse.kaminskiy.hash_table.HashTable;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;

public class HashTableMain {
    public static void main(String[] args) {
        HashTable<Integer> arrayList1 = new HashTable<>(3);
        arrayList1.add(2);
        arrayList1.add(3);
        arrayList1.add(5);
        arrayList1.add(14);
        arrayList1.add(9);

        HashTable<String> arrayList2 = new HashTable<>(7);
        arrayList2.add("d");
        arrayList2.add("c");
        arrayList2.add("a");
        arrayList2.add("c");
        arrayList2.add("c");
        arrayList2.add("c");
        arrayList2.add("z");

        HashTable<String> arrayList3 = new HashTable<>(10);
        arrayList3.add("a");
        arrayList3.add("c");
        arrayList3.add("b");
        arrayList3.add("p");
        arrayList3.add("k");
        arrayList3.add("d");

        HashTable<Integer> arrayList4 = new HashTable<>(4);
        arrayList4.add(1);
        arrayList4.add(5);
        arrayList4.add(14);
        arrayList4.add(9);

        System.out.println("arrayList1 : " + arrayList1);
        System.out.println("arrayList2 : " + arrayList2);
        System.out.println("arrayList3 : " + arrayList3);
        System.out.println("arrayList4 : " + arrayList4);
        
        System.out.println("addAll(collection): " + arrayList1.addAll(arrayList4));
        System.out.println("arrayList2_addAll: " + arrayList1);
        System.out.println("arrayList3_addAll: " + arrayList4);

        System.out.println("removeAll: " + arrayList2.removeAll(arrayList3));
        System.out.println("arrayList2: " + arrayList2);
        System.out.println("arrayList3: " + arrayList3);

        System.out.println("retainAll: " + arrayList2.retainAll(arrayList3));
        System.out.println("arrayList4: " + arrayList2);
        System.out.println("arrayList41: " + arrayList3);

        ArrayList<String> strings = new ArrayList<>();
        strings.add("q");
        strings.add("w");
        strings.add("a");
        strings.add("s");

        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.equals("q")) {
                System.out.println("Yes");
            } else {
                System.out.println("No");
            }
        }

        System.out.println("size: " + arrayList1.size());
        System.out.println("size: " + arrayList4.size());
        System.out.println("isEmpty: " + arrayList1.isEmpty());
        System.out.println("remove: " + arrayList1.remove(4));
        System.out.println("arrayList: " + arrayList1);

        System.out.println("remove(boolean): " + arrayList2.remove("b"));
        System.out.println("arrayList1: " + arrayList2);

        System.out.println("contains: " + arrayList2.contains("w"));
        System.out.println("arrayList: " + arrayList2);

        System.out.println("toArray: " + Arrays.toString(arrayList1.toArray()));

        System.out.println("containsAll: " + arrayList2.containsAll(arrayList3));
        System.out.println("arrayList2: " + arrayList2);

        arrayList1.clear();
        System.out.println("arrayList1: " + arrayList1);
    }
}
