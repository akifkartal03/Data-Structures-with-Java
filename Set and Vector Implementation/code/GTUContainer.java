/**
 * This is a Generic Abstract super Class
 * It contains only abstract methods
 * @author Akif Kartal
 * @version 1.0
 * */
public abstract class GTUContainer<T> {
    /**
     * This is a Generic helper inner class.
     * To go through the container.
     * Since, original containers like vector has own iterator
     * as an inner class, I implemented GTUIterator class as inner.
     * */
    public class GTUIterator<T> {
        private T[] data;
        private int cursor; //current position of iterator
        private int size;
        /**
         * No parameter Constructor
         * */
        public GTUIterator() {
            cursor=0;
            size=0;
        }
        /**
         * One parameter Constructor
         * @param arr an array of generic type
         * */
        public GTUIterator(T[] arr) {
            data=arr;
            cursor=0;
            size=0;
        }
        /**
         * Three parameter Constructor
         * @param arr an array of generic type
         * @param index Current position of iterator
         * @param length Length of container
         * */
        public GTUIterator(T[] arr, int index, int length) {
            data=arr;
            cursor=index;
            size=length;
        }
        /**
         * Copy Constructor
         * @param other another object of class to initialize
         * */
        public GTUIterator(GTUIterator<T> other) {
            this.data=(T[])other.data;
            this.cursor=other.cursor;
            this.size=other.size;
        }
        //getter-setter
        public int getCursor() {return cursor;}
        public void setCursor(int s) {cursor=s;}
        /**
         * Returns true if the iteration has more elements.
         * */
        public boolean hasNext() {
            return (cursor<size);
        }
        /**
         * Returns the next element in the iteration.
         * */
        public T next() {
            if(!hasNext())
                throw new ArrayIndexOutOfBoundsException();
            return data[cursor++];
        }
        /**
         * Returns current element of array as a String.
         * */
        @Override
        public String toString() {
            return data[cursor].toString();
        }

    }
    /**
     * Test whether container is empty
     * */
    public abstract boolean empty();
    /**
     * Return Container size
     * */
    public abstract int size();
    /**
     * Return maximum size
     * */
    public abstract int max_size();
    /**
     *  Insert element, throws exception java.lang.IllegalArgumentException
     *  if there is a problem with insertion
     * @param value A value to add container
     * */
    public abstract GTUIterator<T> insert(T value);
    /**
     * Erase element
     * @param value A value to remove from container
     * */
    public abstract void erase(T value);
    /**
     * Clear all content
     * */
    public abstract void clear();
    /**
     * Return iterator to beginning
     * */
    public abstract GTUIterator<T> iterator();
    /**
     * Returns true if this collection contains the specified element
     * @param o the specified element
     * */
    public abstract boolean contains(Object o);
}
