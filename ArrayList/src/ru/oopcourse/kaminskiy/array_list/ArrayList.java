package ru.oopcourse.kaminskiy.array_list;

import java.util.*;

public class ArrayList<T> implements List<T> {
    private static final int DEFAULT_CAPACITY = 10;

    private T[] items;
    private int size;
    private int modCount;

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
        checkIndex(index);

        return items[index];
    }


    @Override
    public T set(int index, T item) {
        checkIndex(index);

        T oldItem = items[index];
        items[index] = item;

        return oldItem;
    }

    public String toString() {
        if (size == 0) {
            return "{}";
        }

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{");

        for (int i = 0; i < size; i++) {
            stringBuilder.append(items[i]).append(", ");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 2).setCharAt(stringBuilder.length() - 1, '}');

        return stringBuilder.toString();
    }

    private void checkIndexForAdding(int index) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("index out of bounds: " + index + " < 0 or " + index + " > " + size);
        }
    }

    private void checkIndex(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("index out of bounds: " + index + " < 0 or " + index + " >= " + size);
        }
    }


    public void ensureCapacity(int newCapacity) {
        if (newCapacity > items.length) {
            items = Arrays.copyOf(items, newCapacity);
        }
    }

    public void trimToSize() {
        if (size < items.length) {
            items = Arrays.copyOf(items, size);
        }
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
    public boolean add(T item) {
        add(size, item);

        return true;
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            items[i] = null;
        }

        size = 0;

        modCount++;
    }

    @Override
    public void add(int index, T item) {
        checkIndexForAdding(index);

        modCount++;

        if (items.length == 0) {
            ensureCapacity(DEFAULT_CAPACITY);
        }

        if (size == items.length) {
            ensureCapacity(size * 2);
        }

        if (size > index) {
            System.arraycopy(items, index, items, index + 1, size - index);
        }

        items[index] = item;

        size++;
    }

    @Override
    public T remove(int index) {
        checkIndex(index);

        modCount++;

        T removedItem = items[index];

        System.arraycopy(items, index + 1, items, index, size - 1 - index);

        items[size - 1] = null;

        size--;

        return removedItem;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < size; i++) {
            if (Objects.equals(o, items[i])) {
                return i;
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = size - 1; i >= 0; i--) {
            if (Objects.equals(o, items[i])) {
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
        private int currentIndex = -1;
        private final int iteratorModCount = modCount;

        @Override
        public boolean hasNext() {
            return currentIndex + 1 < size;
        }

        @Override
        public T next() {
            if (modCount != iteratorModCount) {
                throw new ConcurrentModificationException("The Collection changed during the crawl");
            }

            if (!hasNext()) {
                throw new NoSuchElementException("There is no such element");
            }

            currentIndex++;

            return items[currentIndex];
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
        if (a.length < size) {
            //noinspection unchecked
            return (T1[]) Arrays.copyOf(items, size, a.getClass());
        }

        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(items, 0, a, 0, size);

        if (a.length > size) {
            a[size] = null;
        }

        return a;
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
        return addAll(size, c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        if (c == null) {
            throw new NullPointerException("The Collection is null");
        }

        checkIndexForAdding(index);

        if (c.size() == 0) {
            return false;
        }

        modCount++;

        ensureCapacity(size + c.size());

        if (index != size) {
            System.arraycopy(items, index, items, index + c.size(), size - index);
        }

        int i = index;

        for (T e : c) {
            items[i] = e;

            i++;
        }

        size += c.size();

        return true;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        if (c.size() == 0) {
            return false;
        }

        int index = 0;
        int i = 0;

        for (; i < size; i++) {
            if (!c.contains(items[i])) {
                items[index] = items[i];

                index++;
            }
        }

        if (index != i) {
            size = index;

            return true;
        }

        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        int index = 0;
        int i = 0;

        for (; i < size; i++) {
            if (c.contains(items[i])) {
                items[index] = items[i];

                index++;
            }
        }

        if (index != i) {
            size = index;

            return true;
        }

        return false;
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