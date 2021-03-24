package ru.oopcourse.kaminskiy.binary_search_tree;

import java.util.ArrayList;
import java.util.List;

public class BinarySearchTree<T extends Comparable<T>> {
    public BinarySearchTreeNode<T> root;
    public int count;

    public BinarySearchTree() {
    }

    public BinarySearchTree(T data) {
        root = new BinarySearchTreeNode<>(data);

        count++;
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

    public boolean removeNode(T data) {
        if (root == null) {
            return false;
        }

        BinarySearchTreeNode<T> parentNode = null;
        BinarySearchTreeNode<T> currentNode = root;

        while (currentNode != null) {
            if (data.compareTo(currentNode.getData()) < 0) {
                parentNode = currentNode;
                currentNode = currentNode.getLeft();
            } else if (data.compareTo(currentNode.getData()) > 0) {
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
                if (data.compareTo(parentNode.getData()) < 0) {
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

            if (currentNode.getRight().equals(currentNode.getLeft())) {
                currentNode.setRight(currentNode.getLeft().getLeft());
            } else {
                currentNode.setLeft(currentNode.getLeft().getLeft());
            }
        }

        --count;

        return true;
    }

    public String toStringInorder() {
        StringBuilder stringBuilder = new StringBuilder("[");
        toStringInorder(stringBuilder, root);

        return stringBuilder.append("]").toString();
    }

    private void toStringInorder(StringBuilder stringBuilder, BinarySearchTreeNode<T> currentNode) {
        if (currentNode == null) {
            return;
        }

        toStringInorder(stringBuilder, currentNode.getLeft());

        if (stringBuilder.length() > 1) {
            stringBuilder.append(", ");
        }

        stringBuilder.append(currentNode.getData());
        toStringInorder(stringBuilder, currentNode.getRight());
    }

    public String toStringPreorder() {
        StringBuilder stringBuilder = new StringBuilder("[");
        toStringPreorder(stringBuilder, root);

        return stringBuilder.append("]").toString();
    }

    private void toStringPreorder(StringBuilder stringBuilder, BinarySearchTreeNode<T> currentNode) {
        if (currentNode == null) {
            return;
        }

        if (stringBuilder.length() > 1) {
            stringBuilder.append(", ");
        }

        stringBuilder.append(currentNode.getData());
        toStringPreorder(stringBuilder, currentNode.getLeft());
        toStringPreorder(stringBuilder, currentNode.getRight());
    }

    public String toStringPostOrder() {
        StringBuilder stringBuilder = new StringBuilder("[");
        toStringPostOrder(stringBuilder, root);

        return stringBuilder.append("]").toString();
    }

    private void toStringPostOrder(StringBuilder stringBuilder, BinarySearchTreeNode<T> currentNode) {
        if (currentNode == null) {
            return;
        }

        toStringPostOrder(stringBuilder, currentNode.getLeft());
        toStringPostOrder(stringBuilder, currentNode.getRight());

        if (stringBuilder.length() > 1) {
            stringBuilder.append(", ");
        }

        stringBuilder.append(currentNode.getData());
    }

    public String toStringBreadthFirst() {
        StringBuilder stringBuilder = new StringBuilder("[");

        if (root != null) {
            List<BinarySearchTreeNode<T>> current = new ArrayList<>(1);
            current.add(root);
            toStringBreadthFirst(stringBuilder, current);
        }

        return stringBuilder.append("]").toString();
    }

    private void toStringBreadthFirst(StringBuilder stringBuilder, List<BinarySearchTreeNode<T>> current) {
        List<BinarySearchTreeNode<T>> next = new ArrayList<>();

        for (BinarySearchTreeNode<T> currentNode : current) {
            if (stringBuilder.length() > 1) {
                stringBuilder.append(", ");
            }

            stringBuilder.append(currentNode.getData());

            if (currentNode.getLeft() != null) {
                next.add(currentNode.getLeft());
            }

            if (currentNode.getRight() != null) {
                next.add(currentNode.getRight());
            }
        }

        if (!next.isEmpty()) {
            toStringBreadthFirst(stringBuilder, next);
        }
    }

    @Override
    public String toString() {
        return toStringInorder();
    }
}