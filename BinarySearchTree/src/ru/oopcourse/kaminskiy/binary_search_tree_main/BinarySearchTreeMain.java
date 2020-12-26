package ru.oopcourse.kaminskiy.binary_search_tree_main;

import ru.oopcourse.kaminskiy.binary_search_tree.BinarySearchTree;

public class BinarySearchTreeMain {
    @SuppressWarnings("unchecked")
    public static void main(String[] args) {
        BinarySearchTree binarySearchTree = new BinarySearchTree();

        binarySearchTree.insertNode(5);
        binarySearchTree.insertNode(4);
        binarySearchTree.insertNode(15);
        binarySearchTree.insertNode(65);
        binarySearchTree.insertNode(31);
        binarySearchTree.insertNode(9);
        binarySearchTree.insertNode(21);
        binarySearchTree.insertNode(1);

        //noinspection unchecked
        binarySearchTree.toString(binarySearchTree.root);
        System.out.println();

        System.out.println("search: " + binarySearchTree.findNode(66));
        System.out.println("count: " + binarySearchTree.getCountsElements());
        System.out.println("removeNode: " + binarySearchTree.removeNode(22));

        binarySearchTree.widthTraverse();
        binarySearchTree.toString(binarySearchTree.root);
        System.out.println();

        binarySearchTree.traversalWithRecursion(binarySearchTree.root);
        binarySearchTree.toString(binarySearchTree.root);
        System.out.println();
    }
}