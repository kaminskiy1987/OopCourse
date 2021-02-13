package ru.oopcourse.kaminskiy.binary_search_tree_main;

import ru.oopcourse.kaminskiy.binary_search_tree.BinarySearchTree;

public class BinarySearchTreeMain {
    public static void main(String[] args) {
        BinarySearchTree<Integer> binarySearchTree = new BinarySearchTree<>();

        binarySearchTree.insertNode(5);
        binarySearchTree.insertNode(4);
        binarySearchTree.insertNode(15);
        binarySearchTree.insertNode(65);
        binarySearchTree.insertNode(31);
        binarySearchTree.insertNode(9);
        binarySearchTree.insertNode(21);
        binarySearchTree.insertNode(1);

        binarySearchTree.toString(binarySearchTree.root);
        System.out.println();

        System.out.println("search: " + binarySearchTree.findNode(66));

        System.out.println("count: " + binarySearchTree.getCount());

        binarySearchTree.removeNode(22);
        binarySearchTree.toString(binarySearchTree.root);
        System.out.println();

        binarySearchTree.widthTraverse();
        binarySearchTree.toString(binarySearchTree.root);
        System.out.println();

        binarySearchTree.traversalWithoutRecursion();
        binarySearchTree.toString(binarySearchTree.root);
        System.out.println();

        binarySearchTree.traversalWithRecursion(binarySearchTree.root);
        binarySearchTree.toString(binarySearchTree.root);
        System.out.println();
    }
}