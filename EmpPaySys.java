import java.util.ArrayList;

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

  public int getId() { // getter method (Encapsulation)
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
  private double hourWorked;
  private double hourlyRate;

  public PartTimeEmp(String name, int id, double hourWrk, double hourlyRt) { // constructoe
    super(name, id);
    this.hourWorked = hourWrk;
    this.hourlyRate = hourlyRt;
  }

  @Override
  public double calculateSalary() {
    return hourWorked * hourlyRate;
  }
}

class PayrollSystem {

  // Syntax= ArrayList<Integer> arr = new ArrayList<>();
  private ArrayList<Employee> employeeList; // Array list declaration,Here Employee is an object (collectionframework)

  public PayrollSystem() { // constructor
    employeeList = new ArrayList<>(); // Array list initialisation
  }

  public void addEmployee(Employee emp) {
    employeeList.add(emp); // Here .add is used add value in the ArrayList(here, employeeList)
  }

  public void removeEmployee(int id) {// remove employee through his/her id
    Employee empRemove = null;
    for (Employee index : employeeList) {// for each loop
      if (index.getId() == id) {
        empRemove = index;
        break;
      }
    }
    if (empRemove != null) {
      employeeList.remove(empRemove);// Here .remove is used remove value in the ArrayList(here, employeeList)
    } else {
      System.out.println("Employee does not exits");
    }
  }

  public void displayEmployee() {// remove employee through his/her id
    for (Employee index : employeeList) {// for each loop
      System.out.println(index);
    }
  }
}

public class EmpPaySys {
  public static void main(String[] args) {
    PayrollSystem PRS = new PayrollSystem();

    FullTimeEmp Femp = new FullTimeEmp("Deepti", 1, 700000);
    PartTimeEmp Pemp = new PartTimeEmp("Raj", 2, 10, 500);

    PRS.addEmployee(Femp); // adding fulltimeemployee details
    PRS.addEmployee(Pemp); // adding parttimeemployee details

    System.out.println("\nInitial Employee Details");
    PRS.displayEmployee();

    System.out.println("\nAfter Removing Employee Detail wiith,Remaining Employee are");
    PRS.removeEmployee(1); // removing employee with id 1 (Deepti)
    PRS.displayEmployee();
  }
}

/*
 * import java.util.Scanner;
 * 
 * public class EmpPaySys {
 * public static void main(String[] args) {
 * PayrollSystem PRS = new PayrollSystem();
 * Scanner sc = new Scanner(System.in);
 * 
 * System.out.print("Enter the number of employees: ");
 * int n = sc.nextInt();
 * sc.nextLine(); // Consume newline
 * 
 * for (int i = 0; i < n; i++) {
 * System.out.println("\nEnter details for Employee " + (i + 1));
 * System.out.print("Enter Name: ");
 * String name = sc.nextLine();
 * 
 * System.out.print("Enter ID: ");
 * int id = sc.nextInt();
 * 
 * System.out.print("Enter Employee Type (1 for Full-Time, 2 for Part-Time): ");
 * int type = sc.nextInt();
 * 
 * if (type == 1) {
 * System.out.print("Enter Monthly Salary: ");
 * double monthlySalary = sc.nextDouble();
 * PRS.addEmployee(new FullTimeEmp(name, id, monthlySalary));
 * } else if (type == 2) {
 * System.out.print("Enter Hours Worked: ");
 * int hoursWorked = sc.nextInt();
 * System.out.print("Enter Hourly Rate: ");
 * double hourlyRate = sc.nextDouble();
 * PRS.addEmployee(new PartTimeEmp(name, id, hoursWorked,
 * hourlyRate));
 * } else {
 * System.out.println("Invalid Employee Type! Skipping entry...");
 * }
 * sc.nextLine(); // Consume newline after number input
 * }
 * 
 * sc.close();
 * 
 * System.out.println("\nAll Employee Details:");
 * PRS.displayEmployee();
 * }
 * }
 * 
 */




 