package ru.oopcourse.kaminskiy.singly_linked_list;

import java.util.NoSuchElementException;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList(T data) {
        this.head = new ListItem<>(data);
    }

    public SinglyLinkedList() {
    }

    public int getCount() {
        return count;
    }

    public boolean isEmpty() {
        return count == 0;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        ListItem<T> current = head;

        if (current == null) {
            return stringBuilder.toString();
        }

        if (current.getData() == null) {
            throw new NoSuchElementException("list empty");
        }

        stringBuilder.append("{");

        for (int i = 0; i < getCount(); i++) {
            stringBuilder.append(current.getData().toString()).append(", ");
            current = current.getNext();
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 2).setCharAt(stringBuilder.length() - 1, '}');

        return stringBuilder.toString();
    }

    public ListItem<T> getListItem(int index) {
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

        T deletedData = head.getData();

        head = head.getNext();

        count--;

        return deletedData;
    }

    private void checkPositionIndex(int index) {
        if (!(index >= 0 && index <= count)) {
            throw new IndexOutOfBoundsException("index in range: " + index + " < 0 or >= " + count);
        }
    }

    private void checkElementIndex(int index) {
        if (!(index >= 0 && index < count)) {
            throw new IndexOutOfBoundsException("index in range: " + index + " < 0 or > " + count);
        }
    }

    public boolean removeByData(T data) {
        if (head.getData().equals(data)) {
            if (head.getNext() == null) {
                ListItem<T> newNode = new ListItem<>(data);
                removeFirst();
                head = newNode;

                return true;
            }

            removeFirst();
            return true;
        }

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
        checkElementIndex(index);

        if (index == 0) {
            return removeFirst();
        }

        ListItem<T> currentNode;
        ListItem<T> previousNode = getListItem(index - 1);

        currentNode = previousNode.getNext();

        previousNode.setNext(currentNode.getNext());

        count--;

        return currentNode.getData();
    }

    public void addFirst(T data) {
        head = new ListItem<>(data, head);

        count++;
    }

    public boolean addByIndex(int index, T data) {
        if (head == null) {
            head = new ListItem<>(data);
        }

        checkPositionIndex(index);

        if (index == 0) {
            addFirst(data);

            return true;
        }

        ListItem<T> newNode = new ListItem<>(data);

        ListItem<T> previousNode = getListItem(index - 1);

        newNode.setNext(previousNode.getNext());

        previousNode.setNext(newNode);

        count++;

        return true;
    }

    public void addLast(T data) {
        addByIndex(count, data);
    }

    public T getByIndex(int index) {
        checkElementIndex(index);

        return getListItem(index).getData();
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

    public SinglyLinkedList<T> getClone() {
        if (head == null) {
            return new SinglyLinkedList<>();
        }

        SinglyLinkedList<Integer> clonedList = new SinglyLinkedList<>();
        ListItem<T> current = head;

        while (current != null) {
            clonedList.addLast((Integer) current.getData());
            current = current.getNext();
        }

        //noinspection unchecked
        return (SinglyLinkedList<T>) clonedList;
    }
}