package ru.oopcourse.kaminskiy.binary_search_tree;

import java.util.*;
import java.util.function.Consumer;

public class BinarySearchTree<T> {
    private BinarySearchTreeNode<T> root;
    private Comparator<T> comparator;
    private int count;

    public BinarySearchTree(T data) {
        root = new BinarySearchTreeNode<>(data);

        count++;
    }

    public BinarySearchTree() {
    }

    public BinarySearchTree(Comparator<T> comparator) {
        this.comparator = comparator;
    }

    private int compare(T data1, T data2) {
        if (comparator == null) {
            if (data1 == null && data2 == null) {
                return 0;
            }

            if (data1 == null) {
                return -1;
            }

            if (data2 == null) {
                return 1;
            }

            //noinspection unchecked
            return ((Comparable<T>) data1).compareTo(data2);
        }

        return comparator.compare(data1, data2);
    }

    public int getCount() {
        return count;
    }

    public void insertNode(T data) {
        BinarySearchTreeNode<T> node = new BinarySearchTreeNode<>(data);

        if (root == null) {
            root = node;

            count++;

            return;
        }

        BinarySearchTreeNode<T> currentNode = root;
        BinarySearchTreeNode<T> parentNode = null;

        while (currentNode != null) {
            parentNode = currentNode;

            if (compare(data, currentNode.getData()) < 0) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }

        if (compare(data, parentNode.getData()) < 0) {
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

        BinarySearchTreeNode<T> currentNode = root;

        while (currentNode != null) {
            if (compare(data, currentNode.getData()) == 0) {
                return true;
            }

            if (compare(data, currentNode.getData()) < 0) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }

        return false;
    }

    public boolean removeNode(T data) {
        if (root == null) {
            return false;
        }

        BinarySearchTreeNode<T> currentNode = root;
        BinarySearchTreeNode<T> parentNode = root;
        boolean isLeftChild = false;

        while (currentNode.getData() != data) {
            parentNode = currentNode;

            if (compare(data, currentNode.getData()) < 0) {
                isLeftChild = true;
                currentNode = currentNode.getLeft();
            } else {
                isLeftChild = false;
                currentNode = currentNode.getRight();
            }

            if (currentNode == null) {
                return false;
            }
        }

        if (currentNode.getLeft() == null && currentNode.getRight() == null) {
            if (currentNode == root) {
                root = null;
            }

            if (isLeftChild) {
                parentNode.setLeft(null);
            } else {
                parentNode.setRight(null);
            }

            return true;
        }

        if (currentNode.getLeft() == null) {
            if (currentNode == root) {
                root = currentNode.getRight();
            }

            if (isLeftChild) {
                parentNode.setLeft(currentNode.getRight());
            } else {
                parentNode.setRight(currentNode.getRight());
            }

            return true;
        }

        if (currentNode.getRight() == null) {
            if (currentNode == root) {
                root = currentNode.getLeft();
            }

            if (isLeftChild) {
                parentNode.setLeft(currentNode.getLeft());
            } else {
                parentNode.setRight(currentNode.getLeft());
            }

            return true;
        }

        if (currentNode.getLeft() != null && currentNode.getRight() != null) {
            BinarySearchTreeNode<T> currentNodeSuccessor = getSuccessor(currentNode);
            currentNodeSuccessor.setLeft(currentNode.getLeft());
            currentNodeSuccessor.setRight(currentNode.getRight());

            if (currentNode == root) {
                root = currentNodeSuccessor;
            }

            if (isLeftChild) {
                parentNode.setLeft(currentNodeSuccessor);
            } else {
                parentNode.setRight(currentNodeSuccessor);
            }

            return true;
        }

        return false;
    }

    private BinarySearchTreeNode<T> getSuccessor(BinarySearchTreeNode<T> node) {
        BinarySearchTreeNode<T> parentNode = node;
        boolean isRightChild = node.getLeft() == null;

        node = node.getRight();

        while (node.getLeft() != null) {
            parentNode = node;
            node = node.getLeft();
        }

        if (isRightChild) {
            parentNode.setRight(node.getRight());
        } else {
            parentNode.setLeft(node.getRight());
        }

        node.setRight(null);
        return node;
    }

    public void breadTraversal(Consumer<T> consumer) {
        Queue<BinarySearchTreeNode<T>> queue = new LinkedList<>();
        if (root == null) {
            return;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            BinarySearchTreeNode<T> node = queue.remove();
            consumer.accept(node.getData());

            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }

            if (node.getRight() != null) {
                queue.add(node.getRight());
            }
        }
    }

    public void traversalWithRecursion(Consumer<T> consumer) {
        traversalWithRecursion(root, consumer);
    }

    private void traversalWithRecursion(BinarySearchTreeNode<T> node, Consumer<T> consumer) {
        if (node == null) {
            return;
        }

        consumer.accept(node.getData());
        traversalWithRecursion(node.getLeft(), consumer);
        traversalWithRecursion(node.getRight(), consumer);
    }

    public void traversalWithoutRecursion(Consumer<T> consumer) {
        Stack<BinarySearchTreeNode<T>> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }

        while (!stack.isEmpty()) {
            BinarySearchTreeNode<T> node = stack.pop();
            consumer.accept(node.getData());

            if (node.getRight() != null) {
                stack.push(node.getRight());
            }

            if (node.getLeft() != null) {
                stack.push(node.getLeft());
            }
        }
    }

    private String preOrderTraversal() {
        StringBuilder stringBuilder = new StringBuilder("[");
        preOrderTraversal(stringBuilder, root);

        return stringBuilder.append("]").toString();
    }

    private void preOrderTraversal(StringBuilder stringBuilder, BinarySearchTreeNode<T> currentNode) {
        if (currentNode == null) {
            return;
        }

        if (stringBuilder.length() > 1) {
            stringBuilder.append(", ");
        }

        stringBuilder.append(currentNode.getData());
        preOrderTraversal(stringBuilder, currentNode.getLeft());
        preOrderTraversal(stringBuilder, currentNode.getRight());
    }

    @Override
    public String toString() {
        return preOrderTraversal();
    }
}