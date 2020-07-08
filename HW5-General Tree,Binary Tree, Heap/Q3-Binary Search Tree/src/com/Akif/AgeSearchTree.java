package com.Akif;

/**
 * This is a binary search class where each element is AgeData.
 * It extends from BinarySearchTree Class.
 */
public class AgeSearchTree extends BinarySearchTree<AgeData> {
    /**
     * No parameter constructor initialize root to null.
     */
    public AgeSearchTree () {
        super ();
    }

    /**
     * One parameter constructor initialize root of tree.
     * @param root root of the tree.
     */
    protected AgeSearchTree (Node<AgeData> root) {
        super (root);
    }

    /**
     * Three parameter constructor initialize data of root, left tree of root and right tree of root.
     * @param data a data for root
     * @param leftTree left sub tree of root
     * @param rightTree right sub tree of root.
     */
    public AgeSearchTree (AgeData data, BinarySearchTree<AgeData> leftTree, BinarySearchTree<AgeData> rightTree) {
        super (data, leftTree, rightTree);
    }

    /**
     * Starter add method to add a AgeData object to the tree if it doesn't exist.
     * If it exists, the number of people field of the AgeData object in that node will be increased 1.
     * @param item The AgeData object being inserted.
     * @return true if the object is inserted.
     */
    @Override
    public boolean add (AgeData item) {
        root = add(root, item);
        return addReturn;
    }

    /**
     *  Recursive helper add method.
     * @param localRoot The local root of the subtree.
     * @param item The AgeData object to be inserted.
     * @return The new local root that now contains the inserted item.
     */
    private Node<AgeData> add(Node<AgeData> localRoot, AgeData item) {
        //most of the part here same with binary search tree.
        if (localRoot == null) {
            addReturn = true;
            return new Node<>(item);
        } else if (item.compareTo(localRoot.data) == 0) {
            addReturn = true;
            localRoot.data.incrementTotal ();
            return localRoot;
        } else if (item.compareTo(localRoot.data) < 0) {
            localRoot.left = add(localRoot.left, item);
            return localRoot;
        } else {
            localRoot.right = add(localRoot.right, item);
            return localRoot;
        }
    }

    /**
     * Starter remove method to remove a AgeData object from the tree if it has only 1 people at that age.
     * The number of people field of this node’s AgeData object is
     * greater than 1, it will decrease the number of people field 1.
     * @param target The AgeData object to be deleted.
     * @return The AgeData object which is removed or null if it doesn't exist.
     */
    @Override
    public AgeData delete (AgeData target) {
        root = delete(root, target);
        return deleteReturn;
    }
    /** Recursive helper remove method.
     * @param localRoot The root of the current subtree
     * @param item The AgeData object to be deleted.
     * @return The modified local root that does not contain removed AgeData object.
     */
    private Node<AgeData> delete(Node<AgeData> localRoot, AgeData item) {
        //most of the part here same with binary search tree.
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
            if (localRoot.data.getTotal ()>1){
                localRoot.data.decrementTotal ();
                return localRoot;
            }
            else{
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
    }
    /***
     * Returns a string representation of this tree.
     * To traverse this tree, it uses preOrder traverse method.
     * @return a string representation of this tree.
     */
    @Override
    public String toString () {
        StringBuilder sb = new StringBuilder ();
        traversePreOrder (root,sb);
        return sb.toString ();
    }

    /**
     * This method traverse all tree by using preOrder traverse algorithm.
     * While traversing, it saves data of elements to a StringBuilder.
     * @param tempRoot root of tree.
     * @param sb StringBuilder to save root data of nodes.
     */
    private void traversePreOrder(Node<AgeData> tempRoot,StringBuilder sb){
        if (tempRoot==null){
            sb.append ("null\n");
            return;
        }
        else{
            sb.append (tempRoot.data.getAge ()+" - "+tempRoot.data.getTotal ()+"\n"); //root
            traversePreOrder (tempRoot.left,sb); //left
            traversePreOrder (tempRoot.right,sb); //right
        }

    }

    /**
     * Returns the number of people younger than given age.
     * @param age any age grater than equal to zero.
     * @return number of people younger than given age.
     * @throws IllegalArgumentException if age less than zero.
     */
    public int youngerThan(int age){
        if (age<0)
            throw new IllegalArgumentException ();
        return youngerHelper (root,age);
    }

    /**
     * A recursive helper method to determine number of people younger than an age.
     * While doing this, This method traverse only the nodes needs to be traversed.
     * @param tempRoot root of tree
     * @param age any age grater than equal to zero.
     * @return number of people younger than given age.
     */
    private int youngerHelper(Node<AgeData> tempRoot,int age){
        if (tempRoot==null)
            return 0;
        else{
            if (tempRoot.data.getAge ()==age){ // just traverse left side
                return getTotalAge (tempRoot.left); //get number of people at left side of tree.
            }
            else if(tempRoot.data.getAge ()<age)// get number of people at root and left side and check for right side
                //right side can have younger ages.
                return getTotalAge (tempRoot.left)+tempRoot.data.getTotal () + youngerHelper (tempRoot.right,age);
            else //root.age > age
               return youngerHelper (tempRoot.left,age); //check left side of tree
        }
    }

    /**
     * This method calculates number of people in given subtree.
     * @param tempRoot root of subtree.
     * @return number of people in given subtree.
     */
    private int getTotalAge(Node<AgeData> tempRoot){
        if (tempRoot==null)
            return 0;
        else{
            //root-left-right
            return tempRoot.data.getTotal() + getTotalAge (tempRoot.left)+getTotalAge (tempRoot.right);
        }
    }
    /**
     * Returns the number of people older than given age.
     * @param age any age grater than equal to zero.
     * @return number of people older than given age.
     * @throws IllegalArgumentException if age less than zero.
     */
    public int olderThan(int age){
        if (age<0)
            throw new IllegalArgumentException ();
        return olderHelper (root,age);
    }
    /**
     * A recursive helper method to determine number of people older than an age.
     * While doing this, This method traverse only the nodes needs to be traversed.
     * @param tempRoot root of tree
     * @param age any age grater than equal to zero.
     * @return number of people older than given age.
     */
    private int olderHelper(Node<AgeData> tempRoot,int age){
        if (tempRoot==null)
            return 0;
        else{
            if (tempRoot.data.getAge ()==age){ // just traverse right side
                return getTotalAge (tempRoot.right); //get number of people at right side of tree.
            }
            else if(tempRoot.data.getAge ()>age)// get number of people at root and right side and check for left side
                //left side can have older ages.
                return getTotalAge (tempRoot.right)+tempRoot.data.getTotal () + olderHelper (tempRoot.left,age);
            else //root.age < age
                return olderHelper (tempRoot.right,age); //check right side of tree
        }
    }
}
