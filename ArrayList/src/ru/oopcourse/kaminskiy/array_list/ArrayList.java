package ru.oopcourse.kaminskiy.array_list;

import java.util.*;

public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private T[] items;
    private int size;

    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity: " + capacity + " < 0");
        }

        //noinspection unchecked
        items = (T[]) new Object[capacity];
    }

    public ArrayList() {
        //noinspection unchecked
        items = (T[]) new Object[DEFAULT_CAPACITY];
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + " < 0 or " + "> " + size);
        }

        return items[index];
    }


    @Override
    public T set(int index, T element) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + " < 0 or " + "> " + size);
        }

        T oldValue = items[index];
        items[index] = element;

        return oldValue;
    }

    public void ensureCapacity(int newCapacity) {
        if (newCapacity >= items.length) {
            T[] old = items;

            //noinspection unchecked
            items = (T[]) new Object[newCapacity];

            items = Arrays.copyOf(old, newCapacity);
        }

    }

    public void trimToSize() {
        ensureCapacity(size);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public boolean add(T element) {
        add(size, element);

        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }

        size = 0;
    }

    @Override
    public void add(int index, T element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index + " < 0 or " + "> " + size);
        }

        if (items.length == size) {
            ensureCapacity(size * 2 + 1);
        }

        if (size - index >= 0) {
            System.arraycopy(items, index + 1, items, index + 1, size - index);
        }

        items[index] = element;

        size++;
    }

    @Override
    public T remove(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index: " + index + " < 0 or " + "> " + size);
        }

        T removeItem = items[index];

        for (int i = index; i < size - 1; i++) {
            items[index] = items[index + 1];
        }

        items[size - 1] = null;

        size--;

        return removeItem;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (items[i].equals(o)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (items[i].equals(o)) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, size);
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T> {
        int cursor = 0;
        int iteratorModCount = size;

        @Override
        public boolean hasNext() throws ConcurrentModificationException {
            if (iteratorModCount != size) {
                throw new ConcurrentModificationException("The Collection changed during the crawl");
            }

            return cursor < size;
        }

        @Override
        public T next() throws ConcurrentModificationException {
            if (!hasNext()) {
                throw new NoSuchElementException("There is no such element");
            }

            cursor++;

            return items[cursor - 1];
        }
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        for (Object o : c) {
            if (!contains(o)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        //noinspection unchecked
        return (T1[]) Arrays.copyOf(items, size, a.getClass());
    }

    @Override
    public boolean remove(Object o) {
        int index = indexOf(o);

        if (index == -1) {
            return false;
        }

        remove(index);

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        boolean isVariable = false;
        for (T element : c) {
            add(element);
            isVariable = true;
        }

        return isVariable;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index: " + index + " < 0 or " + "> " + size);
        }

        boolean isVariable = false;

        for (T element : c) {
            add(index++, element);
            isVariable = true;
        }

        return isVariable;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        boolean isVariable = false;

        for (int i = size - 1; i >= 0; i--) {
            Object o = get(i);

            if (c.contains(o)) {
                remove(i);
                isVariable = true;
            }
        }

        return isVariable;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        boolean isVariable = false;

        for (int i = size - 1; i >= 0; i--) {
            Object o = get(i);

            if (!c.contains(o)) {
                remove(i);
                isVariable = true;
            }
        }

        return isVariable;
    }

    @Override
    public ListIterator<T> listIterator() {
        return null;
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return null;
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return null;
    }
}