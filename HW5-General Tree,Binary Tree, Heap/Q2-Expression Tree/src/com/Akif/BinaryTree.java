package com.Akif;

import java.io.Serializable;
import java.util.Scanner;
/**
 * Class for a binary tree that stores type E objects.
 * Most of parts of this class are took from book.
 * @param <E> Type of tree.
 */
public class BinaryTree<E> implements Serializable {
    /**
     * The root of the binary tree
     */
    protected Node<E> root;

    /**
     * No parameter constructor initialize root to null.
     */
    public BinaryTree() {
        root = null;
    }
    /**
     * One parameter constructor initialize root of tree.
     * @param root root of the tree.
     */
    protected BinaryTree(Node<E> root) {
        this.root = root;
    }
    /** Constructs a new binary tree with data in its root leftTree
     * as its left subtree and rightTree as its right subtree.
     * @param data a data for root
     * @param leftTree left sub tree of root
     * @param rightTree right sub tree of root.
     */
    public BinaryTree(E data, BinaryTree<E> leftTree,
                      BinaryTree<E> rightTree) {
        root = new Node<>(data);
        if (leftTree != null) {
            root.left = leftTree.root;
        } else {
            root.left = null;
        }
        if (rightTree != null) {
            root.right = rightTree.root;
        } else {
            root.right = null;
        }
    }
    /** Return the left subtree.
     @return The left subtree or null if either the root or
     the left subtree is null
     */
    public BinaryTree<E> getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BinaryTree<>(root.left);
        } else {
            return null;
        }
    }
    /** Return the right subtree.
     @return The right subtree or null if either the root or
     the right subtree is null.
     */
    public BinaryTree<E> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BinaryTree<>(root.right);
        } else {
            return null;
        }
    }
    /** Determine whether this tree is a leaf.
     @return true if the root has no children
     */
    public boolean isLeaf() {
        return (root.left == null && root.right == null);
    }

    /***
     * Returns string of the tree structure in preorder.
     * @return string of the tree structure in preorder.
     */
    public String toString() {
        StringBuilder sb = new StringBuilder();
        preOrderTraverse(root, sb);
        return sb.toString();
    }
    /** Converts a subtree to a string.
     Performs a preorder traversal.
     @param node The local root
     @param sb The StringBuilder to save the output
     */
    private void preOrderTraverse(Node<E> node, StringBuilder sb) {
        if (node == null) {
            return;
        } else {
            sb.append(node.toString()); //root
            sb.append(" ");
            preOrderTraverse(node.left,sb); //left
            preOrderTraverse(node.right, sb); //right
        }
    }
    /** Method to read a binary tree.
     pre: The input consists of a preorder traversal
     of the binary tree. The line "null" indicates a null tree.
     @param scan the Scanner attached to the input file.
     @return The binary tree
     */
    public static BinaryTree<String> readBinaryTree (Scanner scan) {
        String data = scan.next();
        if (data.equals("null")) {
            return null;
        } else {
            BinaryTree<String> leftTree = readBinaryTree(scan);
            BinaryTree<String> rightTree = readBinaryTree(scan);
            return new BinaryTree<String>(data, leftTree, rightTree);
        }
    }
    /** Class to encapsulate a tree node. */
    protected static class Node<E> implements Serializable {
        /**
         * The information stored in this node.
         */
        protected E data;
        /**
         * Reference to the left child.
         */
        protected Node<E> left;
        /**
         * Reference to the right child.
         */
        protected Node<E> right;
        /**
         * Construct a node with given data and no children.
         * @param data The data to store in this node
         */
        public Node (E data) {
            this.data = data;
            left = null;
            right = null;
        }
        /** Return a string representation of the node.
         @return A string representation of the data fields
         */
        public String toString () {
            return data.toString();
        }

    }
}