package ru.oopcourse.kaminskiy.singly_linked_list;

import ru.oopcourse.kaminskiy.list_item.ListItem;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    private T head;
    private int count;

    public SinglyLinkedList(T head, int count) {
        this.head = head;
        this.count = count;
    }

    public int lengthOfSinglyLinkedList() {
        ListItem<T> current = new ListItem<>(head);
        int count = 0;
        while (current != null) {
            current = current.next;
            count++;
        }
        return count;
    }

    public boolean isEmpty() {
        return lengthOfSinglyLinkedList() == 0;
    }

    public void iterationToIndex() {
        for (ListItem<T> current = new ListItem<>(head); current != null; current = current.next) {
            current.getData();
        }
    }

    public T getFirst() {
        if (head == null) {
            throw new NoSuchElementException("head: " + head + " = null");
        }

        ListItem<T> current = new ListItem<>(head);

        return current.data;
    }

    public T removeFirst(T data) {
        ListItem<T> current = new ListItem<>(head);
        if (current != null) {
            head = (T) current.next;
            current.setNext(null);
        }
        return (T) current;
    }

    public boolean removeByData(int index) {
        if (index < 1 || index > lengthOfSinglyLinkedList()) {
            throw new IndexOutOfBoundsException("index: " + index + " > lengthOfSinglyLinkedList()");
        }
        ListItem<T> current = new ListItem<>(head);
        if (head != null) {
            for (int i = 1; i < index; i++) {
                if (current.next == null) {
                    return false;
                }
                current = current.next;
            }
            current.setNext(current.next.next);
            count--;
            return true;
        }
        return false;
    }

    public void addFirst(T data) {
        ListItem<T> current = new ListItem<>(data);
        if (head != null) {
            current.setNext((ListItem<T>) head);
        }
        head = (T) current;
        count++;
    }

    public void addByIndex(int index, T data) {
        if (index < 1 || index > lengthOfSinglyLinkedList()) {
            throw new IndexOutOfBoundsException("index: " + index + " > lengthOfSinglyLinkedList()");
        }
        ListItem<T> item = new ListItem<T>(data);
        ListItem<T> current = new ListItem<>(head);
        for (int i = 0; i < index && current.next != null; i++) {
            current = current.next;
        }

        item.setNext(current.next);

        current.setNext(item);

        count++;
    }

    public void addLast(T data) {
        ListItem<T> item = new ListItem<T>(data);
        ListItem<T> current = new ListItem<>(head);
        while (current.next != null) {
            current = current.next;
        }
        current.setNext(item);
        count++;
    }

    public T getIndex(int index) {
        if (index < 0) {
            return null;
        }

        ListItem<T> current = new ListItem<>(head);
        current = current.next;

        for (int i = 0; i < index; i++) {
            if (current.next == null) {
                return null;
            }
            current = current.next;
        }
        return current.data;
    }

    public SinglyLinkedList<T> reversList() {
        SinglyLinkedList list = new SinglyLinkedList(head, count);
        ListItem<T> current = new ListItem<>(head);
        while (current != null) {
            list.addLast(current.data);
            current = current.next;
        }
        return list;
    }

    public SinglyLinkedList<T> listClone() {
        SinglyLinkedList clonedLinkedList = new SinglyLinkedList(head, count);
        ListItem<T> current = new ListItem<>(head);
        while (current != null) {
            clonedLinkedList.addLast(current.data);
            current = current.next;
        }
        return clonedLinkedList;
    }
}