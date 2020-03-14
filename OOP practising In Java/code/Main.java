import java.util.Scanner;
/**
 * Main class is to test my classes and methods.
 * */
public class Main {

    public static void main(String[] args) {
	    testMyCode();
    }
    /**
     * returns true if the array contains a valid sequence of moves for a solution.
     * @param ptrArr an array of AbstractBoard references.
     * */
    public static boolean checkMoves(AbstractBoard[] ptrArr){
        char[] pDirections = new char[4];
        char temp;
        boolean result=false;
        for (int i = 0; i < ptrArr.length-1; i++){
            getPossibleMoves(ptrArr[i],pDirections);//get possible direction of first puzzle
            result=false;//set the result to false
            for (int j = 0; j < 4; j++)
            {
                if (pDirections[j]!='S')
                {
                    if (pDirections[j]=='L')
                    {
                        temp=ptrArr[i].lastMove();//save current last move
                        ptrArr[i].move('L');//make a temp move to the left
                        if (ptrArr[i].equals(ptrArr[i+1]))//check the puzzles
                        {
                            result=true;//update the result
                        }
                        ptrArr[i].move('R');//move to original puzzle
                        ptrArr[i].setLastMove(temp);//update last move
                        ptrArr[i].setNumberOfMoves(); //number_of_moves-=2
                    }
                    else if (pDirections[j]=='R')
                    {
                        temp=ptrArr[i].lastMove();
                        ptrArr[i].move('R');//make a temp move to the right
                        if (ptrArr[i].equals(ptrArr[i+1]))
                        {
                            result=true;
                        }
                        ptrArr[i].move('L');
                        ptrArr[i].setLastMove(temp);
                        ptrArr[i].setNumberOfMoves();
                    }
                    else if (pDirections[j]=='U')
                    {
                        temp=ptrArr[i].lastMove();
                        ptrArr[i].move('U');//make a temp move to the right
                        if (ptrArr[i].equals(ptrArr[i+1]))
                        {
                            result=true;
                        }
                        ptrArr[i].move('D');
                        ptrArr[i].setLastMove(temp);
                        ptrArr[i].setNumberOfMoves();
                    }
                    else if (pDirections[j]=='D')
                    {
                        temp=ptrArr[i].lastMove();
                        ptrArr[i].move('D');//make a temp move to the right
                        if (ptrArr[i].equals(ptrArr[i+1]))
                        {
                            result=true;
                        }
                        ptrArr[i].move('U');
                        ptrArr[i].setLastMove(temp);
                        ptrArr[i].setNumberOfMoves();
                    }
                }

            }
            if (!result)//if we didn't find the one of the possible return false
            {
                return false;
            }
        }
        return result;

    }
    /**
     * Helper method for checkMoves.
     * @param ptr an variable of AbstractBoard to find possible directions of it.
     * @param directions an array of possible directions of Board.
     * */
    public static void getPossibleMoves(AbstractBoard ptr, char[] directions){
        //this method returns possible directions of parameter's puzzle
        for (int i = 0; i < ptr.getRow(); i++)
        {
            for (int j = 0; j < ptr.getColumn(); j++)
            {
                if (ptr.cell(i,j)==-1)
                {
                    if (j-1>=0 && ptr.cell(i,j-1)!=0)
                    directions[0]='L';
                else
                    directions[0]='S';
                    if (j+1<ptr.getColumn() && ptr.cell(i,j+1)!=0)
                    directions[1]='R';
                else
                    directions[1]='S';
                    if (i-1>=0 && ptr.cell(i-1,j)!=0)
                    directions[2]='U';
                else
                    directions[2]='S';
                    if (i+1<ptr.getRow() && ptr.cell(i+1,j)!=0)
                    directions[3]='D';
                else
                    directions[3]='S';
                }

            }

        }

    }
    /**
     * Test my code by using user instruction.
     * */
    public static void testMyCode(){
        Scanner input =new Scanner(System.in);
        int choice=1;
        while (choice!=0){
            try
            {
                menu1();
                choice=input.nextInt();
                while (choice<0 || choice>3)
                {
                    System.out.print("Please enter a number between 0 and 4: ");
                    choice=input.nextInt();
                }
                if (choice==1)
                {
                    /*test with temp 1D Board*/
                    BoardArray1D temp1D = new BoardArray1D();
                    testMyObjects(temp1D);
                }
                else if (choice==2)
                {
                    /*test with temp 2D Board*/
                    BoardArray2D temp2D = new BoardArray2D();
                    testMyObjects(temp2D);
                }
                else if (choice==3)
                {
                    //test global funciton
                    testMyGlobalMethod();
                }

            }
            catch(Exception e){
                choice=5;
                System.out.print("Please enter a number between 0 and 4!\n");
                input.next();
            }
        }

    }
    /**
     * Menu for user.
     * */
    public static void menu1(){
        System.out.println("Welcome to HW7 ");
        System.out.println("[1] Create a 1D Board Object");
        System.out.println("[2] Create a 2D Board Object");
        System.out.println("[3] Test Global method");
        System.out.println("[0] Exit.");
        System.out.print("Answer: ");
    }
    /**
     * Menu for user.
     * */
    public static void menu2(){
        System.out.printf("\n[1] Test toString\n");
        System.out.printf("[2] Test readFromFile\n");
        System.out.printf("[3] Test writeToFile\n");
        System.out.printf("[4] Test reset\n");
        System.out.printf("[5] Test setSize\n");
        System.out.printf("[6] Test move\n");
        System.out.printf("[7] Test is_solved\n");
        System.out.printf("[8] Test cell\n");
        System.out.printf("[9] Test NumberOfBoards\n");
        System.out.printf("[10] Test numberOfMoves\n");
        System.out.printf("[11] Test lastMove\n");
        System.out.println("[0] Main Page.");
        System.out.println("NOTE: Equal method is tested in test global method.(It is meaningless here)\"");
        System.out.println("NOTE_2: Your board will be updated after some choices. i.e reset");
        System.out.print("Answer: ");
    }
    /**
     * Get a file name from user.
     * */
    public static String getFileName(){
        Scanner input = new Scanner(System.in);
        String name=null;
        System.out.print("Enter a File Name: ");
        try {
            name = input.nextLine();
        }
        catch (Exception e){
        	System.out.print("Please enter a valid value!\n");
            input.next();
        }
        return name;
    }
    /**
     * A generic method to test My objects of classes.
     * @param object a generic parameter.
     * */
    public static <T extends AbstractBoard> void testMyObjects(T object){
        //test my method that is common among my class
        //the equal method is tested in global method
        Scanner input =new Scanner(System.in);
        int subChoice=1,row,column,i1,i2;
        char direction;
        System.out.printf("\n***An 3X3 board created successfully.***\n");
        System.out.print(object.toString());
        while (subChoice!=0)
        {
            menu2();
            try{
                subChoice=input.nextInt();
                while (subChoice<0 || subChoice>11)
                {
                    System.out.print("Please Enter a number between 0 and 11: ");
                    subChoice=input.nextInt();
                }
                switch (subChoice)
                {
                    case 1:
                        System.out.print(object.toString());break;
                    case 2:
                        object.readFromFile(getFileName());
                        System.out.print(object.toString());
                        break;
                    case 3:
                        object.writeToFile(getFileName());
                        System.out.println("Your puzzle saved successfully.");
                        System.out.print(object.toString());
                        break;
                    case 4:
                        object.reset();
                        System.out.print(object.toString());
                        break;
                    case 5:
                        System.out.printf("Enter  a Row value: ");
                        row =input.nextInt();
                        System.out.printf("Enter  a Column value: ");
                        column =input.nextInt();
                        object.setSize(row,column,row*column);
                        System.out.println("Your Puzzle created again.");
                        System.out.print(object.toString());
                        break;
                    case 6:
                        System.out.printf("Enter Your Direction(Upper Case): ");
                        direction=input.next().charAt(0);
                        while (!object.move(direction))
                        {
                            System.out.println("***You can not move this direction!***");
                            System.out.printf("Enter Your Direction(Upper Case) Again: ");
                            direction=input.next().charAt(0);
                        }
                        System.out.print(object.toString());
                        break;
                    case 7:
                        if (object.is_solved())
                        {
                            System.out.printf("\nYour puzzle was already solved.\n");
                        }
                        else
                        {
                            System.out.printf("\nYour puzzle is not solved yet.\n");
                        }
                        System.out.print(object.toString());
                        break;
                    case 8:
                        System.out.printf("Enter first index: ");
                        i1 =input.nextInt();
                        System.out.printf("Enter second index: ");
                        i2 =input.nextInt();
                        if (object.cell(i1,i2) == -1)
                            System.out.println("\nYour Cell Context is : Empty");
                        else
                            System.out.println("\nYour Cell Context is : " + object.cell(i1,i2));
                        System.out.print(object.toString());
                        break;
                    case 9:
                        System.out.printf("\nNumber of Boards created so far : %d\n" ,object.NumberOfBoards());
                        System.out.printf("*Some of them might come from test global method!\n");
                        System.out.print(object.toString());
                        break;
                    case 10:
                        System.out.printf("\nNumber of moves this board made : %d" ,object.numberOfMoves());
                        System.out.print(object.toString());
                        break;
                    case 11:
                        System.out.printf("\nThe last move of this board: %c" ,object.lastMove());
                        System.out.print(object.toString());
                        break;
                    default:
                        break;
                }
            }
            catch (Exception e){
                subChoice=15;
                System.out.print("Please Enter a number between 0 and 11!\n");
                input.next();
            }
        }

    }
    /**
     * A method to test My global checkMoves method.
     * */
    public static void testMyGlobalMethod(){
        //this method tests my global method
        AbstractBoard[] ptrArr = new AbstractBoard[4];//create an array of AbstractBoard pointers
        BoardArray1D[] boards = new BoardArray1D[4];
        BoardArray2D b1 = new BoardArray2D();//create a 2d object
        for (int i = 0; i < 4; i++) boards[i] = new BoardArray1D(); //fill the board
        for (int i = 0; i < 4; i++) boards[i].readFromFile("akif.txt"); //fill the board
        boards[1].move('R');
        boards[2].move('R');//move
        boards[2].move('R');
        boards[3].move('R');//move
        boards[3].move('R');
        boards[3].move('D');//move
        for (int i = 0; i < 4; i++) //push it the moves to the array of pointers
        {
            ptrArr[i]=boards[i];//push
            System.out.print(ptrArr[i].toString());
        }
        /*test my global method*/
        if (checkMoves(ptrArr))
        {
            System.out.printf("\nYour Moves are Correct!\n\n");
        }
        else
        {
            System.out.printf("\nYour Moves are Invalid!\n\n");
        }
        b1.readFromFile("akif.txt");//fill 2D object
        ptrArr[3]=b1;//push it an invalid move and test again
        for (int i = 0; i < 4; i++) System.out.print(ptrArr[i].toString()); //toString again
        if (checkMoves(ptrArr))
        {
            System.out.printf("\nYour Moves are Correct!\n\n");
        }
        else
        {
            System.out.printf("\nYour Moves are Invalid!\n\n");
        }

    }

}
