import java.security.InvalidParameterException;
import java.util.NoSuchElementException;
/**
 * This class extends from the super class and implements all of the methods.
 * @author Akif Kartal
 * @version 1.0
 * */
public class GTUSet<T> extends GTUContainer<T> {
    protected Object[] data;
    protected int used;//size
    protected  GTUIterator<T> iter; //return value for some method
    /**
     * No parameter Constructor
     * */
    public GTUSet() {
        used=0;
        //create constant size array
    	// do not make copy paste
        data = new Object[1500];
    }
    /**
     * One parameter Constructor
     * @param arr an array of generic type
     * */
    public GTUSet(T[] arr){
        this.data = arr;
        used=0;
    }

    @Override
    public boolean empty() {
        return used == 0;
    }
    @Override
    public int size() {
        return used;
    }
    @Override
    public int max_size() {
        return data.length;
    }
    /**
     * Insert element that it can not be more than once in the set
     * @param value Element that will be inserted
     * */
    @SuppressWarnings("unchecked")
    @Override
    public GTUIterator<T> insert(T value) {
        //insert element by checking if it is_in set
        if (value == null)
            throw new IllegalArgumentException();
        boolean is_in=false;
        int index=-1;
        if (used >= this.max_size())//check size
            throw new ArrayStoreException();
        for (int i = 0; i < used ; i++)
        {
            if (data[i]==value)
            {
                is_in=true;
                index=i;
            }
        }
        if (!is_in) //if element is not in the set
        {
            //add it end of the array
            data[used]=value;
            used++;
            iter = new GTUIterator<T>((T[])data,used,used);
            System.out.printf("Your value added. Successfully.\n");

        }
        else{
            //return index of already in set
            iter = new GTUIterator<T>((T[])data,index,used);
            System.out.printf("Your value is already in the set.\n");
        }
        return iter;
    }
    @Override
    public void erase(T value) {
        int index=-1,k=0;
        if(this.empty()) //check size
        {
            throw new InvalidParameterException();
        }
        for (int i = 0; i < used ; i++)
        {
            if (data[i].equals(value))
            {
                index=i;
            }
        }
        if (index!=-1) //if it is found
        {
            for (int i = 0; i < used; i++)
            {
                //erase it by doing swap values
                if (i!=index)
                {
                    data[k]=data[i];
                    k++;
                }
                else if (i==used-1)
                {
                    Object temp=0;
                    data[k]=temp;
                }

            }
            used--;
            System.out.printf("Your value was erased!\n");
        }
        else
        {
            throw new NoSuchElementException();
        }

    }
    @Override
    public void clear() {
        used=0;
    }
    @SuppressWarnings("unchecked")
    @Override
    public GTUIterator<T> iterator() {
        //return a iterator by using iterator class
        iter = new GTUIterator<T>((T[])data,0,used);
        return iter;
    }
    @Override
    public boolean contains(Object o) {
        if(this.empty()) //check size
            throw new InvalidParameterException();
        for (int i=0;i<used;i++){
            if (data[i].equals(o)){
                return true;
            }
        }
        return false;
    }
    /**
     * Second overload of insert method.
     * Insert element according to given position that it can not be more than once in the set
     * @param pos Position of the element that will be inserted.
     * @param value Element that will be inserted
     * */
    @SuppressWarnings("unchecked")
    public GTUIterator<T> insert(GTUIterator<T> pos,T value) {
        //insert element by checking if it is_in set
        if ((value == null) || (pos.getCursor()< 0 || pos.getCursor()>used-1))
            throw new IllegalArgumentException();
        boolean is_in=false;
        int index=-1;
        if (used >= this.max_size())//check size
            throw new ArrayStoreException();
        for (int i = 0; i < used ; i++)
        {
            if (data[i]==value)
            {
                is_in=true;
                index=i;
            }
        }
        if (!is_in) //if element is not in the set
        {

            if (used==0) //if size is 0 add it begining of the set
            {
                data[used] =value;
                used++;
                return this.iterator();//return beginning of set
            }
            //swap value to insert among values
            T temp,temp2;
            temp =(T)data[pos.getCursor()];
            data[pos.getCursor()]=value;
            for (int i=pos.getCursor()+1; i<used;i++){
                temp2= (T)data[i];
                data[i]=temp;
                temp=temp2;

            }
            used++;
            System.out.println("Your value added. Successfully.");
            return pos;
        }
        else{
            //return index of already in set
            iter = new GTUIterator<T>((T[])data,index,used);
            System.out.printf("Your value is already in the set.");
        }
        return iter;
    }
    /**
     * Second overload of erase method.
     * Erase elements according to given range of position ( [first,last) ).
     * @param first Start position of the element that will be deleted.
     * @param last End position of the element that will be deleted.
     * */
    @SuppressWarnings("unchecked")
    public GTUIterator<T> erase(GTUIterator<T> first, GTUIterator<T> last){
        int i,k=0;
        //check iterators
        if ((first.getCursor() < 0 || first.getCursor()>=used) || (last.getCursor()< 1 || last.getCursor()>used))
            throw new InvalidParameterException();
        //erase elements according to given range ( [first,last) ) by using other erase method.
        for (i = first.getCursor(); i < last.getCursor(); i++){
            erase((T)data[i-k]);
            k++;
        }
        return iter = new GTUIterator<T>((T[])data,i,used);
    }
}
