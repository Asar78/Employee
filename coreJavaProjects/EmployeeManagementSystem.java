package coreJavaProjects;

import java.util.*;
import java.util.stream.Collectors;

public class EmployeeManagementSystem {
    private static Map<Integer, Employeeinfo> employees = new HashMap<>();
    private static int employeeIdCounter = 1;

    static {
        employees.put(employeeIdCounter, new Employeeinfo(employeeIdCounter++, "Asarudeen", "IT", "Developer", 60000));
        employees.put(employeeIdCounter, new Employeeinfo(employeeIdCounter++, "Naveen", "HR", "Manager", 75000));
        employees.put(employeeIdCounter, new Employeeinfo(employeeIdCounter++, "Bharat", "Finance", "Accountant", 55000));
        employees.put(employeeIdCounter, new Employeeinfo(employeeIdCounter++, "Ashok", "Marketing", "Executive", 50000));
        employees.put(employeeIdCounter, new Employeeinfo(employeeIdCounter++, "Anand", "IT", "System Admin", 65000));
    }

    public static void addEmployee(String name, String department, String role, double salary) {
        Employeeinfo employee = new Employeeinfo(employeeIdCounter++, name, department, role, salary);
        employees.put(employee.getId(), employee);
        System.out.println("Employee added successfully: " + employee);
    }

    public static void updateEmployee(int id, String department, String role, double salary) {
        Employeeinfo employee = employees.get(id);
        if (employee != null) {
            employee.setDepartment(department);
            employee.setRole(role);
            employee.setSalary(salary);
            System.out.println("Employee updated successfully: " + employee);
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public static void removeEmployee(int id) {
        if (employees.remove(id) != null) {
            System.out.println("Employee with ID " + id + " removed successfully.");
        } else {
            System.out.println("Employee with ID " + id + " not found.");
        }
    }

    public static void listEmployees() {
        if (employees.isEmpty()) {
            System.out.println("No employees to display.");
        } else {
            System.out.println("\n=== Employee List ===");
            System.out.printf("%-5s %-20s %-15s %-15s %-10s%n", "ID", "Name", "Department", "Role", "Salary");
            System.out.println("---------------------------------------------------------------");
            employees.values().forEach(System.out::println);
        }
    }

    public static void filterEmployeesByDepartment(String department) {
        System.out.println("\n=== Employees in Department: " + department + " ===");
        System.out.printf("%-5s %-20s %-15s %-15s %-10s%n", "ID", "Name", "Department", "Role", "Salary");
        System.out.println("---------------------------------------------------------------");
        employees.values().stream()
                .filter(emp -> emp.getDepartment().equalsIgnoreCase(department))
                .forEach(System.out::println);
    }

    public static void filterEmployeesBySalaryRange(double minSalary, double maxSalary) {
        System.out.println("\n=== Employees with Salary Between " + minSalary + " and " + maxSalary + " ===");
        System.out.printf("%-5s %-20s %-15s %-15s %-10s%n", "ID", "Name", "Department", "Role", "Salary");
        System.out.println("---------------------------------------------------------------");
        employees.values().stream()
                .filter(emp -> emp.getSalary() >= minSalary && emp.getSalary() <= maxSalary)
                .forEach(System.out::println);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n=== Employee Management System Menu ===");
            System.out.println("1. Add Employee");
            System.out.println("2. Update Employee");
            System.out.println("3. Remove Employee");
            System.out.println("4. List All Employees");
            System.out.println("5. Filter Employees by Department");
            System.out.println("6. Filter Employees by Salary Range");
            System.out.println("7. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    scanner.nextLine(); 
                    String name = scanner.nextLine();
                    System.out.print("Enter Department: ");
                    String department = scanner.nextLine();
                    System.out.print("Enter Role: ");
                    String role = scanner.nextLine();
                    System.out.print("Enter Salary: ");
                    double salary = scanner.nextDouble();
                    addEmployee(name, department, role, salary);
                    break;
                case 2:
                    System.out.print("Enter Employee ID to Update: ");
                    int id = scanner.nextInt();
                    System.out.print("Enter New Department: ");
                    scanner.nextLine(); 
                    department = scanner.nextLine();
                    System.out.print("Enter New Role: ");
                    role = scanner.nextLine();
                    System.out.print("Enter New Salary: ");
                    salary = scanner.nextDouble();
                    updateEmployee(id, department, role, salary);
                    break;
                case 3:
                    System.out.print("Enter Employee ID to Remove: ");
                    id = scanner.nextInt();
                    removeEmployee(id);
                    break;
                case 4:
                    listEmployees();
                    break;
                case 5:
                    System.out.print("Enter Department to Filter: ");
                    scanner.nextLine(); 
                    department = scanner.nextLine();
                    filterEmployeesByDepartment(department);
                    break;
                case 6:
                    System.out.print("Enter Minimum Salary: ");
                    double minSalary = scanner.nextDouble();
                    System.out.print("Enter Maximum Salary: ");
                    double maxSalary = scanner.nextDouble();
                    filterEmployeesBySalaryRange(minSalary, maxSalary);
                    break;
                case 7:
                    System.out.println("Exiting the system. Thank you!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);

        scanner.close();
    }
}
