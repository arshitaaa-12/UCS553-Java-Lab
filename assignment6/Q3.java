package assignment6;
import java.io.*;

class Employee implements Serializable {
    int empId;
    String name;
    String department;
    double salary;

    Employee(int empId, String name, String department, double salary) {
        this.empId = empId;
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    void display() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Name: " + name);
        System.out.println("Department: " + department);
        System.out.println("Salary: " + salary);
        System.out.println();
    }
}

class Q3 {
    public static void main(String[] args) {

        Employee e1 = new Employee(101, "Rahul", "IT", 50000);
        Employee e2 = new Employee(102, "Priya", "HR", 45000);
        Employee e3 = new Employee(103, "Aman", "Finance", 55000);

        // Serialization
        try (ObjectOutputStream out = new ObjectOutputStream(
                new FileOutputStream("employee.dat"))) {

            out.writeObject(e1);
            out.writeObject(e2);
            out.writeObject(e3);

            System.out.println("Employee records saved successfully.");
        }
        catch (IOException e) {
            System.out.println("Serialization error: " + e.getMessage());
        }

        // Deserialization
        try (ObjectInputStream in = new ObjectInputStream(
                new FileInputStream("employee.dat"))) {

            System.out.println("\nEmployee Records:");

            Employee emp;

            for (int i = 0; i < 3; i++) {
                emp = (Employee) in.readObject();
                emp.display();
            }
        }
        catch (IOException | ClassNotFoundException e) {
            System.out.println("Deserialization error: " + e.getMessage());
        }
    }
}
