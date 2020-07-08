package com.Akif;
import java.util.ListIterator;
import java.util.NoSuchElementException;

/***
 * This class is to handle words of a crossword puzzle.
 * Each node keeps a character and references to previous and next nodes.
 * To link the words, each node may have a reference to a cross node, as well.
 */
public class WordLinkedList {
    private Node head;
    private Node tail;
    private int size;

    /***
     * No parameter constructor to initialize the references.
     */
    public WordLinkedList(){
        head = null;
        tail = null;
        size = 0;
    }

    /***
     * One parameter constructor to construct the itself as WordLinkedList by using specified word.
     * @param word specified word to construct the itself as WordLinkedList.
     */
    public WordLinkedList(String word){
        this();
        for (int i = 0 ;i<word.length ();i++){
            add (i,word.charAt (i));
        }
    }

    /***
     * This method adds a cross between itself and another word at specified indexes.
     * The other word should have the corresponding cross, as well.
     * @param other other WordLinkedList object to add a cross.
     * @param itselfIndex index of cross letter(node) in my word
     * @param otherIndex index of cross letter(node) in other word
     */
    public void addCross(WordLinkedList other,int itselfIndex,int otherIndex){
        Node myNode =getNode (itselfIndex);
        Node otherNode =  other.getNode (otherIndex);
        myNode.cross = otherNode;
        otherNode.cross = myNode;
    }

    /***
     * This method removes a cross at specified index in my word.
     * @param index index of cross letter(node) in my word.
     */
    public void removeCross(int index){
        Node myNode =getNode (index);
        Node otherNode =  myNode.cross;
        otherNode.cross=null;
        myNode.cross=null;
    }

    /***
     * This method prints the word, its cross words and cross indexes.
     * It prints the word and its cross words as in the real puzzle.
     */
    public void print(){
        if (crossSize () > 0){
            for (int i =0;i<this.size;i++){
                Node node = getNode (i).cross;
                if (node!=null){
                    printCrossWord (node);
                }
                else{
                    for (int j = 0 ;j<(maxPrev())*3;j++){
                        System.out.print (" ");
                    }
                    System.out.print ("|"+get (i)+"|\n");
                }
            }
            int counter = 1;
            for (int i=0;i<this.size();i++){
                Node node = getNode (i).cross;
                if (node!=null){
                    System.out.println ("\n"+counter+")");
                    System.out.print("CrossWord: ");
                    printWord (node);
                    System.out.println ("Itself Cross Index: "+i);
                    System.out.println ("Cross Word Cross Index: "+getPrevNumber (node));
                    counter++;
                }
            }
        }
        else{
            for (int i = 0 ;i < this.size;i++){
                System.out.print ("|"+get (i)+"|\n");
            }
        }

    }
    /***
     * Inserts the specified element at the specified position in this list.
     * @param index index at which the specified element is to be inserted
     * @param obj element to be inserted
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public void add(int index,Character obj){
        MyListIterator iter = new MyListIterator (index);
        iter.add (obj);
    }
    /***
     * This method adds a new element to the array in front of the linked list.
     * @param obj new element that will be added.
     */
    public void addFirst(Character obj){
        MyListIterator iter = new MyListIterator (0);
        iter.add (obj);
    }
    /***
     * Appends the specified element at the end of this list.
     * @param obj element to be appended to this list
     */
    public void add(Character obj){
        MyListIterator iter = new MyListIterator (size);
        iter.add (obj);
    }
    /***
     * Returns the first element in this list.
     * @return the first element in this list.
     */
    public Character getFirst(){
        if (head == null)
            throw new NoSuchElementException ();
        return head.data;
    }
    /***
     * Returns the element at the specified position in this list.
     * @param index index of the element to return
     * @return the element at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public Character get(int index){
        MyListIterator iter = new MyListIterator (index);
        return iter.nextItem.data;
    }
    /***
     * Returns the last element in this list.
     * @return the last element in this list.
     */
    public Character getLast(){
        return tail.data;
    }
    /***
     * Returns the Node at the specified position in this list.
     * @param index index of the node to return
     * @return the node at the specified position in this list
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    private Node getNode(int index){
        MyListIterator iter = new MyListIterator (index);
        return iter.nextItem;
    }
    /***
     * Removes the first occurrence of the specified element from this list, if it is present.
     * @param obj element to be removed from this list, if present
     * @return true if this list contained the specified element, otherwise false
     */
    public boolean remove(Character obj){
        MyListIterator iter = new MyListIterator (0);
        while (iter.hasNext ()){
            if (iter.nextItem.data == obj){
                iter.remove ();
                return true;
            }
            iter.next();
        }
        return false;
    }
    /***
     * Removes the element at the specified position in this list.
     * Returns removed the first element of the array at the specified position in this list.
     * @param index the index of the element to be removed
     * @return removed first element of the array at the specified position in this list.
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public Character remove(int index){
        MyListIterator iter = new MyListIterator (index);
        Character temp = iter.nextItem.data;
        iter.remove ();
        return temp;
    }
    /***
     * Returns size of the list.
     * @return size of the list.
     */
    public int size(){
        return size;
    }
    /***
     * Returns a string to print list to the screen in a good shape.
     * @return a string to print list to the screen in a good shape.
     */
    public String toString(){
        MyListIterator iter =new MyListIterator (0);
        StringBuilder result = new StringBuilder ();
        while (iter.hasNext ()){
            result.append (iter.next ());
        }
        return result.toString ();
    }
    /***
     * Returns a MyListIterator over the elements in this list (in proper sequence).
     * @return  MyListIterator over the elements in this list (in proper sequence).
     */
    public MyListIterator listIterator(){
        return new MyListIterator (0);
    }
    /***
     * Returns a MyListIterator over the elements in this list (in proper sequence),
     * starting at the specified position in the list.
     * @param index index of the first element to be returned from the list iterator (by a call to next)
     * @return MyListIterator over the elements in this list (in proper sequence),
     * starting at the specified position in the list.
     * @throws IndexOutOfBoundsException if the index is out of range
     */
    public MyListIterator listIterator(int index){
        return new MyListIterator (index);
    }

    /***
     * A helper method to print puzzle in a good shape.
     * This method print cross word by using cross node reference's next and prev reference in a good shape.
     * @param crossNode a node of the list to print its data.
     */
    private void printCrossWord(Node crossNode){
        int max=maxPrev ();
        int myPrev =getPrevNumber (crossNode);
        while (crossNode.prev!=null){
            crossNode=crossNode.prev;
        }
        Node iter = crossNode;
        for (int i = 0 ;i<(max-myPrev)*3;i++){
            System.out.print (" ");
        }
        while (iter!=null){
            System.out.print ("|"+iter.data+"|");
            iter=iter.next;
        }
        System.out.println ();
    }

    /***
     * A helper method to print puzzle in a good shape.
     * This method print just cross word without puzzle shape by using cross node reference's next and prev reference.
     * @param crossNode a node of the list to print its data.
     */
    private void printWord(Node crossNode){
        while (crossNode.prev!=null){
            crossNode=crossNode.prev;
        }
        Node iter = crossNode;
        while (iter!=null){
            System.out.print (iter.data);
            iter=iter.next;
        }
        System.out.println ();
    }

    /***
     * Returns how many cross word this word has.
     * @return how many cross word this word has.
     */
    private int crossSize(){
        int counter =0;
        MyListIterator iter = new MyListIterator (0);
        while (iter.hasNext ()){
            if (iter.nextItem.cross!=null){
                counter++;
            }
            iter.next();
        }
        return counter;
    }

    /***
     * Determines among the my cross words max number of the previous node to print word in a puzzle shape.
     * @return among the my cross words max number of the previous node.
     */
    private int maxPrev(){
        int max =0,number;
        MyListIterator iter = new MyListIterator (0);
        while (iter.hasNext ()){
            if (iter.nextItem.cross!=null){
                number =getPrevNumber (iter.nextItem.cross);
                if (number>max){
                    max =number;
                }
            }
            iter.next();
        }
        return max;
    }

    /***
     * Returns the prev node number of given node, to print word in a puzzle shape.
     * @param crossNode a node to determine prev node.
     * @return
     */
    private int getPrevNumber(Node crossNode){
        int counter =0;
        while (crossNode.prev!=null){
            counter++;
            crossNode=crossNode.prev;
        }
        return counter;
    }
    /***
     * Node class to build a linked list.
     * It has next, prev and cross node references.
     */
    private static class Node{
        private Character data;
        private Node next;
        private Node prev;
        private Node cross;
        /***
         * One parameter constructor it initializes the references and data.
         * @param item an element to put node as data.
         */
        public Node(Character item){
            data = item;
            next=null;
            prev = null;
            cross = null;
        }

        /***
         * A constructor it initializes the references and data.
         * @param item an element to put node as data.
         * @param n a next reference
         * @param p a previous reference
         * @param c a cross reference
         */
        public Node(Character item,Node n ,Node p,Node c){
            data = item;
            next = n;
            prev =p;
            cross=c;
        }
    }

    /***
     * This class is implementation of Java ListIterator<Character> interface.
     */
    private class MyListIterator implements ListIterator<Character> {
        private Node nextItem;
        private Node lastItem;
        private int index;
        /***
         * One parameter constructor to create a iterator from a specific position on the list.
         * @param i starting position of the iterator
         */
        public MyListIterator(int i){
            if (i<0 || i>size)
                throw new IndexOutOfBoundsException("Invalid Index"+i);
            lastItem = null;
            if (i==size){
                index=size;
                nextItem = null;
            }
            else{
                nextItem = head;
                for (index =0 ;index<i;index++){
                    nextItem = nextItem.next;
                }
            }

        }

        /***
         * Inserts the specified element into the list.
         * @param obj the element to insert
         */
        public void add(Character obj){
            if (head == null){
                head =new Node (obj);
                tail = head;
            }
            else if (nextItem == head){
                Node newNode= new Node (obj);
                newNode.next = nextItem;
                nextItem.prev=newNode;
                head = newNode;
            }
            else if (nextItem == null){
                Node newNode = new Node(obj);
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;

            }
            else{
                Node newNode = new Node (obj);
                newNode.prev = nextItem.prev;
                nextItem.prev.next = newNode;
                newNode.next = nextItem;
                nextItem.prev = newNode;
            }
            size++;
            index++;
            lastItem = null;
        }
        /***
         * Returns true if this list iterator has more elements when traversing the list in the forward direction.
         * @return true if the list iterator has more elements when traversing the list in the forward direction.
         */
        public boolean hasNext(){
            return nextItem!= null;
        }
        /***
         * Returns true if this list iterator has more elements when traversing the list in the reverse direction.
         * @return true if the list iterator has more elements when traversing the list in the reverse direction.
         */
        public boolean hasPrevious(){
            return  (nextItem == null && size!=0) || nextItem.prev !=null;
        }
        /***
         * Returns the next element in the list and advances the cursor position.
         * @return the next element in the list
         * @throws NoSuchElementException if the iteration has no next element
         */
        public Character next(){
            if (!hasNext ()){
                throw new NoSuchElementException ();
            }
            lastItem = nextItem;
            nextItem =nextItem.next;
            index++;
            return lastItem.data;
        }
        /***
         * Returns the index of the element that would be returned by a subsequent call to next().
         * @return the index of the element that would be returned by a subsequent call to next,
         * or list size if the list iterator is at the end of the list.
         */
        public int nextIndex(){
            return index+1;
        }
        /***
         * Returns  the previous element in the list and moves the cursor position backwards.
         * @return the previous element in the list.
         * @throws NoSuchElementException if the iteration has no previous element.
         */
        public Character previous(){
            if (!hasPrevious ())
                throw new NoSuchElementException ();
            if (nextItem == null)
                nextItem = tail;
            else
                nextItem = nextItem.prev;
            lastItem = nextItem;
            index--;
            return lastItem.data;
        }
        /***
         * Returns the index of the element that would be returned by a subsequent call to previous().
         * @return the index of the element that would be returned by a subsequent call to previous,
         * or -1 if the list iterator is at the beginning of the list.
         */
        public int previousIndex(){
            return index-1;
        }
        /***
         * Removes from the list the last element that was returned by next() or previous()
         * @throws NoSuchElementException if the list is empty
         */
        public void remove(){
            if (head == null){
                throw new NoSuchElementException ();
            }
            else if (head != null && head.next == null){
                nextItem = null;
                head = null;
                tail = null;
                size--;
                index--;
            }
            else if (nextItem.next == null){
                nextItem.prev.next = null;
                tail = nextItem.prev;
                size--;
                index--;
            }
            else if (nextItem.prev == null && nextItem.next !=null){
                nextItem.next.prev =null;
                head = nextItem.next;
                size--;
                index--;
            }
            else{
                nextItem.prev.next = nextItem.next;
                nextItem.next.prev = nextItem.prev;
                size--;
                index--;
            }
            lastItem = null;
        }
        /***
         * Replaces the last element(array) returned by next() or previous() with the specified element.
         * @param e the element with which to replace the last element returned by next or previous.
         * @throws IllegalStateException if neither next nor previous have been called,
         * or remove or add have been called after the last call to next or previous.
         */
        public void set(Character e){
            if (lastItem!=null){
                lastItem.data=e;
            }
            else{
                throw new IllegalStateException ();
            }
        }
    }

}
