package coreJavaProjects;

class Employeeinfo{
    private int id;
    private String name;
    private String department;
    private String role;
    private double salary;

    public Employeeinfo(int id, String name, String department, String role, double salary) {
        this.id = id;
        this.name = name;
        this.department = department;
        this.role = role;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDepartment() {
        return department;
    }

    public String getRole() {
        return role;
    }

    public double getSalary() {
        return salary;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return String.format("%-5d %-20s %-15s %-15s %-10.2f", id, name, department, role, salary);
    }
}


