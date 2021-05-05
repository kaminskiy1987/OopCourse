package ru.oopcourse.kaminskiy.hash_table;

import java.util.*;

public class HashTable<T> implements Collection<T> {
    private static int INITIAL_SIZE = 16;
    private int size;
    private final ArrayList<T>[] table;
    private int modCount = 0;

    public HashTable(int capacity) {
        if (capacity < 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + capacity);
        }

        table = new ArrayList[capacity];
    }

    public HashTable() {
        table = new ArrayList[INITIAL_SIZE];
    }

    private int hash(Object value) {
        return (Math.abs(value.hashCode())) % table.length;
    }

    @Override
    public boolean add(T item) {
        if (item == null) {
            throw new NullPointerException("Element cannot be null.");
        }

        modCount++;

        if (table[hash(item)] == null) {
            table[hash(item)] = new ArrayList<>();
        }

        if (table[hash(item)].contains(item)) {
            return false;
        }

        table[hash(item)].add(item);

        size++;

        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> collection) {
        if (collection == null) {
            throw new NullPointerException("The Collection is null");
        }

        if (collection.size() == 0) {
            return false;
        }

        modCount++;

        int i = size;
        for (T e : collection) {
            //noinspection unchecked
            table[i] = (ArrayList<T>) e;

            i++;
        }

        size += collection.size();
        return true;
    }

    @Override
    public void clear() {
        for (int i = table.length - 1; i >= 0; i--) {
            table[i] = null;
        }
        modCount++;

        size = 0;
    }

    @Override
    public boolean contains(Object o) {
        if (o == null) {
            throw new NullPointerException("Value cannot be null.");
        }

        return table[hash(o)] != null && table[hash(o)].contains(o);
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        for (Object o : collection) {
            if (!contains(o)) {
                return false;
            }
        }

        return true;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(Object o) {
        if (o == null) {
            throw new NullPointerException("Target cannot be null.");
        }

        if (!contains(o)) {
            return false;
        }

        modCount++;

        table[hash(o)].remove(o);

        return true;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Iterator<T> iterator() {
        return new iterator();
    }

    private class iterator implements Iterator<T> {
        private int iteratorModCount = modCount;
        protected int currentIndex = -1;

        @Override
        public boolean hasNext() {
            return iteratorModCount < size;
        }

        @Override
        public T next() {
            if (modCount != iteratorModCount) {
                throw new ConcurrentModificationException("The Collection changed during the crawl");
            }

            if (!hasNext()) {
                throw new NoSuchElementException("There is no such element");
            }

            do {
                currentIndex = (currentIndex + 1) % table.length;
            } while (table[currentIndex] == null);

            iteratorModCount++;

            //noinspection unchecked
            return (T) table[iteratorModCount];
        }
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        if (collection.size() == 0) {
            return false;
        }

        int index = 0;
        int i = 0;

        for (; i < size; i++) {
            if (!collection.contains(table[i])) {
                table[index] = table[i];

                index++;
            }

        }

        if (index != size) {
            for (int j = index; j < size; j++) {
                table[j] = null;
            }

            modCount += size - index;
            size = index;

            return true;
        }

        return false;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        int index = 0;
        int i = 0;

        for (; i < size; i++) {
            if (collection.contains(table[i])) {
                table[index] = table[i];

                index++;
            }
        }

        if (index != size) {
            for (int j = index; j < size; j++) {
                table[j] = null;
            }

            modCount += size - index;
            size = index;

            return true;
        }

        return false;
    }


    @Override
    public Object[] toArray() {
        return Arrays.copyOf(table, size);
    }

    @SuppressWarnings("RedundantSuppression")
    @Override
    public <T1> T1[] toArray(T1[] array) {
        if (array.length < size) {
            //noinspection unchecked
            return (T1[]) Arrays.copyOf(table, size, array.getClass());
        }

        //noinspection SuspiciousSystemArraycopy
        System.arraycopy(table, 0, array, 0, size);

        if (array.length > size) {
            array[size] = null;
        }

        return array;
    }

    public String toString() {
        if (size == 0) {
            return "{}";
        }

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{");

        for (ArrayList<T> ts : table) {
            stringBuilder.append(ts).append(", ");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 2).setCharAt(stringBuilder.length() - 1, '}');

        return stringBuilder.toString();
    }
}