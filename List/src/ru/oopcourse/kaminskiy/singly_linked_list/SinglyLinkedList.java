package ru.oopcourse.kaminskiy.singly_linked_list;

import java.util.NoSuchElementException;
import java.util.Objects;

public class SinglyLinkedList<T> {
    private ListItem<T> head;
    private int count;

    public SinglyLinkedList(T data) {
        head = new ListItem<>(data);
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
        if (count == 0) {
            return "{}";
        }

        StringBuilder stringBuilder = new StringBuilder();
        ListItem<T> current = head;

        stringBuilder.append("{");

        for (int i = 0; i < count; i++) {
            stringBuilder.append(current.getData()).append(", ");
            current = current.getNext();
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 2).setCharAt(stringBuilder.length() - 1, '}');

        return stringBuilder.toString();
    }

    private ListItem<T> getListItem(int index) {
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

        T removedData = head.getData();

        head = head.getNext();

        count--;

        return removedData;
    }

    private void checkPositionIndex(int index) {
        if (index < 0 || index > count) {
            throw new IndexOutOfBoundsException("index out of bounds: " + index + " < 0 or " + index + " > " + count);

        }
    }

    private void checkElementIndex(int index) {
        if (index < 0 || index >= count) {
            throw new IndexOutOfBoundsException("index out of bounds: " + index + " < 0 or " + index + " >= " + count);
        }
    }

    public boolean removeByData(T data) {
        if (Objects.equals(head.getData(), data)) {
            if (head.getNext() == null) {
                removeFirst();

                return true;
            }
        }

        ListItem<T> nextItem = head.getNext();
        ListItem<T> currentItem = head;

        while (nextItem != null) {
            if (Objects.equals(nextItem.getData(), data)) {
                currentItem.setNext(nextItem.getNext());

                count--;

                return true;
            }

            currentItem = nextItem;
            nextItem = nextItem.getNext();
        }

        return false;
    }


    public T removeByIndex(int index) {
        checkElementIndex(index);

        if (index == 0) {
            return removeFirst();
        }

        ListItem<T> previousNode = getListItem(index - 1);

        ListItem<T> currentNode = previousNode.getNext();

        previousNode.setNext(currentNode.getNext());

        count--;

        return currentNode.getData();
    }

    public void addFirst(T data) {
        head = new ListItem<>(data, head);

        count++;
    }

    public boolean addByIndex(int index, T data) {
        checkPositionIndex(index);

        if (index == 0) {
            addFirst(data);

            return true;
        }

        ListItem<T> previousNode = getListItem(index - 1);
        ListItem<T> newNode = new ListItem<>(data, previousNode.getNext());

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

    public T setByIndex(int index, T data) {
        checkElementIndex(index);

        ListItem<T> currentItem = getListItem(index);
        T insertedData = currentItem.getData();
        currentItem.setData(data);

        return insertedData;
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

        SinglyLinkedList<T> clonedList = new SinglyLinkedList<>(head.getData());
        ListItem<T> current = head;
        ListItem<T> clonedNode = clonedList.head;

        while (current.getNext() != null) {
            current = current.getNext();
            clonedNode.setNext(new ListItem<>(current.getData()));
            clonedNode = clonedNode.getNext();
        }

        return clonedList;
    }
}