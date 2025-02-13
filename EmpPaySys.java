abstract class Employee { // data abstraction // Employee class
  private String name; // Access Specifiers
  private int id;

  public Employee(String nm, int d) { // paramete constructor
    this.name = nm;
    this.id = d;
  }

  public String getName() { // getter method (Encapsulation)
    return name;
  }

  public int getid() { // getter method (Encapsulation)
    return id;
  }

  public abstract double calculateSalary(); // abstract method (Encapsulation)

  @Override // polymorphism
  public String toString() { // display
    return "Employee [Name=" + name + ", Id=" + id + ", Salary=" + calculateSalary() + "]";
  }
}

class FullTimeEmp extends Employee { // FullTimeEmp Subclass
  private double monthlySal;

  public FullTimeEmp(String name, int id, double montthlySalary) { // constructor
    super(name, id); // super keyword to access parent class constructor
    this.monthlySal = montthlySalary;
  }

  @Override
  public double calculateSalary() {
    return monthlySal;

  }
}

class PartTimeEmp extends Employee { // PartTimeEmp Subclass
  private int hourWorked;
  private double hourlyRate;

  public PartTimeEmp(String name, int id, int hourWrk, int hourlyRt) { // constructoe
    super(name, id);
    this.hourWorked = hourWrk;
    this.hourlyRate = hourlyRt;
  }

  @Override
  public double calculateSalary() {
    return hourWorked * hourlyRate;
  }
}


class PayrollSystem{
  
}
public class EmpPaySys {
  public static void main(String[] args) {

  }
}
