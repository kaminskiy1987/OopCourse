package ru.oopcourse.kaminskiy.binary_search_tree_main;

import ru.oopcourse.kaminskiy.binary_search_tree.BinarySearchTree;

public class BinarySearchTreeMain {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        binarySearchTree.insertNode(18);
        binarySearchTree.insertNode(10);
        binarySearchTree.insertNode(4);
        binarySearchTree.insertNode(14);
        binarySearchTree.insertNode(12);
        binarySearchTree.insertNode(16);
        binarySearchTree.insertNode(13);

        System.out.println("binarySearchTree: " + binarySearchTree);

        System.out.println("search: " + binarySearchTree.findNode(66));

        System.out.println("count: " + binarySearchTree.getCount());

        System.out.println("removeNode: " + binarySearchTree.removeNode(10));
        System.out.println("binarySearchTree: " + binarySearchTree);

        binarySearchTree.breadTraversal(System.out::println);
        System.out.println("breadTraversal: " + binarySearchTree);

        binarySearchTree.traversalWithRecursion(System.out::println);
        System.out.println("traversalWithRecursion: " + binarySearchTree);

        binarySearchTree.traversalWithoutRecursion(System.out::println);
        System.out.println("traversalWithoutRecursion: " + binarySearchTree);
    }
}