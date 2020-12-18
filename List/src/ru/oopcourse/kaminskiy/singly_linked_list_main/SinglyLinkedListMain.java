package ru.oopcourse.kaminskiy.singly_linked_list_main;

import ru.oopcourse.kaminskiy.singly_linked_list.SinglyLinkedList;

public class SinglyLinkedListMain {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList();

        //noinspection unchecked
        singlyLinkedList.addFirst(20);

        //noinspection unchecked
        singlyLinkedList.addFirst(24);

        //noinspection unchecked
        singlyLinkedList.addFirst(63);

        //noinspection unchecked
        singlyLinkedList.addFirst(25);

        //noinspection unchecked
        singlyLinkedList.addFirst(15);

        //noinspection unchecked
        singlyLinkedList.addFirst(121);

        System.out.println("removeByIndex: " + singlyLinkedList.removeByIndex(0));

        //noinspection unchecked
        System.out.println("removeByData: " + singlyLinkedList.removeByData(24));

        System.out.println("getFirst: " + singlyLinkedList.getFirst());

        System.out.println("getLengthList: " + singlyLinkedList.getLengthList());

        System.out.println("isEmpty: " + singlyLinkedList.isEmpty());

        System.out.println("getByIndex: " + singlyLinkedList.getByIndex(0));

        //noinspection unchecked
        singlyLinkedList.addLast(12);

        //noinspection unchecked
        singlyLinkedList.addByIndex(1, 33);

        //noinspection unchecked
        System.out.println("removeByData: " + singlyLinkedList.removeByData(1));

        System.out.println("removeFirst: " + singlyLinkedList.removeFirst());

        System.out.println("getClone: " + singlyLinkedList.getClone());

        singlyLinkedList.reverse();
    }
}