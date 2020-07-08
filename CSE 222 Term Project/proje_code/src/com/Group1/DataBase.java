package com.Group1;

import java.util.*;
import java.util.List;

/**
 * This class keeps all data regarding the system in an appropriate data structure.
 * It also operates the data.
 * We wrote this class for reusable purpose, we will use this operations later.
 * */
public class DataBase {
    //updated data structures
    private List<DailyFoodMenu> menuList ;
    private NavigableMap<Inmate, NavigableSet<Visitor>> visitorsMap;
    private PriorityQueue<ToDo> activeToDoQueue ;
    private List<ToDo> passiveToDo;//Todos that was done before
    private Queue<HealthAppointment> healthAppointmentsQueue ;
    private Stack<DailyInmateCensus> dailyInmateCensusStack ;
    private AVLTree<Inmate> prisonersTree ;
    private SkipList<Personnel> allPersonnel ;
    private GraphADT<Block> blockStructureGraph;
    private boolean fileFlag = false;
    private boolean alert = false;
    private ReadAndWriteFile readAndWriteFile;
    public DataBase(){
        menuList = new LinkedList<> ();
        visitorsMap = new TreeMap<> ();
        activeToDoQueue = new PriorityQueue<> ();
        passiveToDo = new ArrayList<> ();
        healthAppointmentsQueue = new LinkedList<> ();
        prisonersTree = new AVLTree<> ();
        allPersonnel = new SkipList<> ();
        readAndWriteFile = new ReadAndWriteFile (this);
        dailyInmateCensusStack = new Stack<> ();
        Block[] blocks = new Block[]{new Block ("A"),new Block ("B1"),new Block ("B2")};
        blockStructureGraph = new AdjacencyListMatrix<> (3,false,blocks);
    }
    public void openFlag(){fileFlag=true;}
    public void closeFlag(){fileFlag=false;}
    public void setAlert(){alert=true;}
    public void undoAlert(){alert=false;}
    public boolean getAlert(){return alert;}
    /**
     * controlling menu with day matching. if they matched warning
     * to user. Else add to linkedList.
     * @param menu added menu.
     */
    public void addMenu(DailyFoodMenu menu){
        if (!menuList.isEmpty ()&&findMenu(menu.getDate(),menu.getMeal()) != -1)
            System.out.println("This day added before. Check Again!");

        else{
            menuList.add (menu);
            if (fileFlag)
                readAndWriteFile.writeFoodMenu (menu);
        }

    }

    /**
     * deleted menu from taking day
     * @param day wanted delete day
     * @return true if deleted
     */
    public boolean deleteMenu(String day){
        int index =findMenu (day);
        if (index!=-1){
            while (index != -1){
                readAndWriteFile.deleteFoodMenu (menuList.remove (index));
                index = findMenu(day);
            }
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * delete specific meal in a day
     * @param day day
     * @param meal name of meal
     * @return true if deleted
     */
    public boolean deleteMenu(String day,String meal){
        int index =findMenu (day,meal);
        if (index!=-1){
            readAndWriteFile.deleteFoodMenu (menuList.remove (index));
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * clear menu list
     */
    public void deleteAllMenu(){
        menuList.clear();
        readAndWriteFile.deleteAllMenu ();
    }

    /**
     * update a meal
     * @param day day
     * @param meal meal name
     * @param newMenu new addeed menu
     * @return true if changed
     */
    public boolean updateMenu(String day,String meal,DailyFoodMenu newMenu){
        int index = findMenu (day,meal);
        if (index!=-1){
            menuList.set (index,newMenu);
            readAndWriteFile.updateFoodMenu (menuList.get (index),newMenu);
            return true;
        }
        else {
            return false;
        }
    }

    /**
     * get menu
     * @param index index
     * @return menu
     */
    public DailyFoodMenu getMenu(int index){
        if (index<0 || index>menuList.size ()-1)
            throw new ArrayIndexOutOfBoundsException();
        return menuList.get (index);
    }

    /**
     *
     * list menu in specific day
     * @param day food menu.
     * @param meal name of meal
     */
    public void ListMenu(String day,String meal){
        int index = 0;
        for (DailyFoodMenu temp : menuList){
            if (day.equalsIgnoreCase(temp.getDate()) && meal.equalsIgnoreCase(temp.getMeal())){
                System.out.println(temp.toString());
            }
        }
    }

    /**
     * find a menu in day
     * @param day day
     * @return index if true
     */
    private int findMenu(String day){
        int i = 0;
        for (DailyFoodMenu temp : menuList){
            if (day.equalsIgnoreCase(temp.getDate())){
                return i;
            }
            i++;
        }
        return -1;
    }
    public void ListMenu(){
        for (DailyFoodMenu temp : menuList){
            System.out.println(temp.toString());
        }
    }
    public void printLastMenu(){
        if (menuList.isEmpty ())
            System.out.println ("No menu is available!");
        else
            System.out.println (menuList.get (menuList.size ()-1));
    }

    /**
     * find a meal in a day
     * @param day day
     * @param meal name of meal
     * @return index if true
     */
    private int findMenu(String day, String meal){
        int i = 0;
        for (DailyFoodMenu temp : menuList){
            if (day.equalsIgnoreCase(temp.getDate()) && meal.equalsIgnoreCase(temp.getMeal())){
                return i;
            }
            i++;
        }
        return -1;
    }
    public NavigableSet<Visitor> getVisitorSet(Inmate inmate){
        return visitorsMap.get (inmate);
    }
    public void setVisitorSet(Inmate inmate ,NavigableSet<Visitor> visitorSet,Visitor visitor){
        visitorsMap.replace (inmate,visitorSet);
    }
    public void addVisitor(Inmate prisoner,NavigableSet<Visitor> visitorSet){
        visitorsMap.put (prisoner,visitorSet);

    }
    public void addOneVisitor(Inmate inmate, Visitor visitor){
        NavigableSet<Visitor> visitors = visitorsMap.get (inmate);
        if (visitors==null){
            NavigableSet<Visitor> v = new TreeSet<> ();
            v.add (visitor);
            addVisitor (inmate,v);
        }
        else{
            visitors.add (visitor);
            visitorsMap.replace (inmate,visitors);
        }
        if (fileFlag)
            readAndWriteFile.writeVisitor (visitor);

    }
    public boolean deleteVisitor(Inmate prisoner,Visitor visitor){
        boolean removed = false;
        NavigableSet<Visitor> values = visitorsMap.get (prisoner);
        if (values.contains (visitor)){
            removed = values.remove (visitor);
            readAndWriteFile.deleteVisitor (visitor);
        }
        return removed;
    }
    public Visitor getVisitorWithTC(String TC){
        Collection<NavigableSet<Visitor>> values = visitorsMap.values ();
        for (Set<Visitor> visitorSet : values) {
            for (Visitor visitor:visitorSet) {
                if (visitor.tcNumber.equals (TC)){
                    return visitor;
                }
            }
        }
        return null;
    }
    public Visitor getVisitorWithTC(Inmate prisoner,String TC){
        NavigableSet<Visitor> values = visitorsMap.get (prisoner);
        for (Visitor visitor:values) {
            if (visitor.tcNumber.equals (TC)){
                return visitor;
            }
        }
        return null;
    }
    //no update for queue
    public void addToDoToTheTop(ToDo job){
        activeToDoQueue.offer (job);
        if (fileFlag)
            readAndWriteFile.writeTodo (job);
    }
    public ToDo deleteToDoFromTop(){
        if (activeToDoQueue.isEmpty ())
            return null;
        passiveToDo.add (activeToDoQueue.peek ());
        readAndWriteFile.deleteTodo (activeToDoQueue.peek ());
        return activeToDoQueue.poll ();
    }
    public boolean deleteTodo(String todo){
        for (ToDo toDo : activeToDoQueue) {
            if (toDo.getJob ().equals (todo)){
                activeToDoQueue.remove (toDo);
                readAndWriteFile.deleteTodo (toDo);
                return true;
            }
        }
        return false;
    }
    public boolean updateTodo(String oldJob,ToDo newTodo){
        for (ToDo toDo : activeToDoQueue) {
            if (toDo.getJob ().equals (oldJob)){
                activeToDoQueue.remove (toDo);
                readAndWriteFile.deleteTodo (toDo);
                activeToDoQueue.add (newTodo);
                readAndWriteFile.writeTodo (newTodo);
                return true;
            }
        }
        return false;
    }
    public ToDo getToDoFromTop(){
        if (activeToDoQueue.isEmpty ())
            return null;
        return activeToDoQueue.peek ();
    }
    public boolean checkTodo(int persID){
        if (!activeToDoQueue.isEmpty ()){
            return activeToDoQueue.peek ().getOwnerID () == persID;
        }
        return false;
    }
    public int toDoSize(){
        return activeToDoQueue.size ();
    }

    /**
     * Returns true if the personnel has most importance job.
     * @param personnelId personnel id of personnel
     * @return true if the personnel has most importance job.
     */
    public boolean personnelTodo(int personnelId){
        if (!activeToDoQueue.isEmpty ()){
            if (activeToDoQueue.peek ().getOwnerID () == personnelId){
                return true;
            }
        }
        return false;
    }
    public boolean addUrgentTodo(ToDo urgentTodo){
        if (!activeToDoQueue.isEmpty ()){
            urgentTodo.setImportanceOrder (activeToDoQueue.peek ().getImportanceOrder ()-1);
        }
        readAndWriteFile.writeTodo (urgentTodo);
        return activeToDoQueue.add (urgentTodo);
    }
    public void addHealthAppointmentToTheTop(HealthAppointment appointment){
        healthAppointmentsQueue.offer (appointment);
        if (fileFlag)
            readAndWriteFile.writeHealthAppointments (appointment);
    }
    public HealthAppointment deleteHealthAppointmentFromTop(){
        if (healthAppointmentsQueue.isEmpty ())
            return null;
        readAndWriteFile.deleteHealthAppointments (healthAppointmentsQueue.peek ());
        return healthAppointmentsQueue.poll ();
    }
    public HealthAppointment getHealthAppointment(){
        if (healthAppointmentsQueue.isEmpty ())
            return null;
        return healthAppointmentsQueue.peek ();
    }
    public boolean addInmate(Inmate inmate){
        if (prisonersTree.add (inmate)){
            if (fileFlag)
                readAndWriteFile.writeInmate (inmate);
            return true;
        }
        return false;
    }
    public Inmate deleteInmate(Inmate inmate ){
        if (prisonersTree.delete (inmate)!=null){
            readAndWriteFile.deleteInmate (inmate);
            return inmate;
        }
       return null;
    }
    public boolean updateInmate(Inmate oldInmate, Inmate newInmate){
        boolean rv=false;
        prisonersTree.delete (oldInmate);
        rv=prisonersTree.add (newInmate);
        if (rv)
            readAndWriteFile.updateInmate (oldInmate,newInmate);
        return rv;

    }

    public Inmate getInmate(int inmateID){
        return prisonersTree.find (new Inmate (inmateID));
    }
    public int getInmateSize(){
        return prisonersTree.getSize ();
    }
    public boolean addPersonnel(Personnel personnel){
        if (fileFlag)
            readAndWriteFile.writePersonnel (personnel);
        return allPersonnel.add (personnel);

    }
    public Personnel deletePersonnel(Personnel personnel ){
        readAndWriteFile.deletePersonnel (personnel);
        return allPersonnel.delete (personnel);
    }
    public boolean updatePersonnel(Personnel oldPersonnel, Personnel newPersonnel){
        allPersonnel.delete (oldPersonnel);
        readAndWriteFile.updatePersonnel (oldPersonnel,newPersonnel);
        return allPersonnel.add (newPersonnel);
    }
    public int numberOfPersonnel(){
        return allPersonnel.size ();
    }
    public Personnel getPersonnel(int id){
        return allPersonnel.find (new Personnel (id));
    }
    public Personnel checkPassword(int ID,String pass){
        Personnel temp = allPersonnel.find (new Personnel (ID));
        if (temp!=null){
            if (temp.password.equals (pass))
                return temp;
        }
        return null;
    }

    /***
     * This method checks given id is used or not ?
     * @param id will be checked
     * @return true if it is not used
     */
    public boolean IDUsed(int id){
        return getPersonnel (id) != null;
    }
    public void addInmateCensus(int numberOfInmate,String date){
        dailyInmateCensusStack.push (new DailyInmateCensus (numberOfInmate,date));
    }
    public DailyInmateCensus getLastInmateCensus(){
        if (!dailyInmateCensusStack.isEmpty ())
            return dailyInmateCensusStack.peek ();
        return null;
    }
    public void deleteLastCensus(){
        if (!dailyInmateCensusStack.isEmpty ())
            dailyInmateCensusStack.pop ();
    }
    public void createGraph(String blockName,ArrayList<Integer> wards, ArrayList<String> otherRooms){
        blockStructureGraph.setVertex (new Block (blockName),new Block (blockName,wards,otherRooms));
    }
    //------------Printing-----------------------------------------------------------------
    public void printAllData(){
        System.out.println ("***All Data is in the system***");
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
        printAllHealthAppointments ();
        printAllMenus ();
        printAllPersonnel ();
        printAllVisitor ();
        printAllActiveToDos ();
        printAllPrisoners ();
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
    }
    public void printAllMenus(){
        Stack<DailyFoodMenu> dailyFoodMenuStack = new Stack<> ();
        System.out.println ("***All Menu in the system***");
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
        for (DailyFoodMenu menu:menuList) {
            dailyFoodMenuStack.push (menu);
        }
        while (!dailyFoodMenuStack.empty ())
            System.out.println (dailyFoodMenuStack.pop ());
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();

    }
    public void printAllVisitor(){
        System.out.println ("***All Visitors in the system***");
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
        Set<Inmate> inmates = visitorsMap.keySet ();
        Collection<NavigableSet<Visitor>> values = visitorsMap.values ();
        Iterator<NavigableSet<Visitor>> iter =values.iterator ();
        int j=0;
        System.out.println ("Inmates and Visitors:");
        for (Inmate inmate:inmates) {
            System.out.printf("[%d] %s\n",j+1,inmate.getName ());
            System.out.println ("\tVisitors:");
            j++;
            if (iter.hasNext ()){
                Set<Visitor> visitorSet = iter.next ();
                int i=0;
                for (Visitor visitor:visitorSet) {
                    System.out.printf("\t[%d] %s\n",i+1,visitor.toString ());
                    i++;
                }
            }
            else{
                break;
            }

        }
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
    }
    public void printAllActiveToDos(){
        System.out.println ("***All ToDos in the system***");
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
        for (ToDo toDo : activeToDoQueue) {
            System.out.println (toDo);
        }
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
    }
    public void printAllHealthAppointments(){
        System.out.println ("***All Health Appointments in the system***");
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
        for (HealthAppointment appointment:healthAppointmentsQueue) {
            System.out.println (appointment);
        }
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
    }
    public void printAllPrisoners(){
        System.out.println ("***All Prisoners in the system***");
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
        System.out.println (prisonersTree);
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
    }
    public void printAllPersonnel(){
        System.out.println ("***All Personnel in the system***");
        System.out.println (allPersonnel);
    }
    public void printAllPassiveToDo(){
        System.out.println ("***All Passive ToDos in the system***");
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
        System.out.println ("Passive ToDos");
        for (ToDo toDo:passiveToDo) {
            System.out.println (toDo);
        }
        for (int k = 0; k < 60; k++) System.out.print("-");
        System.out.println ();
    }
    public void printPrison(){
        Object[] blocks = blockStructureGraph.dfs ();
        for (Object block : blocks) {
            System.out.println (block);
        }
    }

}
