package ru.oopcourse.kaminskiy.binary_search_tree;

import java.util.LinkedList;
import java.util.Queue;

public class BinarySearchTree<T> {
    public BinarySearchTreeNode<T> root;

    public BinarySearchTree() {
        this.root = null;
    }

    public BinarySearchTree(BinarySearchTreeNode<T> root) {
        this.root = root;
    }

    public void toString(BinarySearchTreeNode<T> root) {

        if (root != null) {
            toString(root.getLeft());
            System.out.print(root.getData() + " ");
            toString(root.getRight());
        }
    }

    public int getCountsElements() {
        return getCountsElements(root);
    }

    private int getCountsElements(BinarySearchTreeNode<T> node) {
        if (node == null) {
            return 0;
        } else {
            int count = 1;

            count += getCountsElements(node.getLeft());
            count += getCountsElements(node.getRight());

            return count;
        }
    }

    public void insertNode(T value) {
        BinarySearchTreeNode<T> node = new BinarySearchTreeNode<>(value);

        if (root == null) {
            root = node;

            return;
        }

        BinarySearchTreeNode<T> current = root;
        BinarySearchTreeNode<T> parent;

        while (true) {
            parent = current;

            if ((int) current.getData() > (int) value) {
                current = current.getLeft();

                if (current == null) {
                    parent.setLeft(node);

                    return;
                }
            } else {
                current = current.getRight();

                if (current == null) {
                    parent.setRight(node);

                    return;
                }
            }
        }
    }

    public boolean findNode(T value) {
        if (root == null) {
            return false;
        }

        BinarySearchTreeNode<T> currentNode = root;

        while (currentNode != null) {
            if ((int) currentNode.getData() == (int) value) {
                return true;
            } else if ((int) currentNode.getData() > (int) value) {
                currentNode = currentNode.getLeft();
            } else {
                currentNode = currentNode.getRight();
            }
        }

        return false;
    }

    public boolean removeNode(int value) {
        if (root == null) {
            return false;
        }

        BinarySearchTreeNode<T> current = root;
        BinarySearchTreeNode<T> parent = root;

        boolean isLeft = false;

        while ((int) current.getData() != value) {
            parent = current;

            if ((int) current.getData() > value) {
                isLeft = true;
                current = current.getLeft();
            } else {
                isLeft = false;
                current = current.getRight();
            }

            if (current == null) {
                return false;
            }
        }

        if (current.getLeft() == null && current.getRight() == null) {
            if (current == root) {
                root = null;
            } else if (isLeft) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }

            return true;
        }

        if (current.getLeft() == null) {
            if (current == root) {
                root = current.getRight();
            } else if (isLeft) {
                parent.setLeft(current.getRight());
            } else {
                parent.setRight(current.getRight());
            }

            return true;
        }

        if (current.getRight() == null) {
            if (current == root) {
                root = current.getLeft();
            } else if (isLeft) {
                parent.setLeft(current.getLeft());
            } else {
                parent.setRight(current.getLeft());
            }

            return true;
        }

        if (current.getLeft() == null && current.getRight() == null) {
            BinarySearchTreeNode<T> successor = getSuccessor(current);
            successor.setLeft(current.getLeft());
            successor.setRight(current.getRight());

            if (current == root) {
                root = successor;
            } else if (isLeft) {
                parent.setLeft(successor);
            } else {
                parent.setRight(successor);
            }

            return true;
        }

        return false;

    }

    private BinarySearchTreeNode<T> getSuccessor(BinarySearchTreeNode<T> node) {
        BinarySearchTreeNode<T> parent = null;
        BinarySearchTreeNode<T> successor = null;
        BinarySearchTreeNode<T> current = node.getRight();

        while (current != null) {
            parent = successor;
            successor = current;
            current = current.getLeft();
        }

        if (successor != node.getRight()) {
            parent.setLeft(successor.getRight());
            successor.setRight(null);
        }

        return successor;
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

    public void traversalWithRecursion(BinarySearchTreeNode<T> node) {
        if (node == null) {
            return;
        }

        traversalWithRecursion(node.getLeft());
        traversalWithRecursion(node.getRight());
    }
}