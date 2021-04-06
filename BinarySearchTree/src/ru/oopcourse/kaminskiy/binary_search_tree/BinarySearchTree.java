package ru.oopcourse.kaminskiy.binary_search_tree;

import java.util.*;
import java.util.function.Consumer;

public class BinarySearchTree<T> {
    public BinarySearchTreeNode<T> root;
    private Comparator<T> comparator;
    public int count;

    public BinarySearchTree(T data) {
        root = new BinarySearchTreeNode<>(data);

        count++;
    }

    public BinarySearchTree(Comparator<T> comparator) {
        this.comparator = comparator;
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

            if (comparator.compare(data, currentNode.getData()) < 0) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }

        if (comparator.compare(data, parentNode.getData()) < 0) {
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
            if (Objects.equals(data, currentNode.getData())) {
                return true;
            }

            if (comparator.compare(data, currentNode.getData()) < 0) {
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

        BinarySearchTreeNode<T> parentNode = null;
        BinarySearchTreeNode<T> currentNode = root;

        while (currentNode != null) {
            if (comparator.compare(data, currentNode.getData()) < 0) {
                parentNode = currentNode;
                currentNode = currentNode.getLeft();
            } else if (comparator.compare(data, currentNode.getData()) > 0) {
                parentNode = currentNode;
                currentNode = currentNode.getRight();
            } else {
                break;
            }
        }

        if (currentNode == null) {
            return false;
        }

        if (currentNode.getLeft() == null) {
            if (parentNode == null) {
                root = currentNode.getRight();
            } else {
                if (comparator.compare(data, parentNode.getData()) < 0) {
                    parentNode.setLeft(currentNode.getRight());
                } else {
                    parentNode.setRight(currentNode.getRight());
                }
            }
        } else {
            while (currentNode.getLeft().getRight() != null) {
                currentNode = currentNode.getLeft();
                currentNode.setLeft(currentNode.getLeft().getRight());
            }

            currentNode.setData(currentNode.getLeft().getData());

            if (Objects.equals(currentNode.getRight(), currentNode.getLeft())) {
                currentNode.setRight(currentNode.getLeft().getLeft());
            } else {
                currentNode.setLeft(currentNode.getLeft().getLeft());
            }
        }

        --count;

        return true;
    }

    public void breadTraversal(Consumer<T> consumer) {
        Queue<BinarySearchTreeNode<T>> queue = new LinkedList<>();
        if (root == null) {
            return;
        }

        queue.add(root);

        while (!queue.isEmpty()) {
            int level = queue.size();

            if (count < level) {
                count = level;
            }

            BinarySearchTreeNode<T> node = queue.remove();
            consumer.accept(node.getData());

            if (node.getLeft() != null) {
                queue.add(node.getLeft());
            }

            if (node.getRight() != null) {
                queue.add(node.getRight());
            }

            count--;
        }
    }

    public void traversalWithRecursion(Consumer<T> consumer) {
        traversalWithRecursion(root, consumer);
    }

    private void traversalWithRecursion(BinarySearchTreeNode<T> node, Consumer<T> consumer) {
        if (node == null) {
            return;
        }

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

    public String traversal() {
        StringBuilder stringBuilder = new StringBuilder("[");
        traversal(stringBuilder, root);

        return stringBuilder.append("]").toString();
    }

    private void traversal(StringBuilder stringBuilder, BinarySearchTreeNode<T> currentNode) {
        if (currentNode == null) {
            return;
        }

        traversal(stringBuilder, currentNode.getLeft());

        if (stringBuilder.length() > 1) {
            stringBuilder.append(", ");
        }

        stringBuilder.append(currentNode.getData());
        traversal(stringBuilder, currentNode.getRight());
    }

    @Override
    public String toString() {
        return traversal();
    }
}