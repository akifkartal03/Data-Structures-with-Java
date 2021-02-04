package com.Group1;

import java.io.*;
import java.util.*;

/**
 * Class to fill all data from files and manage them .
 * It is like database.
 */
public class ReadAndWriteFile {
    private DataBase dataBase;
    private File blocksFile,foodMenuFile,healthAppointmentsFile,inmatesFile,personelFile,todosFile,visitorsFile,workplaceFile;
    private FileWriter blocks,foodMenu,healthAppointments,inmates,personel,todos,visitors,workplace;
    private BufferedReader blocksR,foodMenuR,healthAppointmentsR,inmatesR,personelR,todosR,visitorsR,workplaceR;
    public ReadAndWriteFile(DataBase dataBase){
        this.dataBase = dataBase;
        createFiles ();
    }
    /**
     * This methods fills all data from files.
     */
    public void fill(){

        try {
            openFilesToRead ();
            fillBlocks ();
            fillFoodMenu ();
            fillHealthApp ();
            fillInmates ();
            fillPersonnel ();
            fillVisitors ();
            fillTodos ();
            closeReadFiles ();
        }catch (Exception e){
           e.printStackTrace ();
        }
    }
    public void writeFoodMenu(DailyFoodMenu menu){
        try {
            foodMenu = new FileWriter (foodMenuFile,true);
            foodMenu.write (menu.getDate ()+","+menu.getMeal ()+",");
            for (String food:menu.getAllMenu ()) {
                foodMenu.write (food+",");
            }
            foodMenu.write (System.lineSeparator ());
            foodMenu.close ();
        }catch (IOException e){
            e.printStackTrace ();
        }
    }
    public void writePersonnel(Personnel personnel){
        try {
            personel = new FileWriter (personelFile,true);
            personel.write (personnel.id+","+personnel.name+","+personnel.surname+","+Encryption.encryptPassword (personnel.password)
                    +","+personnel.job+ ","+personnel.healthStatus.getBloodGroup ()+","+personnel.healthStatus.getLastControlResult ()
                    +","+personnel.healthStatus.getHeight ()+
                    ","+personnel.healthStatus.getWeight ()+","+personnel.healthStatus.getPulse ()+","+personnel.shift.shift+",");
            ArrayList<Days> days = personnel.shift.workdays;
            for (int i = 0; i < days.size (); i++) {
                if (i!=days.size ()-1)
                    personel.write (days.get (i)+",");
                else
                    personel.write (days.get (i)+System.lineSeparator ());
            }
            workplace = new FileWriter (workplaceFile,true);
            workplace.write (personnel.getPlace ().block+","+personnel.getPlace ().floor+System.lineSeparator ());
            workplace.close ();
            personel.close ();
        }catch (IOException e){
            e.printStackTrace ();
        }
    }
    public void writeHealthAppointments(HealthAppointment healthAppointment){
        try {
            healthAppointments = new FileWriter (healthAppointmentsFile,true);
            healthAppointments.write (healthAppointment.getApID ()+","+healthAppointment.getDate ()+","+
                    healthAppointment.getOwnerID ()+","+ healthAppointment.getExplanation ()+","
                    +healthAppointment.getHealthStatus ().getBloodGroup ()+","+healthAppointment.getHealthStatus ().getLastControlResult ()
                    +","+healthAppointment.getHealthStatus ().getHeight ()+
                    ","+healthAppointment.getHealthStatus ().getWeight ()+","+healthAppointment.getHealthStatus ().getPulse ()+System.lineSeparator ());
            healthAppointments.close ();
        }catch (IOException e){
            e.printStackTrace ();
        }
    }
    public void writeInmate(Inmate inmate){
        try {
            inmates = new FileWriter (inmatesFile,true);

            inmates.write (inmate.getId ()+","+inmate.getName ()+","+inmate.getCrimeType ()+inmate.getExitTime ()+
                    inmate.getWardNo ()+","+inmate.getHealthStatus ().getBloodGroup ()+","+inmate.getHealthStatus ().getHeight ()+
                    ","+inmate.getHealthStatus ().getWeight ()+","+inmate.getHealthStatus ().getPulse ()+System.lineSeparator ());
            inmates.close ();
        }catch (IOException e){
           e.printStackTrace ();
        }
    }
    public void writeBlocks(/*Block parameter*/){
        try {
            blocks = new FileWriter (blocksFile,true);
            //write block to the file
            blocks.close ();
        }catch (IOException e){
            e.printStackTrace ();
        }
    }
    public void writeTodo(ToDo toDo){
        try {
            todos = new FileWriter (todosFile,true);
            todos.write (toDo.getId ()+","+toDo.getJob ()+","+toDo.getOwnerID ()+System.lineSeparator ());
            todos.close ();
        }catch (IOException e){
           e.printStackTrace ();
        }
    }
    public void writeVisitor(Visitor visitor){
        try {
            visitors = new FileWriter (visitorsFile,true);
            visitors.write (visitor.name+","+visitor.surname+","+visitor.tcNumber+","+visitor.inmateNumber
                    +","+visitor.telephoneNumber+","+visitor.date+","+visitor.entranceTime+","+visitor.exitTime+","+System.lineSeparator ());
            visitors.close ();
        }catch (IOException e){
            e.printStackTrace ();
        }
    }
    private void createFiles(){
        blocksFile = new File ("blocks.txt");
        foodMenuFile = new File ("foodmenu.txt");
        healthAppointmentsFile = new File ("healthAppointments.txt");
        inmatesFile = new File ("inmates.txt");
        personelFile = new File ("personel.txt");
        todosFile = new File ("todos.txt");
        visitorsFile = new File ("visitors.txt");
        workplaceFile = new File("workPlace.txt");
    }
    private void openFilesToRead(){
        try {
            blocksR = new BufferedReader (new FileReader (blocksFile));
            foodMenuR = new BufferedReader (new FileReader (foodMenuFile));
            healthAppointmentsR = new BufferedReader (new FileReader (healthAppointmentsFile));
            inmatesR = new BufferedReader (new FileReader (inmatesFile));
            personelR = new BufferedReader (new FileReader (personelFile));
            todosR = new BufferedReader (new FileReader (todosFile));
            visitorsR = new BufferedReader (new FileReader (visitorsFile));
            workplaceR = new BufferedReader (new FileReader (workplaceFile));

        }catch (IOException e){
            e.printStackTrace ();
        }
    }
    private void closeReadFiles(){
        try {
            blocksR.close ();
            foodMenuR.close ();
            healthAppointmentsR.close ();
            inmatesR.close ();
            personelR.close ();
            todosR.close ();
            visitorsR.close ();
            workplaceR.close ();

        }catch (IOException e){
            e.printStackTrace ();
        }
    }
    private void fillPersonnel(){
        try {
            Personnel personnel;
            String line,line2;
            while ((line = personelR.readLine()) != null && (line2 = workplaceR.readLine ())!=null) {
                String[] information = line.split (",");
                ArrayList<Days> days =new ArrayList<> ();
                for (int i = 11; i < information.length; i++) {
                    days.add (Days.valueOf (information[i]));
                }
                personnel = new Personnel (Integer.parseInt (information[0]), information[1], information[2],
                        Encryption.decryptPassword (information[3]),JobType.valueOf (information[4]),
                        new HealthStatus (information[5],information[6], Double.parseDouble (information[7]),
                                Double.parseDouble (information[8]), Double.parseDouble (information[9])),
                        new PersonnelShift (Shifts.valueOf (information[10]),days));
                String[] in =line2.split (",");
                personnel.setPlace (new WorkPlace (in[0],Integer.parseInt (in[1])));
                dataBase.addPersonnel (personnel);
            }
        }catch (IOException e){
            e.printStackTrace ();
        }

    }
    private void fillFoodMenu(){
        try {
            DailyFoodMenu newMenu ;
            String line;
            while ((line = foodMenuR.readLine()) != null) {
                String[] information = line.split(",");
                String day = information[0];
                String meal = information[1];
                ArrayList<String> menu =new ArrayList<> ();
                for (int i = 2; i < information.length; i++) {
                    menu.add (information[i]);
                }
                newMenu =new DailyFoodMenu (menu,day,meal);
                dataBase.addMenu(newMenu);
            }

        }catch (IOException e){
            e.printStackTrace ();
        }
    }
    private void fillHealthApp(){
        try {
            HealthAppointment newHealthApp;
            String line;
            while ((line = healthAppointmentsR.readLine()) != null) {
                String[] information = line.split(",");
                newHealthApp = new HealthAppointment (Integer.parseInt (information[0]),information[1],
                        Integer.parseInt (information[2]),information[3],new HealthStatus (information[4],information[5],
                        Double.parseDouble (information[6]), Double.parseDouble (information[7]), Double.parseDouble (information[8])));
                dataBase.addHealthAppointmentToTheTop (newHealthApp);
            }

        }catch (IOException e){
            e.printStackTrace ();
        }
    }
    private void fillInmates(){
        try {
            Inmate inmate;
            String line;
            while ((line = inmatesR.readLine()) != null) {
                String[] information = line.split(",");
                inmate =new Inmate (Integer.parseInt (information[0]),information[1],CrimeType.valueOf (information[2]),
                        information[3],Integer.parseInt (information[4]),
                        new HealthStatus (information[5],information[6], Double.parseDouble (information[7]),
                                Double.parseDouble (information[8]), Double.parseDouble (information[9])));
                dataBase.addInmate (inmate);
            }
        }catch (IOException e){
            e.printStackTrace ();
        }
    }
    private void fillBlocks(){
        try {
            String line;
            while ((line = blocksR.readLine()) != null) {
                String[] information = line.split(",");
                ArrayList<Integer> wards = new ArrayList<> ();
                String[] w = information[1].split (";");
                for (String wr:w) {
                    wards.add (Integer.parseInt (wr));
                }
                ArrayList<String> rooms = new ArrayList<> ();
                String[] r = information[2].split (";");
                Collections.addAll (rooms, r);
                dataBase.createGraph (information[0],wards,rooms);
            }

        }catch (IOException e){
            e.printStackTrace ();
        }
    }
    private void fillTodos(){
        try {
            ToDo toDo ;
            String line;
            while ((line = todosR.readLine()) != null) {
                String[] information = line.split(",");
                toDo = new ToDo (Integer.parseInt (information[0]),information[1],Integer.parseInt (information[2]));
                dataBase.addToDoToTheTop (toDo);
            }

        }catch (IOException e){
            e.printStackTrace ();
        }
    }
    private void fillVisitors(){
        try {
            Visitor visitor;
            String line;
            while ((line = visitorsR.readLine()) != null) {
                String[] information = line.split(",");
                visitor =new Visitor (information[0],information[1],information[2],Integer.parseInt (information[3]),
                        information[4],information[5], information[6]);
                visitor.setExitTime (information[7]);
                Inmate inmate = dataBase.getInmate (Integer.parseInt (information[3]));
               dataBase.addOneVisitor (inmate,visitor);
            }

        }catch (IOException e){
            e.printStackTrace ();
        }
    }
    public void updatePersonnel(Personnel old,Personnel newP){
        try {
            personelR = new BufferedReader (new FileReader (personelFile));
            workplaceR = new BufferedReader (new FileReader (workplaceFile));
            StringBuilder writer = new StringBuilder();
            StringBuilder writer2 = new StringBuilder();
            String line,line2;
            while ((line = personelR.readLine()) != null && (line2 = workplaceR.readLine ())!=null) {
                String[] information = line.split(",");
                if (Integer.parseInt (information[0]) == old.id){
                    writer.append (newP.id+","+newP.name+","+newP.surname+","+Encryption.encryptPassword (newP.password)+","+newP.job+
                            ","+newP.healthStatus.getBloodGroup ()+","+newP.healthStatus.getHeight ()+
                            ","+newP.healthStatus.getWeight ()+","+newP.healthStatus.getPulse ()+","+
                            newP.shift.shift+",");
                    for (Days day:newP.shift.workdays) {
                        writer.append (day+",");
                    }
                    writer.append (System.lineSeparator ());
                    writer2.append (newP.getPlace ().block+","+newP.getPlace ().floor);
                }
                else {
                    writer.append (line+System.lineSeparator ());
                    writer2.append (line2+System.lineSeparator ());
                }
            }
            FileWriter  fileWriter = new FileWriter (personelFile);
            fileWriter.write (writer.toString ());
            FileWriter  fileWriter2 = new FileWriter (workplaceFile);
            fileWriter2.write (writer2.toString ());
            workplaceR.close ();
            personelR.close ();
            fileWriter.close ();
            fileWriter2.close ();
        }catch (IOException e){
            e.printStackTrace ();
        }
    }
    public void updateFoodMenu(DailyFoodMenu old,DailyFoodMenu newM){
        try {
            foodMenuR = new BufferedReader (new FileReader (foodMenuFile));
            StringBuilder writer = new StringBuilder();
            String line;
            while ((line = foodMenuR.readLine()) != null) {
                String[] information = line.split(",");
                if (information[0].equals (old.getDate ())){
                    writer.append (newM.getDate ()+","+newM.getMeal ()+",");
                    for (String food:newM.getAllMenu ()) {
                        writer.append (food+",");
                    }
                    writer.append (System.lineSeparator ());
                }
                else {
                    writer.append (line+System.lineSeparator ());
                }
            }
            FileWriter  fileWriter = new FileWriter (foodMenuFile);
            fileWriter.write (writer.toString ());
            foodMenuR.close ();
            fileWriter.close ();
        }catch (IOException e){
            e.printStackTrace ();
        }
    }
    public void updateHealthAppointments(HealthAppointment oldHealApp,HealthAppointment newHealthAppointment){
        try {
            healthAppointmentsR = new BufferedReader (new FileReader (healthAppointmentsFile));
            StringBuilder writer = new StringBuilder();
            String line;
            while ((line = healthAppointmentsR.readLine()) != null) {
                String[] information = line.split(",");
                if (Integer.parseInt (information[0])==oldHealApp.getApID ()){
                    writer.append (newHealthAppointment.getApID ()+","+newHealthAppointment.getDate ()+","+
                            newHealthAppointment.getOwnerID ()+","+newHealthAppointment.getExplanation ()+System.lineSeparator ());
                }
                else {
                    writer.append (line+System.lineSeparator ());
                }
            }
            FileWriter  fileWriter = new FileWriter (healthAppointmentsFile);
            fileWriter.write (writer.toString ());
            healthAppointmentsR.close ();
            fileWriter.close ();
        }catch (IOException e){
            e.printStackTrace ();
        }
    }
    public void updateInmate(Inmate oldInmate,Inmate newInmate){
        try {
            inmatesR = new BufferedReader (new FileReader (inmatesFile));
            StringBuilder writer = new StringBuilder();
            String line;
            while ((line = inmatesR.readLine()) != null) {
                String[] information = line.split(",");
                if (Integer.parseInt (information[0])==oldInmate.getId ()){
                    writer.append (newInmate.getId ()+","+newInmate.getName ()+","+newInmate.getCrimeType ()+newInmate.getExitTime ()+
                            newInmate.getWardNo ()+","+newInmate.getHealthStatus ().getBloodGroup ()+","+newInmate.getHealthStatus ().getLastControlResult ()+
                            ","+newInmate.getHealthStatus ().getHeight ()+","+newInmate.getHealthStatus ().getWeight ()+","+
                            newInmate.getHealthStatus ().getPulse ()+System.lineSeparator ());
                }
                else {
                    writer.append (line+System.lineSeparator ());
                }
            }
            FileWriter  fileWriter = new FileWriter (inmatesFile);
            fileWriter.write (writer.toString ());
            inmatesR.close ();
            fileWriter.close ();
        }catch (IOException e){
            e.printStackTrace ();
        }
    }
    public void updateBlocks(/*Block parameter*/){
        try {
            blocksR = new BufferedReader (new FileReader (blocksFile));
            StringBuilder writer = new StringBuilder();
            //write block to the file
            blocksR.close ();
        }catch (IOException e){
            e.printStackTrace ();
        }
    }
    public void updateTodo(ToDo oldToDo,ToDo newTodo){
        try {
            todosR = new BufferedReader (new FileReader (todosFile));
            StringBuilder writer = new StringBuilder();
            String line;
            while ((line = todosR.readLine()) != null) {
                String[] information = line.split(",");
                if (Integer.parseInt (information[0])==oldToDo.getId ()){
                    writer.append (newTodo.getId ()+","+newTodo.getJob ()+","+newTodo.getOwnerID ()+System.lineSeparator ());
                }
                else {
                    writer.append (line+System.lineSeparator ());
                }
            }
            FileWriter  fileWriter = new FileWriter (todosFile);
            fileWriter.write (writer.toString ());
            todosR.close ();
            fileWriter.close ();
        }catch (IOException e){
            e.printStackTrace ();
        }
    }
    public void updateVisitor(Visitor oldVisitor,Visitor newVisitor){
        try {
            visitorsR = new BufferedReader (new FileReader (visitorsFile));
            StringBuilder writer = new StringBuilder();
            String line;
            while ((line = visitorsR.readLine()) != null) {
                String[] information = line.split(",");
                if (information[2].equals (oldVisitor.tcNumber)){
                    writer.append (newVisitor.name+","+newVisitor.surname+","+newVisitor.tcNumber+","+newVisitor.inmateNumber
                            +","+newVisitor.telephoneNumber+","+newVisitor.date+","+newVisitor.entranceTime+System.lineSeparator ());
                }
                else {
                    writer.append (line+System.lineSeparator ());
                }
            }
            FileWriter  fileWriter = new FileWriter (visitorsFile);
            fileWriter.write (writer.toString ());
            visitorsR.close ();
            fileWriter.close ();
        }catch (IOException e){
            e.printStackTrace ();
        }
    }
    public void deletePersonnel(Personnel old){
        try {
            workplaceR = new BufferedReader (new FileReader (workplaceFile));
            StringBuilder writer2 = new StringBuilder();
            personelR = new BufferedReader (new FileReader (personelFile));
            StringBuilder writer = new StringBuilder();
            String line,line2;
            while ((line = personelR.readLine()) != null && (line2 = workplaceR.readLine ())!=null) {
                String[] information = line.split(",");
                if (Integer.parseInt (information[0]) != old.id){
                    writer.append (line+System.lineSeparator ());
                    writer2.append (line2+System.lineSeparator ());
                }
            }
            FileWriter  fileWriter = new FileWriter (personelFile);
            fileWriter.write (writer.toString ());
            FileWriter  fileWriter2 = new FileWriter (workplaceFile);
            fileWriter2.write (writer2.toString ());
            personelR.close ();
            workplaceR.close ();
            fileWriter.close ();
            fileWriter2.close ();
        }catch (IOException e){
            e.printStackTrace ();
        }
    }
    public void deleteFoodMenu(DailyFoodMenu old){
        try {
            foodMenuR = new BufferedReader (new FileReader (foodMenuFile));
            StringBuilder writer = new StringBuilder();
            String line;
            while ((line = foodMenuR.readLine()) != null) {
                String[] information = line.split(",");
                if (!information[0].equals (old.getDate ())){
                    writer.append (line+System.lineSeparator ());
                }
            }
            FileWriter  fileWriter = new FileWriter (foodMenuFile);
            fileWriter.write (writer.toString ());
            foodMenuR.close ();
            fileWriter.close ();
        }catch (IOException e){
            e.printStackTrace ();
        }
    }
    public void deleteHealthAppointments(HealthAppointment oldHealApp){
        try {
            healthAppointmentsR = new BufferedReader (new FileReader (healthAppointmentsFile));
            StringBuilder writer = new StringBuilder();
            String line;
            while ((line = healthAppointmentsR.readLine()) != null) {
                String[] information = line.split(",");
                if (Integer.parseInt (information[0])!=oldHealApp.getApID ()){
                    writer.append (line+System.lineSeparator ());
                }
            }
            FileWriter  fileWriter = new FileWriter (healthAppointmentsFile);
            fileWriter.write (writer.toString ());
            healthAppointmentsR.close ();
            fileWriter.close ();
        }catch (IOException e){
            e.printStackTrace ();
        }
    }
    public void deleteInmate(Inmate oldInmate){
        try {
            inmatesR = new BufferedReader (new FileReader (inmatesFile));
            StringBuilder writer = new StringBuilder();
            String line;
            while ((line = inmatesR.readLine()) != null) {
                String[] information = line.split(",");
                if (Integer.parseInt (information[0])!=oldInmate.getId ()){
                    writer.append (line+System.lineSeparator ());
                }
            }
            FileWriter  fileWriter = new FileWriter (inmatesFile);
            fileWriter.write (writer.toString ());
            inmatesR.close ();
            fileWriter.close ();
        }catch (IOException e){
            e.printStackTrace ();
        }
    }
    public void deleteBlocks(/*Block parameter*/){
        try {
            blocksR = new BufferedReader (new FileReader (blocksFile));
            StringBuilder writer = new StringBuilder();
            //write block to the file
            blocksR.close ();
        }catch (IOException e){
            e.printStackTrace ();
        }
    }
    public void deleteTodo(ToDo oldToDo){
        try {
            todosR = new BufferedReader (new FileReader (todosFile));
            StringBuilder writer = new StringBuilder();
            String line;
            while ((line = todosR.readLine()) != null) {
                String[] information = line.split(",");
                if (Integer.parseInt (information[0])!=oldToDo.getId ()){
                    writer.append (line+System.lineSeparator ());
                }
            }
            FileWriter  fileWriter = new FileWriter (todosFile);
            fileWriter.write (writer.toString ());
            todosR.close ();
            fileWriter.close ();
        }catch (IOException e){
            e.printStackTrace ();
        }
    }
    public void deleteVisitor(Visitor oldVisitor){
        try {
            visitorsR = new BufferedReader (new FileReader (visitorsFile));
            StringBuilder writer = new StringBuilder();
            String line;
            while ((line = visitorsR.readLine()) != null) {
                String[] information = line.split(",");
                if (!information[2].equals (oldVisitor.tcNumber)){
                    writer.append (line+System.lineSeparator ());
                }
            }
            FileWriter  fileWriter = new FileWriter (visitorsFile);
            fileWriter.write (writer.toString ());
            visitorsR.close ();
            fileWriter.close ();
        }catch (IOException e){
            e.printStackTrace ();
        }
    }
    public void deleteAllMenu(){
        try {
            foodMenu = new FileWriter (foodMenuFile);
            foodMenu.close ();
        }catch (IOException e){
            e.printStackTrace ();
        }

    }
}
