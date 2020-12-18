package ru.oopcourse.kaminskiy.singly_linked_list;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    private ListItem<T> data;
    private int count;

    public SinglyLinkedList(ListItem<T> data) {
        this.data = data;
    }

    public SinglyLinkedList() {
        this.data = null;
    }

    public int getLengthList() {
        return count;
    }

    public boolean isEmpty() {
        return getLengthList() == 0;
    }

    private ListItem<T> getIndexNode(int index) {
        ListItem<T> current = data;

        for (int i = 0; i < (index - 1) && current != null; i++) {
            current = current.getNext();
        }

        return current;
    }

    public T getFirst() {
        if (data == null) {
            throw new NoSuchElementException("list empty");
        }

        ListItem<T> current = data;

        return current.getData();
    }

    public T removeFirst() {
        if (data == null) {
            throw new NoSuchElementException("list empty");
        }

        data.setNext(null);

        return data.getData();
    }

    private void rangeCheck(int index) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("index: " + index + " < 0 or " + "> " + count);
        }
    }

    public boolean removeByData(T value) {
        ListItem<T> current = data;
        ListItem<T> previous = data;

        while (current != null) {
            if (current.getData() == value) {
                previous.setNext(current.getNext());

                return true;
            }

            previous = current;
            current = current.getNext();
        }

        return false;
    }

    public T removeByIndex(int index) {
        rangeCheck(index);

        ListItem<T> current;
        ListItem<T> previous;

        current = getIndexNode(index + 1);
        previous = current;
        previous.setNext(current.getNext());

        count--;

        return current.getData();
    }

    public void addFirst(T value) {
        ListItem<T> current = new ListItem<>(value);

        if (data != null) {
            current.setNext(data);
        }

        data = current;

        count++;
    }

    public void addByIndex(int index, T value) {
        rangeCheck(index);

        ListItem<T> item = new ListItem<>(value);

        if (index == 0) {
            item.setNext(data);
            data = item;
        } else {
            ListItem<T> current;

            current = getIndexNode(index);
            item.setNext(current.getNext());
            current.setNext(item);
        }

        count++;
    }

    public void addLast(T value) {
        if (data == null) {
            addFirst(value);
        }

        addByIndex(count, value);
    }

    public T getByIndex(int index) {
        rangeCheck(index);

        ListItem<T> current;

        current = getIndexNode(index + 1);

        return current.getData();
    }

    public void reverse() {
        ListItem<T> current = data;
        ListItem<T> previous = null;

        while (current != null) {
            ListItem<T> next = current.getNext();
            current.setNext(previous);
            previous = current;
            current = next;
        }

        data = previous;
    }

    public SinglyLinkedList<T> getClone() {
        SinglyLinkedList clonedLinkedList = new SinglyLinkedList();
        ListItem<T> current = data;

        if (data == null) {
            return null;
        }

        //noinspection unchecked
        clonedLinkedList.data = new ListItem(data.getData(), null);
        ListItem tmp = clonedLinkedList.data;

        while (current.getNext() != null) {
            current = current.getNext();
            //noinspection unchecked
            tmp.setNext(new ListItem<>(current.getData(), null));
            tmp = tmp.getNext();
        }
        //noinspection unchecked
        return clonedLinkedList;
    }
}