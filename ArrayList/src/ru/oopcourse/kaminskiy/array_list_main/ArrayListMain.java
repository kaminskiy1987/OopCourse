package ru.oopcourse.kaminskiy.array_list_main;

import ru.oopcourse.kaminskiy.array_list.ArrayList;

import java.util.Arrays;
import java.util.Iterator;

public class ArrayListMain {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        ArrayList arrayList = new ArrayList<>(6);
        //noinspection unchecked
        arrayList.add(1);
        //noinspection unchecked
        arrayList.add(5);
        arrayList.add(14);
        arrayList.add(9);
        arrayList.add("a");
        arrayList.add("b");
        arrayList.add("c");

        ArrayList arrayList1 = new ArrayList<>(6);
        arrayList1.add(1);
        arrayList1.add(5);
        arrayList1.add(14);
        arrayList1.add(9);
        arrayList1.add("a");
        arrayList1.add("b");
        arrayList1.add("t");
        arrayList1.add("t");
        arrayList1.add("t");

        Object[] array = arrayList.toArray();

        System.out.println("arrayList : " + Arrays.toString(arrayList.toArray()));
        System.out.println("arrayList : " + Arrays.toString(arrayList1.toArray()));

        System.out.println("addAll(collection) : " + arrayList1.addAll(arrayList));
        System.out.println("arrayList1 : " + Arrays.toString(arrayList1.toArray()));

        System.out.println("addAll(index, collection) : " + arrayList1.addAll(1, arrayList));
        System.out.println("arrayList1 : " + Arrays.toString(arrayList1.toArray()));

        System.out.println("removeAll : " + arrayList1.removeAll(arrayList));
        System.out.println("arrayList1 : " + Arrays.toString(arrayList1.toArray()));

        System.out.println("retainAll : " + arrayList1.retainAll(arrayList));
        System.out.println("arrayList1 : " + Arrays.toString(arrayList1.toArray()));

        System.out.println("set : " + arrayList.set(2, 12));
        System.out.println("get : " + arrayList.get(3));
        System.out.println("size : " + arrayList.size());
        System.out.println("size : " + arrayList1.size());
        System.out.println("isEmpty : " + arrayList.isEmpty());
        System.out.println("remove : " + arrayList.remove(2));
        System.out.println("remove(boolean) : " + arrayList.remove("a"));
        System.out.println("indexOf : " + arrayList.indexOf("b"));
        System.out.println("lastIndexOf : " + arrayList.lastIndexOf("b"));
        System.out.println("contains : " + arrayList.contains("w"));
        System.out.println("containsAll : " + arrayList1.containsAll(arrayList));
        System.out.println("toArray : " + Arrays.toString(arrayList.toArray(array)));

        arrayList.ensureCapacity(20);
        arrayList.add(4);
        arrayList.add(4);
        arrayList.add(4);
        arrayList.add(5);
        System.out.println("arrayList : " + Arrays.toString(arrayList.toArray()));

        arrayList.trimToSize();
        System.out.println("arrayList : " + Arrays.toString(arrayList.toArray()));

        arrayList.add(4);
        arrayList.clear();

        arrayList.add(14);
        System.out.println("get : " + arrayList.get(0));

        ArrayList strings = new ArrayList<>();
        strings.add("q");
        strings.add("w");
        strings.add("a");
        strings.add("s");

        Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            String s = iterator.next();

            if (s.equals("w")) {
                iterator.hasNext();
            } else {
                System.out.println(s);
            }
        }
    }
}