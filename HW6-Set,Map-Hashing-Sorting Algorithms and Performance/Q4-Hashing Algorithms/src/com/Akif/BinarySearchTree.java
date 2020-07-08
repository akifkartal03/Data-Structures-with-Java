package com.Akif;

import java.util.Iterator;
import java.util.Stack;

/***
 * A complete Binary Search Tree Class.
 * Some part of it are taken from book.
 * New features added such as iterable by me.
 * @param <E> Type of tree.
 */
public class BinarySearchTree<E extends Comparable<E>> extends BinaryTree<E> implements SearchTree<E>, Iterator<E> {
    // Data Fields
    /** Return value from the public add method. */
    protected boolean addReturn;
    /** Return value from the public delete method. */
    protected E deleteReturn;
    /**
     * A stack to implement iterator for a binary tree.
     */
    private Stack<Node<E>> stack;
    /**
     * A tempRoot node to implement next method of iterator.
     */
    private Node<E> current;
    /**
     * No parameter constructor initialize root to null and other fields.
     */
    public BinarySearchTree() {
        root = null;
        current=null;
        stack = new Stack<> ();
    }
    /**
     * One parameter constructor initialize root of tree and other fields.
     * @param root root of the tree.
     */
    protected BinarySearchTree(Node<E> root) {
        this.root = root;
        current=this.root;
        stack = new Stack<> ();
    }
    /** Constructs a new binary search tree with data in its root leftTree
     * as its left subtree and rightTree as its right subtreeand other fields.
     * @param data a data for root
     * @param leftTree left sub tree of root
     * @param rightTree right sub tree of root.
     */
    public BinarySearchTree(E data, BinarySearchTree<E> leftTree,
                            BinarySearchTree<E> rightTree) {
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
        current=this.root;
        stack = new Stack<> ();
    }
    /** Return the left subtree.
     @return The left subtree or null if either the root or
     the left subtree is null
     */
    public BinarySearchTree<E> getLeftSubtree() {
        if (root != null && root.left != null) {
            return new BinarySearchTree<>(root.left);
        } else {
            return null;
        }
    }
    /** Return the right subtree.
     @return The right subtree or null if either the root or
     the right subtree is null
     */
    public BinarySearchTree<E> getRightSubtree() {
        if (root != null && root.right != null) {
            return new BinarySearchTree<>(root.right);
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

    /**
     * Returns data of root.
     * @return data of root.
     */
    public E getData(){
        return root.data;
    }
    /** Starter method find.
     pre: The target object must implement
     the Comparable interface.
     @param target The Comparable object being sought
     @return The object, if found, otherwise null
     */
    public E find(E target) {
        return find(root, target);
    }
    /** Recursive find method.
     @param localRoot The local subtree's root
     @param target The object being sought
     @return The object, if found, otherwise null
     */
    private E find(Node<E> localRoot, E target) {
        if (localRoot == null)
            return null;
        int compResult = target.compareTo(localRoot.data);
        if (compResult == 0)
            return localRoot.data;
        else if (compResult < 0)
            return find(localRoot.left, target);
        else
            return find(localRoot.right, target);
    }
    /** Starter method add.
     pre: The object to insert must implement the
     Comparable interface.
     @param item The object being inserted
     @return true if the object is inserted, false
     if the object already exists in the tree
     */
    public boolean add(E item) {
        root = add(root, item);
        current=this.root;
        return addReturn;
    }

    /**
     * Returns true if target is found in the tree.
     * @param target element will be searched.
     * @return true if target is found
     */
    @Override
    public boolean contains (E target) {
        return find (target) != null;
    }

    /** Recursive add method.
     post: The data field addReturn is set true if the item is added to
     the tree, false if the item is already in the tree.
     @param localRoot The local root of the subtree
     @param item The object to be inserted
     @return The new local root that now contains the
     inserted item
     */
    private Node<E> add(Node<E> localRoot, E item) {
        if (localRoot == null) {
            addReturn = true;
            return new Node<>(item);
        } else if (item.compareTo(localRoot.data) == 0) {
            addReturn = false;
            return localRoot;
        } else if (item.compareTo(localRoot.data) < 0) {
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        } else {
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }
    /** Starter method delete.
     post: The object is not in the tree.
     @param target The object to be deleted
     @return The object deleted from the tree
     or null if the object was not in the tree
     @throws ClassCastException if target does not implement
     Comparable
     */
    public E delete(E target) {
        root = delete(root, target);
        current=this.root;
        return deleteReturn;
    }

    /**
     * Removes target (if found) from tree and returns true; otherwise, returns false.
     * @param target element will be removed.
     * @return if found returns true; otherwise, returns false.
     */
    @Override
    public boolean remove (E target) {
        return delete (target) != null;
    }

    /** Recursive delete method.
     post: The item is not in the tree;
     deleteReturn is equal to the deleted item
     as it was stored in the tree or null
     if the item was not found.
     @param localRoot The root of the current subtree
     @param item The item to be deleted
     @return The modified local root that does not contain
     the item
     */
    private Node<E> delete(Node<E> localRoot, E item) {
        if (localRoot == null) {
            deleteReturn = null;
            return localRoot;
        }
        // Search for item to delete.
        int compResult = item.compareTo(localRoot.data);
        if (compResult < 0) {
        // item is smaller than localRoot.data.
            localRoot.left = delete(localRoot.left, item);
            return localRoot;
        } else if (compResult > 0) {
            // item is larger than localRoot.data.
            localRoot.right = delete(localRoot.right, item);
            return localRoot;
        } else {
            // item is at local root.
            deleteReturn = localRoot.data;
            if (localRoot.left == null) {
                    // If there is no left child, return right child
                // which can also be null.
                return localRoot.right;
            } else if (localRoot.right == null) {
                // If there is no right child, return left child.
                return localRoot.left;
            } else {
                // Node being deleted has 2 children, replace the data
                // with inorder predecessor.
                if (localRoot.left.right == null) {
                // The left child has no right child.
                    // Replace the data with the data in the
                    // left child.
                    localRoot.data = localRoot.left.data;
                        // Replace the left child with its left child.
                    localRoot.left = localRoot.left.left;
                    return localRoot;
                } else {
                    // Search for the inorder predecessor (ip) and
                    // replace deleted node's data with ip.
                    localRoot.data = findLargestChild(localRoot.left);
                    return localRoot;
                }
            }
        }
    }
    /** Find the node that is the
     inorder predecessor and replace it
     with its left child (if any).
     post: The inorder predecessor is removed from the tree.
     @param parent The parent of possible inorder
     predecessor (ip)
     @return The data in the ip
     */
    protected E findLargestChild(Node<E> parent) {
            // If the right child has no right child, it is
            // the inorder predecessor.
        if (parent.right.right == null) {
            E returnValue = parent.right.data;
            parent.right = parent.right.left;
            return returnValue;
        } else {
            return findLargestChild(parent.right);
        }
    }

    /**
     * Return size of tree.
     * It traverse tree inorder traverse.
     * @return size of tree
     */
    public int size()
    {
        return size(root);
    }

    /**
     * A recursive helper method to find size of tree.
     * Computes number of nodes in tree.
     * @param node root of tree.
     * @return size of tree.
     */
    private int size(Node<E> node)
    {
        if (node == null)
            return 0;
        else
            return(size(node.left) + 1 + size(node.right));
    }

    /**
     * Returns true if the iteration has more elements.
     * @return true if the iteration has more elements
     */
    @Override
    public boolean hasNext () {
        return (!stack.isEmpty() || current != null);
    }

    /**
     * Returns the next element in the iteration.
     * @return the next element in the iteration
     */
    @Override
    public E next () {
        while (current != null) {
            stack.push(current);
            current = current.left;
        }

        current = stack.pop();
        Node<E> node = current;
        current = current.right;

        return node.data;
    }
}
