package com.Group1;

import java.util.ArrayList;
import java.util.NoSuchElementException;

/**
 * Food menu in the prison
 */
public class DailyFoodMenu {
    //every food in the menu will be added to the list one by one.
    private ArrayList<String> menu;
    // Date change as a String. Because java.util.Date giving all time.
    // In this part thinking daily food as weekly food. Week's days.
    private String date; //date is id of menu at that data there can be just one menu.
    private String meal; //name of meal (breakfast, lunch or dinner

    /**
     *
     * @param menu all foods
     * @param date date
     * @param meal name of meal (breakfast, lunch or dinner
     */
    public DailyFoodMenu(ArrayList<String> menu,String date,String meal) {
        this.menu = menu;
        this.date = date;
        this.meal = meal;
    }

    public ArrayList<String> getAllMenu () {
        return menu;
    }

    public String getDate () {
        return date;
    }
    public String getMeal () {
        return meal;
    }

    public void setDate (String date) {
        this.date = date;
    }

    public ArrayList<String> getMenu (String date) {
        if (this.date.equals (date)){
            return menu;
        }
        else
            throw new NoSuchElementException ();
    }


    @Override
    public String toString () {
       StringBuilder stringBuilder = new StringBuilder ();
        stringBuilder.append(date +" - " +  meal + "\n");
        for (String s : menu) {
            stringBuilder.append (s);
            stringBuilder.append ("\n");
        }
       return stringBuilder.toString ();
    }
}

