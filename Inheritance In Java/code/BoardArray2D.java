
import java.security.InvalidParameterException;
/**
 * The BoardArray2D extends from AbstractBoard class.
 * The Board is represented using a two dimensional Java array.
 * */
public class BoardArray2D extends AbstractBoard{
    private int[][] puzzle;
    /**
     * No parameter Constructor
     * */
    public BoardArray2D(){
        super(false,0,'S',3,3,9);
        //create an array with size 9 by default
        setSize(row,column,size);

    }
    /**
     * Two parameter Constructor
     * */
    public BoardArray2D(int r,int c){
        super(false,0,'S',r,c,r*c);
        //create an array with size r*c
        setSize(row,column,size);
    }
    /**
     * Takes two indexes and returns the corresponding cell content.
     * Terminates program if the indexes are not valid.
     * */
    @Override
    public int cell(int index1, int index2) {
        //this method is to access and return the value
        if (size<=0)
        {
            throw new InvalidParameterException();
        }
        else if (index1 < 0 || index1 >= row || index2 < 0 || index2 >= column)
        {
            //terminate program
            System.out.println("Indexes are not valid! ");
            System.out.println("Program Terminating... ");
            System.exit(0);
        }
        //since this is 1D dynamic array return context of cell that corresponding to 2D array
        //that's why I did column*index1+index2
        return puzzle[index1][index2];
    }
    /**
     * Takes two indexes and a new value.
     * Change corresponding cell content with new value.
     * Terminates program if the indexes are not valid.
     * */
    @Override
    protected void cell(int index1, int index2, int newValue) {
        if (size<=0)
        {
            //throw an exception will terminate program by giving message
            throw new InvalidParameterException();
        }
        else if (index1 < 0 || index1 >= row || index2 < 0 || index2 >= column)
        {
            //terminate program
            System.out.println("Indexes are not valid! ");
            System.out.println("Program Terminating... ");
            System.exit(0);
        }
        puzzle[index1][index2] = newValue;
    }
    /**
     * Create a java array with given size and reset with solution.
     * @param r row value
     * @param c column value
     * @param s size value
     * */
    @Override
    public void setSize(int r, int c, int s) {
        row=r;column=c;size=s;
        puzzle=new int[row][column];
        //fill puzzle with -1
        for (int i = 0; i < row; i++)
        {
            for (int j = 0; j < column; j++)
            {
                puzzle[i][j]=-1;
            }
        }
        this.reset();// and reset
    }
}

