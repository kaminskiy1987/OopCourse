package ru.oopcourse.kaminskiy.singly_linked_list_main;

import ru.oopcourse.kaminskiy.singly_linked_list.SinglyLinkedList;

import java.util.Arrays;

public class SinglyLinkedListMain {
    public static void main(String[] args) {
        SinglyLinkedList singlyLinkedList = new SinglyLinkedList(Arrays.asList(12 ,24 ,63 ,24 ,15 ,12 ,121), 7);

        singlyLinkedList.addFirst("12");
        singlyLinkedList.addFirst("24");
        singlyLinkedList.addFirst("63");
        singlyLinkedList.addFirst("25");
        singlyLinkedList.addFirst("15");
        singlyLinkedList.addFirst("121");

        System.out.println();
        System.out.println("from: " + singlyLinkedList.lengthOfSinglyLinkedList());
        System.out.println("to: " + singlyLinkedList.getFirst());
        System.out.println("rangeLength: " + singlyLinkedList.removeByData(3));
        System.out.println("numberIsInsideRange: " + singlyLinkedList.removeFirst(12));
        System.out.println("numberIsInsideRange: " + singlyLinkedList.listClone());
        System.out.println(singlyLinkedList.reversList());
        System.out.println("numberIsInsideRange: " + singlyLinkedList.getIndex(2));
    }
}