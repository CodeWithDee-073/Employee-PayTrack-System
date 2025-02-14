import java.util.ArrayList;
import java.util.Scanner;

//Abstract Employee class (Abstraction)
abstract class Employee {
  private String name;
  private int id;

  public Employee(String name, int id) { //Parameterized Constructor
    this.name = name;
    this.id = id;
  }

  public String getName() { //Getter Method(Encapsulation)
    return name;
  }

  public int getId() { //Getter Method(Encapsulation)
    return id;
  }

  public abstract double calculateSalary(); //Abstract Method(Encapsulation)

  @Override
  public String toString() { //Polymorphism(Method Overriding)
    return "[Employee Name = " + name + ", Id = " + id + ", Salary = " + calculateSalary() + "]";
  }
}

//Full-Time Employee's Subclass
class FullTimeEmp extends Employee {
  private double monthlySalary;

  public FullTimeEmp(String name, int id, double monthlySalary) {
    super(name, id);
    this.monthlySalary = monthlySalary;
  }

  @Override
  public double calculateSalary() {
    return monthlySalary;
  }
}

//Part-Time Employee's Subclass
class PartTimeEmp extends Employee {
  private double hoursWorked;
  private double hourlyRate;

  public PartTimeEmp(String name, int id, double hoursWorked, double hourlyRate) {
    super(name, id);
    this.hoursWorked = hoursWorked;
    this.hourlyRate = hourlyRate;
  }

  @Override
  public double calculateSalary() {
    return hoursWorked * hourlyRate;
  }
}

//Payroll System for Managing Employees
class PayrollSystem {
  private ArrayList<Employee> employeeList;

  public PayrollSystem() {
    employeeList = new ArrayList<>();
  }

  public void addEmployee(Employee emp) {
    employeeList.add(emp);
  }

  public void removeEmployee(int id) {
    Employee empRemove = null;
    for (Employee emp : employeeList) {
      if (emp.getId() == id) {
        empRemove = emp;
        break;
      }
    }
    if (empRemove != null) {
      employeeList.remove(empRemove);
      System.out.println("Employee with ID " + id + " removed successfully.");
    } else {
      System.out.println("Employee does not exist.");
    }
  }

  public void displayEmployees() {
    if (employeeList.isEmpty()) {
      System.out.println("No employees to display.");
    } else {
      for (Employee emp : employeeList) {
        System.out.println(emp);
      }
    }
  }
}

// Main Class
public class EmpPaySys {
  public static void main(String[] args) {
    PayrollSystem PRS = new PayrollSystem();
    Scanner sc = new Scanner(System.in);

    System.out.print("Enter the number of employees: ");
    int n = sc.nextInt();
    sc.nextLine(); //newline

    for (int i = 0; i < n; i++) {
      System.out.println("\nEnter details for Employee " + (i + 1));
      System.out.print("Enter Name: ");
      String name = sc.nextLine();

      System.out.print("Enter ID: ");
      int id = sc.nextInt();

      System.out.print("Enter Employee Type (1 for Full-Time, 2 for Part-Time): ");
      int type = sc.nextInt();

      if (type == 1) {
        System.out.print("Enter Monthly Salary: ");
        double monthlySalary = sc.nextDouble();
        PRS.addEmployee(new FullTimeEmp(name, id, monthlySalary));
      } 
      else if (type == 2) {
        System.out.print("Enter Hours Worked: ");
        double hoursWorked = sc.nextDouble();
        System.out.print("Enter Hourly Rate: ");
        double hourlyRate = sc.nextDouble();
        PRS.addEmployee(new PartTimeEmp(name, id, hoursWorked, hourlyRate));
      } 
      else {
        System.out.println("Invalid Employee Type! Skipping entry...");
      }
      sc.nextLine(); //newline
    }

    System.out.println("\nAll Employee Details:");
    PRS.displayEmployees();

    System.out.print("\nEnter Employee ID to remove: ");
    int removeId = sc.nextInt();
    PRS.removeEmployee(removeId);

    System.out.println("\nRemaining Employees:");
    PRS.displayEmployees();

    sc.close(); 
  }
}
