package ru.oopcourse.kaminskiy.binary_search_tree;

import java.util.Comparator;

public class BinarySearchTreeComparator<T> implements Comparator<Integer> {
    @Override
    public int compare(Integer o1, Integer o2) {
        return o1.compareTo(o2);
    }
}
