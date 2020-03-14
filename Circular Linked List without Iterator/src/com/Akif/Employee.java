package com.Akif;

/***
 * This class keeps information about an employee.
 */
public class Employee extends Person{
    private int salary;
    public Employee () {
        super();
        this.salary =0;
    }
    public Employee (int salary) {
        super();
        this.salary = salary;
    }
    public Employee (int ID, String firstName, String lastName, int age, int salary) {
        super (ID, firstName, lastName, age);
        this.salary = salary;
    }

    public int getSalary () {
        return salary;
    }
    public void setSalary (int salary) {
        this.salary = salary;
    }
    @Override
    public String toString () {
        return "Person{" +
                "ID=" + getID () +
                ", firstName='" + getFirstName () + '\'' +
                ", lastName='" + getLastName () + '\'' +
                ", age=" + getAge () +
                ", salary=" + getSalary () +
                '}';
    }
    @Override
    public boolean equals (Object obj) {
        if (this == obj){
            return true;
        }
        if (obj == null){
            return false;
        }
        if (!(obj instanceof Employee)){
            return  false;
        }
        Employee emp= (Employee)obj;
        return this.getFirstName ().equals (emp.getFirstName ()) && this.getLastName ().equals (emp.getLastName ())
                && this.getSalary () == emp.getSalary () && this.getAge () ==emp.getAge () && this.getID () == emp.getID ();

    }
}
