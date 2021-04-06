package ru.oopcourse.kaminskiy.binary_search_tree_main;

import ru.oopcourse.kaminskiy.binary_search_tree.BinarySearchTree;
import ru.oopcourse.kaminskiy.binary_search_tree.BinarySearchTreeComparator;

public class BinarySearchTreeMain {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>(new BinarySearchTreeComparator());

        binarySearchTree.insertNode(5);
        binarySearchTree.insertNode(4);
        binarySearchTree.insertNode(15);
        binarySearchTree.insertNode(65);
        binarySearchTree.insertNode(31);
        binarySearchTree.insertNode(9);
        binarySearchTree.insertNode(21);
        binarySearchTree.insertNode(1);

        System.out.println("binarySearchTree: " + binarySearchTree);

        System.out.println("search: " + binarySearchTree.findNode(66));

        System.out.println("count: " + binarySearchTree.getCount());

        System.out.println("removeNode: " + binarySearchTree.removeNode(21));
        System.out.println("binarySearchTree: " + binarySearchTree);

        binarySearchTree.breadTraversal(System.out::println);
        System.out.println("breadTraversal: " + binarySearchTree);

        binarySearchTree.traversalWithRecursion(System.out::println);
        System.out.println("traversalWithRecursion: " + binarySearchTree);

        binarySearchTree.traversalWithoutRecursion(System.out::println);
        System.out.println("traversalWithoutRecursion: " + binarySearchTree);

    }
}