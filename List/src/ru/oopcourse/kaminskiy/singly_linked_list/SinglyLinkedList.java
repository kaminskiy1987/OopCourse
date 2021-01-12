package ru.oopcourse.kaminskiy.singly_linked_list;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList(T head, int count) {
        this.head = new ListItem<>(head);
        this.count = count;
    }

    public SinglyLinkedList() {
    }

    public int getCount() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ListItem<T> current = head;

        stringBuilder.append("{");

        for (int i = 0; i < getCount(); i++) {
            stringBuilder.append(current.getData().toString()).append(", ");
            current = current.getNext();
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 2).setCharAt(stringBuilder.length() - 1, '}');

        return stringBuilder.toString();
    }

    private ListItem<T> iteratingOnList(int index) {
        ListItem<T> current = head;

        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }

        return current;
    }

    public T getFirst() {
        if (head == null) {
            throw new NoSuchElementException("list empty");
        }

        return head.getData();
    }

    public T removeFirst() {
        if (head == null) {
            throw new NoSuchElementException("list empty");
        }

        T current = head.getData();
        head = head.getNext();

        return current;
    }

    private void checkIndex(int index) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("index: " + index + " < 0 or " + "> " + count);
        }
    }

    public boolean removeByData(T data) {
        ListItem<T> current = head;
        ListItem<T> previous = null;

        while (current != null) {
            if (current.getData().equals(data)) {
                previous.setNext(current.getNext());

                count--;

                return true;
            }

            previous = current;
            current = current.getNext();
        }

        return false;
    }

    public T removeByIndex(int index) {
        checkIndex(index);

        ListItem<T> current = iteratingOnList(index - 1);
        current.setNext(current.getNext().getNext());

        count--;

        return current.getData();
    }

    public void addFirst(T data) {
        head = new ListItem<>(data, head);

        count++;
    }

    public T addByIndex(int index, T data) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("index: " + index + " < 0 ");
        }

        if (index == 0) {
            addFirst(data);

            return data;
        }

        ListItem<T> item = new ListItem<>(data);

        ListItem<T> current = iteratingOnList(index - 1);
        item.setNext(current.getNext());

        current.setNext(item);

        count++;

        return data;
    }

    public void addLast(T data) {
        addByIndex(count, data);
    }

    public T getByIndex(int index) {
        checkIndex(index);

        return iteratingOnList(index).getData();
    }

    public void reverse() {
        ListItem<T> current = head;
        ListItem<T> previous = null;

        while (current != null) {
            ListItem<T> next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }

        head = previous;
    }

    public SinglyLinkedList<Integer> getClone() {
        if (head == null) {
            return new SinglyLinkedList<>();
        }

        SinglyLinkedList<Integer> clonedList = new SinglyLinkedList(head, count);
        ListItem<T> current = head;

        clonedList.head = new ListItem<>((Integer) head.getData());
        ListItem<Integer> clonedNode = clonedList.head;

        while (current.getNext() != null) {
            current = current.getNext();
            clonedNode.setNext(new ListItem<>((Integer) current.getData()));
            clonedNode = clonedNode.getNext();
        }

        return clonedList;
    }
}