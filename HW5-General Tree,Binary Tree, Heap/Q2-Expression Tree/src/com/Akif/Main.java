package com.Akif;

/**
 * Main Class is to test program.
 */
public class Main {
    /**
     * Main method of the program.
     * @param args Not used.
     */
    public static void main(String[] args) {
        ExpressionTree expTree = new ExpressionTree("+ 7 + / - 10 * 5 3 10 - 2 / 4 8");
        System.out.println ("preOrder Traverse: "+expTree.toString ());
        System.out.println ("postOrder Traverse: "+expTree.toString2 ());
        System.out.println ("Evaluation result 1: "+expTree.eval ());
        ExpressionTree expTree2 = new ExpressionTree("10 5 15 * + 20 +");
        System.out.println ("preOrder Traverse: "+expTree2.toString ());
        System.out.println ("postOrder Traverse: "+expTree2.toString2 ());
        System.out.println ("Evaluation result 2: "+expTree2.eval ());
    }

}
