package ru.oopcourse.kaminskiy.array_list_main;

import ru.oopcourse.kaminskiy.array_list.ArrayList;

import java.util.Iterator;

public class ArrayListMain {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList1 = new ArrayList<>(10);
        arrayList1.add(1);
        arrayList1.add(5);
        arrayList1.add(14);
        arrayList1.add(9);
        arrayList1.add(9);

        ArrayList<String> arrayList2 = new ArrayList<>(10);
        arrayList2.add("a");
        arrayList2.add("b");
        arrayList2.add("c");
        arrayList2.add("a");
        arrayList2.add("b");
        arrayList2.add("c");
        arrayList2.add("a");
        arrayList2.add("b");
        arrayList2.add("c");

        ArrayList<String> arrayList3 = new ArrayList<>(10);
        arrayList3.add("a");
        arrayList3.add("a");
        arrayList3.add("a");
        arrayList3.add("a");
        arrayList3.add("a");
        arrayList3.add("b");
        arrayList3.add("t");
        arrayList3.add("t");
        arrayList3.add("t");

        ArrayList<Integer> arrayList4 = new ArrayList<>(10);
        arrayList4.add(1);
        arrayList4.add(5);
        arrayList4.add(14);
        arrayList4.add(11);
        arrayList4.add(10);

        System.out.println("arrayList1 : " + arrayList1);
        System.out.println("arrayList2 : " + arrayList2);
        System.out.println("arrayList3 : " + arrayList3);
        System.out.println("arrayList4 : " + arrayList4);

        System.out.println("addAll(collection) : " + arrayList1.addAll(arrayList4));
        System.out.println("arrayList1 : " + arrayList1);

        System.out.println("addAll(index, collection) : " + arrayList2.addAll(3, arrayList3));
        System.out.println("arrayList2 : " + arrayList2);

        System.out.println("removeAll : " + arrayList1.removeAll(arrayList4));
        System.out.println("arrayList1 : " + arrayList1);

        System.out.println("retainAll : " + arrayList1.retainAll(arrayList4));
        System.out.println("arrayList1 : " + arrayList1);

        ArrayList<String> strings = new ArrayList<>();
        strings.add("q");
        strings.add("w");
        strings.add("a");
        strings.add("s");

        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.equals("q")) {
                System.out.println("r");
            } else {
                System.out.println(s);
            }
        }

        System.out.println("set : " + arrayList1.set(0, 12));
        System.out.println("get : " + arrayList1.get(1));
        System.out.println("size : " + arrayList1.size());
        System.out.println("size : " + arrayList2.size());
        System.out.println("isEmpty : " + arrayList1.isEmpty());
        System.out.println("remove : " + arrayList1.remove(1));
        System.out.println("arrayList1 : " + arrayList1);

        System.out.println("remove(boolean) : " + arrayList2.remove("a"));
        System.out.println("arrayList1 : " + arrayList2);

        System.out.println("indexOf : " + arrayList2.indexOf("b"));
        System.out.println("arrayList2 : " + arrayList2);

        System.out.println("lastIndexOf : " + arrayList2.lastIndexOf(null));
        System.out.println("arrayList2 : " + arrayList2);

        System.out.println("contains : " + arrayList2.contains("w"));
        System.out.println("arrayList2 : " + arrayList2);

        arrayList1.ensureCapacity(10);
        System.out.println("arrayList1 : " + arrayList1);
        arrayList1.add(4);
        arrayList1.add(4);
        arrayList1.add(4);
        arrayList1.add(5);

        System.out.println("arrayList1 : " + arrayList1);

        arrayList1.trimToSize();
        System.out.println("arrayList1 : " + arrayList1);

        arrayList1.clear();
        arrayList1.add(14);

        System.out.println("get : " + arrayList1.get(0));
    }
}