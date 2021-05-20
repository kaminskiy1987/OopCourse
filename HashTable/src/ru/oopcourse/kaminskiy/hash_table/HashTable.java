package ru.oopcourse.kaminskiy.hash_table;

import java.util.*;

public class HashTable<T> implements Collection<T> {
     private int size;
    private ArrayList<T>[] arrayLists;
    private int modCount;

    public HashTable(int arrayLength) {
        if (arrayLength <= 0) {
            throw new IllegalArgumentException("Illegal Capacity: " + arrayLength);
        }

        //noinspection unchecked
        arrayLists = new ArrayList[arrayLength];
    }

    public HashTable() {
        int DEFAULT_SIZE = 10;
        //noinspection unchecked
        arrayLists = new ArrayList[DEFAULT_SIZE];
    }

    private int indexOfArrayElement(Object object) {
        if (object == null) {
            object = new ArrayList<>();
        }

        return (Math.abs(object.hashCode())) % arrayLists.length;
    }

    @Override
    public boolean add(T item) {
        int index = indexOfArrayElement(item);

        if (arrayLists[index] == null) {
            arrayLists[index] = new ArrayList<>();
        }

        if (arrayLists[index].contains(item)) {
            return false;
        }

        arrayLists[index].add(item);

        size++;
        modCount++;

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

        boolean added = false;
        for (T element : collection) { //Add all elements from the collection.
            added |= add(element);
        }

        return added;
    }

    @Override
    public void clear() {
        //noinspection unchecked
        arrayLists = new ArrayList[size];

        modCount++;
        size = 0;
    }

    @Override
    public boolean contains(Object o) {
        int index = indexOfArrayElement(o);

        return arrayLists[index] != null && arrayLists[index].contains(o);
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
        int index = indexOfArrayElement(o);

        if (arrayLists[index] == null) {
            arrayLists[index] = new ArrayList<>();
        }

        return arrayLists[index].remove(o);
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

        private final int expectedModCount;

        private int index;

        private int last = -1;

        private iterator() {
            final Object[] objects = arrayLists;

            for (index = objects.length - 1; index >= 0 && (objects[index] == null); index--) ;
            expectedModCount = modCount;
        }

        @Override
        public boolean hasNext() {
            return index >= 0;
        }

        @Override
        @SuppressWarnings("unchecked")
        public T next() {
            if (modCount != expectedModCount) {
                throw new ConcurrentModificationException();
            }

            if (index < 0) {
                last = -1;

                throw new NoSuchElementException();
            }

            final Object[] objects = arrayLists;
            last = index;
            for (index--; index >= 0 && (objects[index] == null); index--) ;

            if (objects[last].equals(new ArrayList<>())) {
                return null;
            }
            return (T) objects[last];
        }
    }

    @Override
    public boolean removeAll(Collection<?> collection) {
        if (collection == null) {
            throw new NullPointerException("The specified collection to remove all elements from is null.");
        }
        if (collection.size() == 0) {
            return false;
        }

        boolean removed = false;

        for (Object o : this) {
            if (collection.contains(o)) {
                this.remove(o);
                removed = true;
            }
        }

        return removed;
    }

    @Override
    public boolean retainAll(Collection<?> collection) {
        if (collection == null) {
            throw new NullPointerException("The specified collection to remove all elements from is null.");
        }
        if (collection.size() == 0) {
            return false;
        }

        boolean removed = false;

        for (Object o : this) {
            if (!collection.contains(o)) {
                this.remove(o);
                removed = true;
            }
        }
        return removed;
    }

    @Override
    public Object[] toArray() {
        Object[] objects = new Object[arrayLists.length];
        int i = 0;
        for (T b : this) {
            objects[i] = b;

            i++;
        }

        return objects;
    }

    @SuppressWarnings("RedundantSuppression")
    @Override
    public <T1> T1[] toArray(T1[] array) {
        if (array.length < size) {
            //noinspection unchecked
            array = (T1[]) new Object[arrayLists.length];
        }

        int i = 0;
        for (T b : this) {
            //noinspection unchecked
            array[i] = (T1) b;

            i++;
        }

        return array;
    }

    public String toString() {
        if (size == 0) {
            return "{}";
        }

        if (arrayLists == null) {
            throw new NullPointerException("The Collection is null");
        }

        StringBuilder stringBuilder = new StringBuilder();

        stringBuilder.append("{");

        for (ArrayList<T> arrayList : arrayLists) {
            stringBuilder.append(arrayList).append(", ");
        }

        stringBuilder.deleteCharAt(stringBuilder.length() - 2).setCharAt(stringBuilder.length() - 1, '}');

        return stringBuilder.toString();
    }
    }
