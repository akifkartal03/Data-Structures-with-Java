package com.Akif;

/***
 * This class test all available methods of the Linked List.
 */
public class Main {

    public static void main(String[] args) {
        Employee janeJones = new Employee(48,"Jane", "Jones", 23,555);
        Employee johnDoe = new Employee(5,"John", "Doe", 45,6589);
        Employee marySmith = new Employee(22,"Mary", "Smith", 20,8796);
        Employee mikeWilson = new Employee(95,"Mike", "Wilson", 32,2058);

        MyLinkedList list = new MyLinkedList ();

        list.addFirst (janeJones);
        list.addFirst (johnDoe);
        list.addFirst (marySmith);
        list.addFirst (mikeWilson);
        System.out.println (list.toString ());
        System.out.println("Size: "+list.size());

        Employee billEnd = new Employee(3,"Bill", "End", 78,6302);
        Employee mid = new Employee(3,"Joe", "Silver", 37,4296);
        list.addLast (billEnd);
        list.add (3,mid);
        System.out.println (list.toString ());
        System.out.println("Size: "+list.size());
        list.remove (johnDoe);
        list.addBefore(new Employee(45,"Someone", "Else", 11,0), mikeWilson);
        System.out.println (list.toString ());
        System.out.println("Size: "+list.size());

    }
}
