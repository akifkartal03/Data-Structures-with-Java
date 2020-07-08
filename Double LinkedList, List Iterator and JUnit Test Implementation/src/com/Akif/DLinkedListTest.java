package com.Akif;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
public class DLinkedListTest {
    private DLinkedList<Integer> numbers;
    @Before
    public void setUp() {
        numbers = new DLinkedList<> ();
        for (int i= 0;i<10;i++){
            numbers.add (i,i*2);
        }
    }
    @Test
    public void getFirst () {
        Assert.assertEquals ((Integer)0,numbers.getFirst ());
    }
    @Test
    public void add () {
        numbers.add (8, 5);
    }
    @Test
    public void addFirst () {
        numbers.addFirst (20);
    }
    @Test
    public void addLast () {
        numbers.addLast (50);
    }
    @Test
    public void get () {
        Assert.assertEquals ((Integer)10,numbers.get (5));
    }
    @Test
    public void getLast () {
        Assert.assertEquals ((Integer)18,numbers.getLast ());
    }
    @Test
    public void remove () {
        Assert.assertEquals (true,numbers.remove (4));
    }
    @Test
    public void size () {
        Assert.assertEquals (10,numbers.size ());
    }

}