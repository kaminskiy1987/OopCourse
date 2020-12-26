package ru.oopcourse.kaminskiy.binary_search_tree;

public class BinarySearchTreeNode<T> {
    private BinarySearchTreeNode<T> left;
    private BinarySearchTreeNode<T> right;
    private T data;

    public BinarySearchTreeNode(T data) {
        this.data = data;
        left = null;
        right = null;
    }

    public BinarySearchTreeNode() {
        this.data = null;
        left = null;
        right = null;
    }

    public void setLeft(BinarySearchTreeNode<T> left) {
        this.left = left;
    }

    public void setRight(BinarySearchTreeNode<T> right) {
        this.right = right;
    }

    public void setData(T data) {
        this.data = data;
    }

    public BinarySearchTreeNode<T> getLeft() {
        return left;
    }

    public BinarySearchTreeNode<T> getRight() {
        return right;
    }

    public T getData() {
        return data;
    }
}