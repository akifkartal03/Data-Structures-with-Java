package com.Akif;

import java.util.*;
/***
 * This class contains 6 recursive method(and helpers) and 1 main method to test them.
 */
public class Main {
    /***
     * This method reverse a string recursively. For example, if the input is this function writes the sentence in
     * reverse, then the output should be reverse in sentence the writes function this.
     * @param str a string that will be returned reverse version.
     * @return reverse version of given string
     */
    public static String reverseString(String str){
        if (str == null || str.equals(""))
            return "";
        if (!str.contains (" "))
            return str+" ";
        else {
            return reverseString(str.substring(str.indexOf (" ")+1)) + str.substring (0,str.indexOf (" ")+1);
        }
    }

    /***
     * This method determines whether a word is elfish or not. A word is considered elfish if it contains
     * the letters: e, l, and f in it, in any order.
     * @param word a string will be checked
     * @return true if it is elfish otherwise false;
     */
    public static boolean isElfish(String word){
        return checkElfish (word,false,false,false);
    }

    /***
     * A helper recursive method to find elfish word.
     * This method is to abstract the implementation from customer
     * @param word a string will be checked.
     * @param e keeps whether word contains e or not.
     * @param l keeps whether word contains l or not.
     * @param f keeps whether word contains f or not.
     * @return true if word contains e,l and f letters.
     */
    private static boolean checkElfish(String word,boolean e,boolean l,boolean f){
        if (word == null || word.equals(""))
            return l && f && e;
        else {
            if (word.charAt (0) == 'l'){
                l=true;
            }
            if (word.charAt (0) == 'e'){
                e=true;
            }
            if (word.charAt (0) == 'f')  {
                f=true;
            }
          return checkElfish (word.substring (1),e,l,f);
        }
    }
    /***
     * This method sorts an array recursively by using selection sort algorithm.
     * It uses a helper method to Abstract implementation from user.
     * @param arr array will be sorted.
     */
    public static void sortArrayBySelectionSort(int[] arr){
        sortArrayHelper(arr,1,0,0);
    }
    /***
     * This helper method sorts an array recursively by using selection sort algorithm.
     * It is used to Abstract implementation from user.
     * @param arr array will be sorted.
     * @param postFirst index of inner iterator in selection sort algorithm(1)
     * @param postSecond index of outer iterator in selection sort algorithm(0)
     * @param min a value that will be used while sorting.
     */
    private static void sortArrayHelper(int[] arr,int postFirst,int postSecond,int min){
        if (postSecond==arr.length-1){ //if all elements traversed.
            return;
        }
        if (postFirst ==arr.length){ // if an element traversed on all array do swapping and call function again
            //do swapping
            int temp = arr[min];
            arr[min] = arr[postSecond];
            arr[postSecond] = temp;
            postSecond+=1; //increment index
            postFirst=postSecond+1; //increment index
            min=postSecond; //update min value
            sortArrayHelper (arr,postFirst,postSecond,min); //call again
        }
        else {
            //check elements
            if (arr[postFirst]< arr[min]){
                min=postFirst; //update min value
            }
            sortArrayHelper (arr,postFirst+=1,postSecond,min);//call again
        }
    }

    /***
     * This method evaluates a prefix expression and returns result.
     * It reverses the string and uses evPostfix method to evaluate the expression.
     * @param prefix a prefix expression that is separated with spaces.
     * @param list a stack to keep elements
     * @return result of expression
     * @see #evPostfix(String, LinkedList)  
     */
    public static double evPrefix(String prefix,LinkedList<Integer> list){
        return evPostfix (reverseString (prefix),list); //use postfix method after reversing
    }

    /***
     * This method evaluates a prefix expression and returns result.
     * @param postfix a postfix expression that is separated with spaces.
     * @param list a stack to keep elements
     * @return result of expression
     */
    public static double evPostfix(String postfix,LinkedList<Integer> list){
        String value;
        char token;
        if (postfix == null || postfix.equals("")){ //if string is done stop
            return list.pop ();
        }
        if (!postfix.contains (" ")){ //if there is just one token
            value = postfix;
            postfix=""; //make empty string to stop
        }
        else
            //split string from space and evaluate token
            value = postfix.substring (0,postfix.indexOf (" "));
        token = value.charAt (0);
        if (Character.isDigit (token)){ //if it is digit push it list
            list.push (Integer.parseInt (value));
        }
        else if (isOperator (token)){ //if it is operator evaluate it.
            int rhs = list.pop();
            int lhs = list.pop();
            int result =0;
            switch (token) {
                case '+' :
                    result = lhs + rhs;
                    break;
                case '-' :
                    result = lhs - rhs;
                    break;
                case '/' :
                    result = lhs / rhs;
                    break;
                case '*' :
                    result = lhs * rhs;
                    break;
            }
            list.push (result);
        }
        return evPostfix (postfix.substring(postfix.indexOf (" ")+1),list); //call again
    }
    /***
     * This is a helper method to evaluate post and pre expression
     * @param c a character will be checked
     * @return true if it is an operator
     */
    private static boolean isOperator(char c){
        String operators = "+-*/";
        return operators.indexOf(c) != -1;
    }

    /***
     * This method prints 2D array on the screen in spiral format recursively.
     * To do this it uses a helper recursive method to Abstract implementation from user.
     * @param array 2D array will be printed.
     */
    public static void printArraySpiral(int[][] array){
        //we have 4 direction these are right,down,left,up;
        //directions numbers: right:1 , down: 2, left: 3, up:4
        //start with right
        int direction = 1;
        //start from [0][0]
        int x =0;
        int y =0;
        //set up boundaries
        int rowMin=0, rowMax =array.length-1, colMin = 0, colMax=array[0].length-1;
        //size start with 0 until all array is done
        int size=0;
        helperPrint (array,x,y,size,rowMin,rowMax,colMin,colMax,direction);
    }

    /***
     * A recursive helper method to print 2D array on the screen in spiral format recursively.
     * It is used to Abstract implementation from user.
     * @param arr 2D array will be printed
     * @param x current x coordinate of array.
     * @param y current y coordinate of array.
     * @param size a size starts from 0 until array size to stop recursion.
     * @param rowMin Minimum number of row in array(0)
     * @param rowMax Maximum number of row in array(row size)
     * @param colMin Minimum number of column in array(0)
     * @param colMax Maximum number of column in array(column size)
     * @param direction a direction when printing array.
     */
    private static void helperPrint(int[][] arr,int x,int y,int size,int rowMin,int rowMax ,int colMin,int colMax,int direction){
        if (size == arr.length*arr[0].length) //stop recursion
            return;
        System.out.print(arr[x][y] +" "); //print current cell with a space
        size++; //increment size
        boolean flag=false; //define a checker(it used to not damage adjusted values).
        //set up index values according to current situation and call function again
        if (direction == 1) { //right
            if (y == colMax) {
                direction = 2; //update to down
                rowMin++;
                x++;
                flag=true; //don't damage adjusted values
            } else {
                y++;
            }
        }

        if (direction == 2 && !flag) { //down
            if (x == rowMax) {
                direction = 3; //update to left
                colMax--;
                y--;
                flag=true; //don't damage adjusted values
            } else {
                x++;
            }
        }

        if (direction == 3 && !flag) { //left
            if (y == colMin) {
                direction = 4; //update to up
                rowMax--;
                x--;
                flag=true; //don't damage adjusted values
            } else {
                y--;
            }
        }

        if (direction == 4 && !flag) { //up
            if (x == rowMin) {
                direction = 1; //update to right
                colMin++;
                y++;
            } else {
                x--;
            }
        }
        helperPrint (arr, x, y, size, rowMin, rowMax, colMin, colMax, direction);
    }
    /***
     * Main method of the program to test each recursive method
     * @param args Not used.
     */
    public static void main(String[] args) {
        //everything is clear here without extra comments.
        //to see more clear each test, I separated them with '------------'
        for (int i = 0 ; i<100;i++) System.out.print("-");
        //----------------------------------------------------------------
        System.out.println ("\nTest 1th method with 'this function writes the sentence in reverse' sentence.");
	    System.out.println ("Result: "+reverseString ("this function writes the sentence in reverse"));
        for (int i = 0 ; i<100;i++) System.out.print("-");
        //----------------------------------------------------------------
        System.out.println ("\nTest 2th method with 'whiteleaf' word.");
	    System.out.println ("Result: "+isElfish ("whiteleaf"));
        System.out.println ("\nTest 2th method with 'result' word.");
        System.out.println ("Result: "+isElfish ("result"));
        for (int i = 0 ; i<100;i++) System.out.print("-");
        //----------------------------------------------------------------
        System.out.println ("\nTest 3th method with '10 8 5 11 0' array");
	    int[] array = new int[5];
	    array[0]=10;
        array[1]=8;
        array[2]=5;
        array[3]=11;
        array[4]=0;
        sortArrayBySelectionSort (array);
	    System.out.print("Result: ");
	    for(int i:array)
            System.out.print(i+" ");
	    System.out.println ();
        for (int i = 0 ; i<100;i++) System.out.print("-");
        //----------------------------------------------------------------
        System.out.println ("\nTest 4th method with '+ 7 + / - 10 * 5 3 10 - 2 / 4 8' prefix notation");
        String prefix = "+ 7 + / - 10 * 5 3 10 - 2 / 4 8";
        System.out.println ("Result: "+evPrefix (prefix,new LinkedList<> ()));
        for (int i = 0 ; i<100;i++) System.out.print("-");
        //----------------------------------------------------------------
        System.out.println ("\nTest 5th method with '4 7 * 20 -' postfix notation");
        String postfix = "4 7 * 20 -";
        System.out.println ("Result: "+evPostfix (postfix,new LinkedList<> ()));
        for (int i = 0 ; i<100;i++) System.out.print("-");
        //----------------------------------------------------------------
        System.out.println ("\nTest 6th method with following array");
	    int k =1;
	    //create array and print it.
	    int[][] arr = new int[5][4];
	    for (int i = 0;i<5;i++){
	        for (int j =0 ; j<4;j++){
	            arr[i][j] = k;
	            if (k<10)
                    System.out.print (k+"  ");
	            else
                    System.out.print (k+" ");
	            k++;
            }
	        System.out.println ();
        }
        System.out.println ();
        System.out.print ("Result: ");
	    printArraySpiral (arr);
        System.out.println ();
        for (int i = 0 ; i<100;i++) System.out.print("-");
    }
}
