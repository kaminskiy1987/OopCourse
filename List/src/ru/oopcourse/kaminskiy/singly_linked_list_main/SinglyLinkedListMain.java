package ru.oopcourse.kaminskiy.singly_linked_list_main;

import ru.oopcourse.kaminskiy.singly_linked_list.SinglyLinkedList;

public class SinglyLinkedListMain {
    public static void main(String[] args) {
        SinglyLinkedList<Integer> list = new SinglyLinkedList<>();

        list.addFirst(20);
        list.addFirst(24);
        list.addFirst(63);
        list.addFirst(25);
        list.addFirst(15);
        list.addFirst(121);

        System.out.println("list: " + list);

        System.out.println("getClone: " + list.getClone());

        list.reverse();

        System.out.println("list: " + list);

        System.out.println("removeByIndex: " + list.removeByIndex(2));

        System.out.println("removeByData: " + list.removeByData(24));

        System.out.println("getFirst: " + list.getFirst());

        System.out.println("getCount: " + list.getCount());

        System.out.println("isEmpty: " + list.isEmpty());

        System.out.println("getByIndex: " + list.getByIndex(0));

        list.addLast(12);

        System.out.println("list: " + list);

        System.out.println("addByIndex: " + list.addByIndex(1, 33));

        System.out.println("removeByData: " + list.removeByData(1));

        System.out.println("removeFirst: " + list.removeFirst());
    }
}