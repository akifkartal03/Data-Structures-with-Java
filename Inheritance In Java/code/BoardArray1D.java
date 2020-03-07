import java.security.InvalidParameterException;
/**
 * The BoardArray1D extends from AbstractBoard class.
 * The Board is represented using a one dimensional Java array.
 * */
public class BoardArray1D extends AbstractBoard {
    private int[] puzzle; //1D java array
    /**
     * No parameter Constructor
     * */
    public BoardArray1D(){
        super(false,0,'S',3,3,9);
        //create an array with size 9
        setSize(row,column,size);

    }
    /**
     * Two parameter Constructor
     * */
    public BoardArray1D(int r,int c){
        super(false,0,'S',r,c,r*c);
        //create an array with size r*c
        setSize(row,column,size);
    }
    /**
     * Takes two indexes and returns the corresponding cell content.
     * Since, this is 1D dynamic array return context of cell that corresponding to 2D array
     * by using math.
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
        return puzzle[column*index1+index2];
    }
    /**
     * Takes two indexes and a new value.
     * Change corresponding cell content with new value.
     * Since, this is 1D dynamic array change context of cell that corresponding to 2D array
     * by using math.
     * Terminates program if the indexes are not valid.
     * */
    @Override
    protected void cell(int index1, int index2, int newValue) {
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
        //since this is 1D dynamic array change context of cell that corresponding to 2D array
        //that's why I did column*index1+index2
        //change context of cell that corresponding to with new value
        puzzle[column*index1+index2]=newValue;
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
        puzzle=new int[row*column];
        for (int j = 0; j < row*column; j++)
        {
            puzzle[j]=-1;//fill all puzzle with -1
        }
        this.reset();// and reset
    }
}
