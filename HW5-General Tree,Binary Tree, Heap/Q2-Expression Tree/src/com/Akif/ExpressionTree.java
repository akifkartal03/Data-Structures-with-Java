package com.Akif;

import java.util.Scanner;
import java.util.Stack;

/**
 * This class is to make arithmetic operations with given expression.
 * It extends from BinaryTree class therefore, it keep data as binary tree.
 */
public class ExpressionTree extends BinaryTree<String> {
    /**
     * A constructor to initialize the tree structure with the given expression string.
     * @param expression The expression to initialize.
     */
    public ExpressionTree(String expression){
        root=readBinaryTree (new Scanner (expression)).root;
    }

    /**
     * Overridden form of readBinaryTree method.
     * @param scan the Scanner attached to the input file.
     * @return The binary tree.
     */
    public static BinaryTree<String> readBinaryTree(Scanner scan) {
        String data = scan.nextLine ();
        if (isPrefix (data)){
            return createTree (new Scanner (data));
        }
        else{
            return createTree (postToPre (new Scanner (data)));
        }
    }

    /**
     * A helper recursive readBinary method to create binary tree.
     * @param scanner scan the Scanner attached to the input file.
     * @return The binary tree.
     */
    private static BinaryTree<String> createTree(Scanner scanner) {
        String data = scanner.next();
        if (!isOperator (data.charAt (0))) {
            return new BinaryTree<> (new Node<> (data));
        } else {
            BinaryTree<String> leftTree = createTree (scanner);
            BinaryTree<String> rightTree = createTree (scanner);
            return new BinaryTree<String>(data, leftTree,
                    rightTree);
        }
    }
    /**
     * This method evaluates the expression and returns the result as an integer.
     * @return evaluate result as integer.
     */
    public int eval(){
        return evalHelper (root);
    }

    /**
     * A recursive helper method to evaluate the expression tree.
     * @param tempRoot root of the tree.
     * @return evaluate result as integer.
     */
    private int evalHelper(Node<String> tempRoot) {
        if (tempRoot==null)
            return 0;
        //if root is an operand then return it.
        if (!isOperator (tempRoot.data.charAt (0))) {
            return Integer.parseInt (tempRoot.data);
        } else {
            int left = evalHelper (tempRoot.left); //get left side of arithmetic operation
            int right = evalHelper (tempRoot.right); // get right side of arithmetic operation
            return calculate (tempRoot.data,left,right); // make arithmetic operation and return result
        }
    }

    /**
     * This method makes arithmetic operation with given root node data,left side and right side.
     * @param node root node that keeps an operator
     * @param left left side of arithmetic operation
     * @param right right side of arithmetic operation
     * @return result of arithmetic operation.
     */
    private int calculate(String node,int left,int right){
        int res=0;
        if (isOperator (node.charAt (0))){ //if root is a operator
            switch (node) {
                case "*":
                    res =left*right;
                    break;
                case "/":
                    res =left/right;
                    break;
                case "+":
                    res =left+right;
                    break;
                case "-":
                    res =left-right;
                    break;
            }
        }
        return res;
    }

    /**
     * This method checks given expression whether it is prefix expression or not.
     * @param str expression will be checked.
     * @return true if expression is prefix
     */
    private static boolean isPrefix(String str){
        return isOperator (str.charAt (0)) || isOperator (str.charAt (2));
    }
    /***
     * This is a helper method to checks given character whether operator or not.
     * @param c a character will be checked
     * @return true if character is an operator
     */
    private static boolean isOperator(char c){
        String operators = "+-*/";
        return operators.indexOf(c) != -1;
    }
    /***
     * Returns string of the tree structure in postorder.
     * @return string of the tree structure in postorder.
     */
    public String toString2() {
        StringBuilder sb = new StringBuilder();
        postOrderTraverse(root,sb);
        return sb.toString();
    }
    /** Converts a subtree to a string.
     Performs a postorder traversal.
     @param node The local root
     @param sb The StringBuilder to save the output
     */
    private void postOrderTraverse(Node<String> node, StringBuilder sb) {
        if (node == null) {
            return;
        } else {
            postOrderTraverse(node.left,sb);//left
            postOrderTraverse(node.right,sb);//right
            sb.append(node.toString()); //root
            sb.append(" ");
        }
    }

    /**
     * A helper method that converts a postfix expression to a prefix expression.
     * While doing this it uses a Stack. Note that it is not about construct tree.
     * @param scan a postfix expression to convert.
     * @return A scanner that contains prefix expression
     */
    private static Scanner postToPre(Scanner scan){
        Stack<String> operandStack = new Stack<> ();
        while(scan.hasNext ()){
            String token = scan.next ();
            if (isOperator (token.charAt (0))){
                String right = operandStack.pop ();
                String left = operandStack.pop ();
                String stringBuilder = token + " " + left + " " + right + " " ;
                operandStack.push (stringBuilder);
            }
            else{
                operandStack.push (token);
            }
        }
        return new Scanner (operandStack.pop ());
    }
}
