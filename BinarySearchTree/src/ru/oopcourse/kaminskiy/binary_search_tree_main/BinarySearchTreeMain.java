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

        System.out.println("binarySearchTree: " + binarySearchTree);

        System.out.println("search: " + binarySearchTree.findNode(66));

        System.out.println("count: " + binarySearchTree.getCount());

        System.out.println("removeNode: " + binarySearchTree.removeNode(21));
        System.out.println("binarySearchTree: " + binarySearchTree);

        System.out.println("toStringInorder: " + binarySearchTree.toStringInorder());

        System.out.println("toStringPostOrder: " + binarySearchTree.toStringPostOrder());

        System.out.println("toStringPreorder: " + binarySearchTree.toStringPreorder());

        System.out.println("toStringBreadthFirst: " + binarySearchTree.toStringBreadthFirst());
    }
}