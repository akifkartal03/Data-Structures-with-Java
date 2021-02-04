package com.Group1;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * This class is to make Cook operations in the system.
 */
public class ManageCook {
    /**
     * This field will be used when we make operations.
     * */
    private DataBase database; //we will use it when we make operations

    /**
     * One parameter constructor.
     * This class needs to Data object and Print Data object to make operations.
     * @param data all data regarding the system
     * */
    public ManageCook(DataBase data){
        this.database = data;
    }
    /**
     * This method manages the cook tasks
     * First it gets a choice from user and it makes that operation
     * @param cook cook that will be manage the system.
     * */
    public void manage(Personnel cook){
        int choose;
        do {
            showMenu (cook);
            choose = GetChoiceFromUser.getSubChoice (7,"Answer: ");
            switch(choose) {
                case 1:
                    addMenu();
                    break;
                case 2:
                    updateMenu();
                    break;
                case 3:
                    deleteMenu();
                    break;
                case 4:
                    database.deleteAllMenu ();
                    break;
                case 5:
                    database.printLastMenu ();
                    break;
                case 6:
                    database.ListMenu();
                    break;
                case 7:
                    checkMyTodo (cook);
                    break;
                default:
                    break;
            }

        }while (choose != 0);
    }

    /**
     * create new arraylist for enter meal.
     * enter day (monday, tuesday...)
     * After than create DailyFoodMenu with day and meals
     * add to linkedList in Database
     */
    private void addMenu(){
        ArrayList<String> menu = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        System.out.print("enter day : ");
        String day = scan.nextLine();

        System.out.print("enter meal name (Breakfast, lunch or dinner : ");
        String meal = scan.nextLine();

        System.out.print("enter add food or [0] for back : ");
        String choice = scan.nextLine();
        while (!choice.equals("0")){
            menu.add(choice);
            System.out.print("enter add food or [0] for back : ");
            choice = scan.nextLine();
        }
        DailyFoodMenu newMenu = new DailyFoodMenu(menu,day,meal);
        database.addMenu (newMenu);

    }

    /**
     * Delete menu specific day
     */
    private void deleteMenu(){
        ArrayList<String> menu = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        System.out.print("enter day : ");
        String day = scan.nextLine();

        int k;
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[1] Delete all day");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[2] delete just 1 meal press");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[0] Back ");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.print( "Answer: ");
        int choice = scan.nextInt();
        if (choice == 1){
            if(database.deleteMenu(day))
                System.out.println("Succesful!");
            else System.out.println("Failed!");
        }
        else if(choice == 2){
            System.out.print("enter meal name : ");
            scan.nextLine();
            String meal = scan.nextLine();

            if(database.deleteMenu(day,meal))
                System.out.println("Succesful!");
            else System.out.println("Failed!");
        }
    }

    /**
     * update menu in specific day.
     * enter first which day wanted change and
     * enter new menu.
     */
    private void updateMenu(){
        ArrayList<String> menu = new ArrayList<>();
        Scanner scan = new Scanner(System.in);

        System.out.print("enter day wanted to change : ");
        String day = scan.nextLine();

        System.out.print("enter meal name (Breakfast, lunch or dinner : ");
        String meal = scan.nextLine();

        System.out.print("enter add food or [0] for back : ");
        String choice = scan.nextLine();
        while (!choice.equals("0")){
            menu.add(choice);
            System.out.print("enter add food or [0] for back : ");
            choice = scan.nextLine();
        }
        DailyFoodMenu newMenu = new DailyFoodMenu(menu,day,meal);
        if(database.updateMenu(day,meal,newMenu))
            System.out.println("Succesful!");
        else System.out.println("Failed!");


    }
    private void showMenu(Personnel cook){
        int k;
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("Welcome Cook "+cook.name+" "+cook.surname);
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n");
        System.out.println("What Do you want to do ?");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[1] Add Daily Food Menu");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[2] Change Menu");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[3] Delete Menu");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[4] Delete All week");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[5] Print Last Menu");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[6] Print All Menu");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[7] Check My Todo");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n"+"   ");
        System.out.println("[0] Main Menu.");
        for ( k = 0; k < 45; k++) System.out.print("-");
        System.out.print("\n");
    }
    private void checkMyTodo(Personnel cook){
        if (database.checkTodo (cook.id)){
            System.out.println ("You have first todo!");
            System.out.println ("Job: "+database.getToDoFromTop ().getJob ());
            String ans = GetChoiceFromUser.getStringFromUser ("Did you do that(yes/no): ");
            if (ans.equalsIgnoreCase ("yes"))
                database.deleteToDoFromTop ();
        }
    }
}
