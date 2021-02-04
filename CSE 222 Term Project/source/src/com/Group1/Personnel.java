package com.Group1;
enum JobType {
    Administrator,
    Governor,
    ChiefJailer,
    Jailer,
    Doctor,
    Cook,
    Undefined
}

/**
 * This class holds the personnel information
 */
public class Personnel implements Comparable<Personnel> {
    protected String name;
    protected String surname;
    protected int id;
    protected JobType job;
    protected HealthStatus healthStatus;
    protected String password;

    //mesai saati
    protected PersonnelShift shift;
    protected WorkPlace place;

     public Personnel(int id){
        this(id, "NoInfo", "NoInfo", "", JobType.Undefined, new HealthStatus(), new PersonnelShift(),new WorkPlace ());
    }

    public Personnel(int id , String password){
        this(id, "Noinfo", "Noinfo", password, JobType.Undefined, new HealthStatus (), new PersonnelShift(),new WorkPlace());
    }

    public Personnel(int id,String name, String surname, String password, JobType job){
        this(id, name, surname, password, job, new HealthStatus(), new PersonnelShift(),new WorkPlace ());
    }

    public Personnel(int id, String name, String surname, String password, JobType job,
                     HealthStatus health, PersonnelShift shift, WorkPlace place) {
         this.name = name;
         this.surname = surname;
         this.id = id;
         this.job = job;
         healthStatus = health;
         this.password = password;
         this.shift = shift;
         this.place = place;
    }
    public Personnel(int id, String name, String surname, String password, JobType job,
                     HealthStatus health, PersonnelShift shift) {
        this.name = name;
        this.surname = surname;
        this.id = id;
        this.job = job;
        healthStatus = health;
        this.password = password;
        this.shift = shift;
        this.place = new WorkPlace ();
    }

    public String getName () {
        return name;
    }

    public void setName (String name) {
        this.name = name;
    }

    public String getSurname () {
        return surname;
    }

    public void setSurname (String surname) {
        this.surname = surname;
    }

    public int getId () {
        return id;
    }

    public void setId (int id) {
        this.id = id;
    }

    public JobType getJob () {
        return job;
    }

    public void setJob (JobType job) {
        this.job = job;
    }

    public HealthStatus getHealthStatus () {
        return healthStatus;
    }

    public void setHealthStatus (HealthStatus healthStatus) {
        this.healthStatus = healthStatus;
    }

    public String getPassword () {
        return password;
    }

    public void setPassword (String password) {
        this.password = password;
    }

    public PersonnelShift getShift () {
        return shift;
    }

    public void setShift (PersonnelShift shift) {
        this.shift = shift;
    }

    public WorkPlace getPlace () {
        return place;
    }

    public void setPlace (WorkPlace place) {
        this.place = place;
    }

    @Override
    public int compareTo (Personnel o) {
        if (this.id == o.id )
            return 0;
        else if (this.id < o.id)
            return -1;
        else
            return 1;
    }

    @Override
    public String toString () {
         int k;
        StringBuilder stringBuilder = new StringBuilder ();
        for ( k = 0; k < 45; k++) stringBuilder.append ("-");
        stringBuilder.append ("\n");
        stringBuilder.append ("Personnel{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", id=" + id +
                ", job=" + job +
                '}');
        stringBuilder.append ("\n");
        stringBuilder.append ("\nHealth Information" +
                "\nLength = " + healthStatus.getHeight () + '\'' +
                "\nWeight = " + healthStatus.getWeight () + '\'' +
                "\nBlood Group = " + healthStatus.getBloodGroup () +
                "\nPulse = " + healthStatus.getPulse () +
                "\nLast Report : " + healthStatus.getLastControlResult ());

        stringBuilder.append ("\n\n");
        stringBuilder.append (shift.toString ());
        stringBuilder.append ("\n");
        stringBuilder.append (place.toString ());
        for ( k = 0; k < 45; k++) stringBuilder.append ("-");
        stringBuilder.append ("\n");
        return stringBuilder.toString ();

    }
}
