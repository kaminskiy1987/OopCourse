package ru.oopcourse.kaminskiy.binary_search_tree;

public class BinarySearchTreeNode<T> {
    private BinarySearchTreeNode<T> left;
    private BinarySearchTreeNode<T> right;
    private T data;

    public BinarySearchTreeNode(T data) {
        this.data = data;
    }

    public BinarySearchTreeNode() {
    }

    public BinarySearchTreeNode<T> getLeft() {
        return left;
    }

    public void setLeft(BinarySearchTreeNode<T> left) {
        this.left = left;
    }

    public BinarySearchTreeNode<T> getRight() {
        return right;
    }

    public void setRight(BinarySearchTreeNode<T> right) {
        this.right = right;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}