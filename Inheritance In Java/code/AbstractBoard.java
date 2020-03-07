import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.security.InvalidParameterException;

/**
 * This is an Abstract super Class
 * Abstract methods are end of the class.
 * @author Akif Kartal
 * @version 1.0
 * */
public abstract class AbstractBoard{
    protected boolean is_end;
    protected static int number_Of_Board=0;
    protected int number_Of_Moves;
    protected char last_Move;
    protected int row,column,size;
    /**
     *  Helper method.
     * @param str is a string to convert into int
     * */
    private int convertStrToInt(String str){
        return Integer.parseInt(str);
    }
    /**
     *  Helper method.
     * @param index1 indexes indicates place of values that will be swapped.
     * */
    private void swapTiles(int index1,int index2,int index3,int index4){
        //swap two tiles in the puzzle
        int temp;
        temp=this.cell(index1,index2);
        this.cell(index1,index2,this.cell(index3,index4));
        this.cell(index3,index4,temp);
    }
    /**
     * No parameter Constructor
     * */
    public AbstractBoard(){
        this(false,0,'S',0,0,0);
    }
    /**
     * Two parameter Constructor
     * */
    public AbstractBoard(int r,int c){
        this(false,0,'S',r,c,0);
    }
    /**
     * Full parameter Constructor
     * */
    public AbstractBoard(boolean end,int number_move,char lMove,int r,int c,int s){
        is_end=end;number_Of_Moves=number_move;
        last_Move=lMove;row=r;
        column=c;size=s;
        number_Of_Board++;
    }
    /*----getters and setters----*/
    public int getRow() {
        return row;
    }
    public int getColumn(){
        return column;
    }
    public int getSize(){
        return size;
    }
    public boolean getEnd() {
        return is_end;
    }
    public void setEnd(boolean result){
        is_end=result;
    }
    public void setNumberOfMoves(){
        //decrement number of moves by two(this will be used in global method)
        number_Of_Moves-=2;
    }
    public void setLastMove(char direction){
        last_Move=direction;
    }//set size enough to set, so we don't need any other setter
    /*other methods implementation*/
    /**
     * produces the board as string.
     * */
    public String toString(){
        String shape="";//shape of puzzle
        int i,j,k;
        for ( i = 0; i < row; i++)
        {
            shape+="\n";
            //at the beginning print --------
            for ( k = 0; k < column*3+1; k++) shape+="-";
            shape+="\n";
            //now prints numbers
            for ( j = 0; j < column; j++)
            {
                shape+="|";
                if (this.cell(i,j)==-1)
                    //if number is -1 then print space
                    shape+="  ";
                else if (this.cell(i,j)==0)
                    shape+="00";
                else if (this.cell(i,j)<10 && this.cell(i,j)!=0 )
                    shape+="0"+this.cell(i,j);
                else
                    shape+=this.cell(i,j);
            }
            shape+="|";
        }
        shape+="\n";
        //at the end print ------
        for ( k = 0; k < column*3+1; k++) shape+="-";
        shape+="\n";
        return shape;
    }
    /**
     * Reads the board from the file given as method parameter.
     * @param fileName file name of file
     * */
    public boolean readFromFile(String fileName){
        int i,j,k,tile,columnNumber,a;
        int  sum=0,numberOfZero=0,rowNumber=0;
        String str=null; //to keep whole line
        String[] arr;//to keep cell context
        try {
            //open file
            File f=new File(fileName);
            BufferedReader bfr = new BufferedReader(new FileReader(f));
            //get some information from file to set size
            while( (str=bfr.readLine()) != null) {

                a=( arr = str.split("\\s")).length;//this gives how many cell a line contain
                sum+=a;
                for (i=0;i<a;i++){
                    if (arr[i].equals("00"))
                    {
                        numberOfZero++;
                    }
                }
                rowNumber++;
            }
            bfr.close();
            columnNumber=sum/rowNumber;//get column number
            f=new File(fileName);
            bfr = new BufferedReader(new FileReader(f));
            this.setSize(rowNumber,columnNumber,sum-numberOfZero); //set size
            //get puzzle shape from file and fill puzzle array
            for ( i = 0; i < rowNumber;)
            {
                for (j = 0; j < columnNumber;)
                {
                    while( (str=bfr.readLine()) != null) {
                        a=( arr = str.split("\\s")).length;
                        j=0;
                        for (k=0; k < a; k++){
                            if (!arr[k].equals("bb")){
                                tile=Integer.parseInt(arr[k]);//convert str to int
                                this.cell(i,j++,tile);//fill puzzle array
                            }
                            else
                                this.cell(i,j++,-1);//put -1
                        }
                        i++;
                    }

                }
            }
            bfr.close();
            return true;
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
        return false;
    }
    /**
     * Writes the board to the file given as method parameter.
     * @param fileName file name of file
     * */
    public void writeToFile(String fileName){
        //fill file with a loadable shape file
        int i,j;
        try {
            //open file
            File fn=new File(fileName);
            FileWriter wrt = new FileWriter(fn);
            for ( i = 0; i < row; i++)
            {
                for ( j = 0; j < column; j++)
                {
                    if (this.cell(i,j)==0){
                        wrt.write("00");
                        wrt.write(32);
                    }
                    else if (this.cell(i,j)==-1){
                        wrt.write("bb");
                        wrt.write(32);
                    }
                    else
                    {
                        if (this.cell(i,j)<10)
                        {
                            wrt.write("0");
                            wrt.write(Integer.toString(this.cell(i,j)));
                            wrt.write(32);

                        }
                        else
                        {
                            wrt.write(Integer.toString(this.cell(i,j)));
                            wrt.write(32);

                        }
                    }
                }
                if (i!=row-1)
                    wrt.write("\n");
            }
            wrt.close();
        }
        catch (Exception e){
            System.out.println(e.toString());
        }
    }
    /**
     * Resets the board to the solution.
     * */
    public void reset(){
        //reset puzzle with solution
        int i,j,currentvalue=1;
        for ( i = 0; i < row; i++)
        {
            for ( j = 0; j < column; j++)
            {
                if (i==row-1 && j==column-1)
                    this.cell(i,j,-1);
                else{
                    if (this.cell(i,j)!=0)
                    {
                        this.cell(i,j,currentvalue);
                        currentvalue++;
                    }
                    else
                    {
                        this.cell(i,j,0);
                    }
                }
            }
        }
        /*Update some important values*/
        number_Of_Moves=0;
        last_Move ='S';
    }
    /**
     * Makes a move according to the given char parameter. If the parameter
     * is L then the blank tiles moves left, …, etc,
     * @param move_direction direction left,right,etc.
     * */
    public boolean move(char move_direction){
        int i,j;
        for (i = 0; i < row; i++)
        {
            for ( j = 0; j < column; j++)
            {
                if (this.cell(i,j)==-1) //find zero in order to moves the empty cell
                {
                    if (move_direction=='L')//left
                    {
                        if (j==0) // if there is no room left side of empty cell
                            return false;
                        else //if there is room
                        {
                            if (this.cell(i,j-1)==0)//if it is impossible position return false
                                return false;
                            else
                            {
                                //swap the 0 and left tile and update values
                                swapTiles(i,j,i,j-1);
                                this.last_Move='L';
                                this.number_Of_Moves++;
                                return true;
                            }
                        }
                    }
                    else if (move_direction=='R')//right
                    {
                        if (j==(column-1)) // if there is no room right side of empty cell
                            return false;
                        else //if there is room
                        {
                            if (this.cell(i,j+1)==0)//if it is impossible position return false
                                return false;
                            else
                            {
                                //swap the 0 and right tile and update values
                                swapTiles(i,j,i,j+1);
                                this.last_Move='R';
                                this.number_Of_Moves++;
                                return true;
                            }
                        }
                    }
                    else if (move_direction=='U')//up
                    {
                        if (i==0) // if there is no room up side of empty cell
                            return false;
                        else //if there is room
                        {
                            if (this.cell(i-1,j)==0)//if it is impossible position return false
                                return false;
                            else
                            {
                                //swap the 0 and up tile and update values
                                swapTiles(i,j,i-1,j);
                                this.last_Move='U';
                                this.number_Of_Moves++;
                                return true;
                            }
                        }
                    }
                    else if (move_direction=='D')//down
                    {
                        if (i==(row-1)) // if there is no room down side of empty cell
                            return false;
                        else //if there is room
                        {
                            if (this.cell(i+1,j)==0)//if it is impossible position return false
                                return false;
                            else
                            {
                                //swap the 0 and down tile and update values
                                swapTiles(i,j,i+1,j);
                                this.last_Move='D';
                                this.number_Of_Moves++;
                                return true;
                            }
                        }

                    }
                    else
                    {
                        System.out.printf("Invalid Direction!\n");
                        return false;
                    }

                }

            }
        }
        return false;
    }
    /**
     * Returns true if the board is a solution.
     * */
    public boolean is_solved(){
        //this method to check Is the game over ?
        int i,j,currentvalue=1;
        for ( i = 0; i < row; i++)
        {
            for ( j = 0; j < column; j++)
            {
                if (this.cell(i,j)!=0)
                {
                    if (this.cell(i,j)!=currentvalue)
                    {
                        if (i==row-1 && j==column-1)
                        {
                            if (this.cell(i,j)==-1) // check for empty cell
                            {
                                this.is_end=true;
                                return true;
                            }
                            else
                                return false;
                        }
                        else
                            return false;
                    }
                    currentvalue++;
                }

            }

        }
        return false;
    }
    /**
     * Two boards are equal, if the boards are the same.
     * This operator does not consider last move or the number of steps.
     * */
    @Override
    public boolean equals(Object o){
        if (o==null){
            throw new InvalidParameterException();
        }
        if (o == this){
            return true;
        }
        if (this.row != ((AbstractBoard)o).row || this.column != ((AbstractBoard)o).column)
            return false;
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                if (this.cell(i,j)!=((AbstractBoard)o).cell(i,j))
                {
                    return false;
                }
            }
        }
        return true;
    }
    /**
     * return number of board that created so far.
     * */
    public static int NumberOfBoards(){
        return number_Of_Board;
    }
    /**
     * return last move that was made.
     * */
    public char lastMove(){
        return last_Move;
    }
    /**
     * return number of move that was made so far.
     * */
    public int numberOfMoves(){
        return number_Of_Moves;
    }
    /*---my abstract methods---*/
    //these abstract methods will prevent a huge code repetition.
    /**
     * This method will be used in global method.
     * Takes two indexes and returns the corresponding cell content.
     * Terminates program if the indexes are not valid.
     * */
    public abstract int cell(int index1,int index2);
    //this method will be used in the base class's methods to access and change values
    /**
     * Takes two indexes and a new value.
     * Change corresponding cell content with new value.
     * Terminates program if the indexes are not valid.
     * */
    protected abstract void cell(int index1,int index2,int newValue);

    /**
     * This method will be different for derived class so it's abstract
     * Sets the board size to given values. The values are given as parameters
     * and there are no restrictions on the board size.
     * The board is reset after this operation.
     * */
    public abstract void setSize(int r,int c,int s);
    //As in the slides, I gave up these(abstract) end of the class.
}
