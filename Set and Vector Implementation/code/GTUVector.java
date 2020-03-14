/**
 * This class extends from the set class.
 * To avoid code repetition
 * @author Akif Kartal
 * @version 1.0
 * */
public class GTUVector<T> extends GTUSet<T> {
    /**
     * No parameter Constructor
     * */
    public GTUVector() {
        super();
    }
    /**
     * One Parameter Constructor
     * @param arr an array of generic type
     * */
    public GTUVector(T[] arr) {
        super(arr);
    }
    /**
     * Insert element that it can be more than once in the vector
     * */
    @SuppressWarnings("unchecked")
    @Override
    public GTUIterator<T> insert(T value) {
        //since only insert different from set class redefine it.
         if (value == null)
            throw new IllegalArgumentException();
        if (this.used >= this.max_size())
            throw new ArrayStoreException();
        this.data[this.used]=value;
        this.used++;
        this.iter = new GTUIterator<T>((T[])this.data,this.used,this.used);
        System.out.printf("Your value added. Successfully.\n");
        return this.iter;
    }

    /**
     * Second overload of insert method.
     * Insert element according to given position that it can be more than once in the vector
     * @param pos Position of the element that will be inserted.
     * @param value Element that will be inserted
     * */
    @SuppressWarnings("unchecked")
    @Override
    public GTUIterator<T> insert(GTUIterator<T> pos,T value) {
        if (value == null)
            throw new IllegalArgumentException();
        if (used >= this.max_size())//check size
            throw new ArrayStoreException();
        if (used == 0) //if size is 0 add it beginning of the vector
        {
            data[this.used] = value;
            used++;
            return this.iterator();//return beginning of vector
        }
        //swap values
        T temp, temp2;
        temp = (T) data[pos.getCursor()];
        data[pos.getCursor()] = value;
        for (int i = pos.getCursor() + 1; i < this.used; i++) {
            temp2 = (T) data[i];
            data[i] = temp;
            temp = temp2;
        }
        used++;
        System.out.println("Your value added. Successfuly.");
        return pos;
    }
}
