package ru.oopcourse.kaminskiy.array_list;

import java.util.*;

public class ArrayList<T> implements List<T> {
    private static final int CAPACITY = 10;

    private T[] items;
    private int capacity;

    public ArrayList(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("capacity: " + capacity + " < 0");
        }

        //noinspection unchecked
        items = (T[]) new Object[capacity];
    }

    @Override
    public T get(int index) {
        if (index >= capacity) {
            throw new IndexOutOfBoundsException("index: " + index + " >= capacity");
        }

        return items[index];
    }


    @Override
    public T set(int index, T element) {
        if (index >= capacity) {
            throw new IndexOutOfBoundsException("index: " + index + " >= capacity");
        }

        T oldValue = items[index];
        items[index] = element;

        return oldValue;
    }

    public void ensureCapacity(int newCapacity) {
        if (newCapacity < capacity) {
            return;
        }

        T[] old = items;
        //noinspection unchecked
        items = (T[]) new Object[newCapacity];

        if (capacity >= 0) {
            System.arraycopy(old, 0, items, 0, capacity);
        }

    }

    public void trimToSize() {
        if (capacity < items.length) {
            @SuppressWarnings("unchecked") T[] newArray = (T[]) new Object[capacity];

            System.arraycopy(items, 0, newArray, 0, capacity);

            items = newArray;
            capacity = size();
        }
    }

    @Override
    public int size() {
        return capacity;
    }

    @Override
    public boolean isEmpty() {
        return capacity == 0;
    }

    @Override
    public boolean contains(Object o) {
        return indexOf(o) >= 0;
    }

    @Override
    public boolean add(Object o) {
        //noinspection unchecked
        add(capacity, (T) o);

        return true;
    }

    @Override
    public void clear() {
        capacity = 0;
        ensureCapacity(CAPACITY);
    }

    @Override
    public void add(int index, T element) {
        if (index > capacity || index < 0) {
            throw new IndexOutOfBoundsException("index: " + index + " < 0");
        }

        if (items.length == capacity) {
            ensureCapacity(capacity * 2 + 1);
        }

        if (capacity - index >= 0) {
            System.arraycopy(items, index, items, index + 1, capacity - index);
        }

        items[index] = element;
        capacity++;
    }

    @Override
    public T remove(int index) {
        if (index >= capacity) {
            throw new IndexOutOfBoundsException("index: " + index + " >= capacity");
        }

        T removeItem = items[index];

        if (capacity - 1 - index >= 0) {
            System.arraycopy(items, index + 1, items, index, capacity - 1 - index);
        }

        capacity--;
        return removeItem;
    }

    @Override
    public int indexOf(Object o) {
        if (o == null) {
            for (int i = 0; i < capacity; i++) {
                if (items[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = 0; i < capacity; i++) {
                if (o.equals(items[i])) {
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        if (o == null) {
            for (int i = capacity - 1; i >= 0; i--) {
                if (items[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i = capacity - 1; i >= 0; i--) {
                if (o.equals(items[i])) {
                    return i;
                }
            }
        }

        return -1;
    }

    @Override
    public Object[] toArray() {
        return Arrays.copyOf(items, capacity);
    }

    @Override
    public Iterator<T> iterator() {
        return new ArrayListIterator();
    }

    private class ArrayListIterator implements Iterator<T> {
        private int current = 0;

        @Override
        public boolean hasNext() {
            return current < capacity;
        }

        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            return items[current++];
        }

        @Override
        public void remove() {
            ArrayList.this.remove(current--);
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
        if (a.length < capacity) {
            //noinspection unchecked
            return (T1[]) Arrays.copyOf(items, capacity, a.getClass());
        }

        System.arraycopy(items, 0, a, 0, capacity);

        if (a.length > capacity) {
            a[capacity] = null;
        }

        return a;
    }

    @Override
    public boolean remove(Object o) {
        return false;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {

        return false;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return false;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
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