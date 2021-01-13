package ru.oopcourse.kaminskiy.array_list_main;

import ru.oopcourse.kaminskiy.array_list.ArrayList;

import java.util.Iterator;

public class ArrayListMain {
    public static void main(String[] args) {
        ArrayList<Integer> arrayList = new ArrayList<>(10);
        arrayList.add(1);
        arrayList.add(5);
        arrayList.add(14);
        arrayList.add(9);
        arrayList.add(9);

        ArrayList<String> arrayList1 = new ArrayList<>(10);
        arrayList1.add("a");
        arrayList1.add("b");
        arrayList1.add("c");
        arrayList1.add("a");
        arrayList1.add("b");
        arrayList1.add("c");
        arrayList1.add("a");
        arrayList1.add("b");
        arrayList1.add("c");

        ArrayList<String> arrayList2 = new ArrayList<>(10);
        arrayList2.add("a");
        arrayList2.add("a");
        arrayList2.add("a");
        arrayList2.add("a");
        arrayList2.add("a");
        arrayList2.add("b");
        arrayList2.add("t");
        arrayList2.add("t");
        arrayList2.add("t");

        ArrayList<Integer> arrayList3 = new ArrayList<>(10);
        arrayList3.add(1);
        arrayList3.add(5);
        arrayList3.add(14);
        arrayList3.add(9);

        System.out.println("arrayList : " + arrayList);
        System.out.println("arrayList1 : " + arrayList1);

        System.out.println("addAll(collection) : " + arrayList1.addAll(arrayList2));
        System.out.println("arrayList1 : " + arrayList1);

        System.out.println("addAll(index, collection) : " + arrayList1.addAll(1, arrayList2));
        System.out.println("arrayList2 : " + arrayList1);

        System.out.println("removeAll : " + arrayList.removeAll(arrayList3));
        System.out.println("arrayList3 : " + arrayList);

        System.out.println("retainAll : " + arrayList.retainAll(arrayList3));
        System.out.println("arrayList4 : " + arrayList);

        ArrayList<String> strings = new ArrayList<>();
        strings.add("q");
        strings.add("w");
        strings.add("a");
        strings.add("s");

        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();
            if (s.equals("r")) {
                System.out.println("r");
            } else {
                System.out.println(s);
            }
        }

        System.out.println("set : " + arrayList.set(2, 12));
        System.out.println("get : " + arrayList.get(3));
        System.out.println("size : " + arrayList.size());
        System.out.println("size : " + arrayList1.size());
        System.out.println("isEmpty : " + arrayList.isEmpty());
        System.out.println("remove : " + arrayList.remove(2));
        System.out.println("arrayList : " + arrayList);

        System.out.println("remove(boolean) : " + arrayList1.remove("a"));
        System.out.println("arrayList1 : " + arrayList1);

        System.out.println("indexOf : " + arrayList1.indexOf("b"));
        System.out.println("arrayList1 : " + arrayList1);

        System.out.println("lastIndexOf : " + arrayList1.lastIndexOf(null));
        System.out.println("arrayList1 : " + arrayList1);

        System.out.println("contains : " + arrayList1.contains("w"));
        System.out.println("arrayList : " + arrayList1);

        arrayList.ensureCapacity(10);
        System.out.println("arrayList2 : " + arrayList);
        arrayList.add(4);
        arrayList.add(4);
        arrayList.add(4);
        arrayList.add(5);

        System.out.println("arrayList3 : " + arrayList);

        arrayList.trimToSize();
        System.out.println("arrayList4 : " + arrayList);

        arrayList.clear();
        arrayList.add(14);

        System.out.println("get : " + arrayList.get(0));
    }
}