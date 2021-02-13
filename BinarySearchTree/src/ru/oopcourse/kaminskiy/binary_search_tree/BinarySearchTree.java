package ru.oopcourse.kaminskiy.binary_search_tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T extends Comparable<T>> {
    public BinarySearchTreeNode<T> root;
    public int count;

    public BinarySearchTree() {
    }

    public BinarySearchTree(T data) {
        root = new BinarySearchTreeNode<>(data);
    }

    public void toString(BinarySearchTreeNode<T> root) {
        if (root != null) {
            toString(root.getLeft());
            System.out.print(root.getData() + " ");
            toString(root.getRight());
        }
    }

    public int getCount() {
        return count;
    }

    public void insertNode(T data) {
        BinarySearchTreeNode<T> node = new BinarySearchTreeNode<>(data);

        if (root == null) {
            root = node;
            return;
        }

        BinarySearchTreeNode<T> currentNode = root;
        BinarySearchTreeNode<T> parentNode = null;

        while (currentNode != null) {
            parentNode = currentNode;

            if (node.getData().compareTo(currentNode.getData()) < 0) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }

        if (node.getData().compareTo(parentNode.getData()) < 0) {
            parentNode.setLeft(node);
        } else {
            parentNode.setRight(node);
        }

        count++;
    }

    public boolean findNode(T data) {
        if (root == null) {
            return false;
        }

        BinarySearchTreeNode<T> node = new BinarySearchTreeNode<>(data);
        BinarySearchTreeNode<T> currentNode = root;

        while (currentNode != null) {
            if (currentNode.getData() == data) {
                return true;
            }

            if (node.getData().compareTo(currentNode.getData()) < 0) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }

        return false;
    }

    public void removeNode(T data) {
        root = removeNode(root, data);
    }

    public BinarySearchTreeNode<T> removeNode(BinarySearchTreeNode<T> root, T data) {
        if (root == null) {
            return null;
        } else if (data.compareTo(root.getData()) < 0) {
            root.setLeft(removeNode(root.getLeft(), data));
        } else if (data.compareTo(root.getData()) > 0) {
            root.setRight(removeNode(root.getRight(), data));
        } else {
            if (root.getLeft() == null) {
                return root.getRight();
            } else if (root.getRight() == null) {
                return root.getLeft();
            } else {
                root.setData(findMax(root.getLeft()));
                root.setLeft(removeNode(root.getLeft(), root.getData()));
            }
        }

        return root;
    }

    private T findMax(BinarySearchTreeNode<T> root) {
        while (root.getRight() != null) {
            root = root.getRight();
        }

        return root.getData();
    }

    public void widthTraverse() {
        Queue<BinarySearchTreeNode<T>> queue = new LinkedList<>();

        if (root != null) {
            queue.add(root);
        }

        while (!queue.isEmpty()) {
            BinarySearchTreeNode<T> node = queue.remove();

            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }

            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
    }

    public void traversalWithRecursion(BinarySearchTreeNode<T> root) {
        if (root == null) {
            return;
        }

        traversalWithRecursion(root.getLeft());
        traversalWithRecursion(root.getRight());
    }

    public void traversalWithoutRecursion() {
        BinarySearchTreeNode<T> node = root;
        BinarySearchTreeNode<T> previous = null;
        BinarySearchTreeNode<T> next;

        while (node != null) {
            if (previous == node.getData()) {
                if (node.getLeft() != null) {
                    next = node.getLeft();
                } else if (node.getRight() != null) {
                    next = node.getRight();
                } else {
                    next = new BinarySearchTreeNode<>(node.getData());
                }
            } else if (previous == node.getLeft()) {
                if (node.getRight() != null) {
                    next = node.getRight();
                } else {
                    next = new BinarySearchTreeNode<>(node.getData());
                }
            } else {
                next = new BinarySearchTreeNode<>(node.getData());
            }

            previous = node;
            node = next;
        }
    }
}