package com.Akif;

import java.util.*;

/**
 * This class keeps all data regarding the system in a data structure
 * that implement search tree interface.
 * It also operate the data.
 * We wrote this class for reusable purpose, we will use this operations later.
 * */
public class Data {
    //whole data
    /**
     * Information about the Software should be stored in any data structure implements search tree interface.
     */
    private SearchTree<Software> products;
    /**
     * This ArrayList keeps whole Administrator that are in the System.
     * */
    private ArrayList<Administrator> administratorMyArray;
    /**
     * This ArrayList keeps whole IDs that are Administrators have.
     * */
    private ArrayList<Integer> IDList ;
    /**
     * Money from selling.
     */
    private double money;
    /**
     * One parameter constructor to initialize fields.
     * It also determines the data structure.
     * @param dataStructure any data structure that implements the SearchTree Interface.
     * */
    public Data(SearchTree<Software> dataStructure){
        administratorMyArray = new ArrayList<>();
        IDList = new ArrayList<>();
        products = dataStructure;
        money=0.0;
    }
    /**
     * Adds a software to the System.
     * @param software new software to add.
     * */
    public void addSoftware(Software software){
        products.add (software);
    }

    /**
     * Remove a software from the System.
     * @param software name of book
     */
    public void removeSoftware(Software software){
        products.remove (software);
    }

    /**
     * Change old Software with new Software
     * @param oldSoftware a Software to update.
     * @param newSoftware a Software that is updated.
     */
    public void updateSoftware(Software oldSoftware,Software newSoftware){
        products.remove (oldSoftware);
        products.add (newSoftware);
    }

    /** Returns given software if it is in data structure.
     @param target The item being sought
     @return  given software if it is in data structure. If not found
     null is returned.
     */
    public Software getSoftware(Software target){
        return products.find (target);
    }

    /** Determine if an software is in the data.
     @param item Item being sought in tree
     @return true If the item is in the tree, false otherwise
     */
    public boolean contains(Software item){
        return products.contains (item);
    }
    /**
     * Add a new admin to the System.
     * @param administrator new administrator to add.
     * */
    public void addAdmin(Administrator administrator){
        administratorMyArray.add(administrator);
    }
    /***
     * Add given id in arraylist
     * @param id will be added.
     */
    public void addID(int id){
        IDList.add(id);
    }

    /***
     * This method checks given id is used or not ?
     * @param id will be checked
     * @return true if it is not used
     */
    public boolean IDUsed(int id){
        for (int i = 0 ; i< IDList.size();i++){
            if (IDList.get(i) == id){
                return true;
            }
        }
        return false;
    }

    /**
     * Returns number of admin from system.
     * @return number of admin from system.
     */
    public int numberOfAdmin(){
        return administratorMyArray.size();
    }

    /**
     * Return an admin at given index
     * @param index index of admin in ArrayList.
     * @return an admin at given index
     */
    public Administrator getAdmin(int index){
        return administratorMyArray.get(index);
    }

    /**
     * This method prints All data in the System in a good shape.
     * */
    public void printData () {
        System.out.println (products.toString ());
    }

    /**
     * Returns profit of all selling
     * @return profit of all selling
     */
    public double getMoney(){
        return money;
    }

    /**
     * Add new profit to total money
     * @param profit new profit to add total money
     */
    public void addMoney(double profit){
        money+=profit;
    }
}
