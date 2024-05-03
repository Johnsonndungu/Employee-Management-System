import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(
                new Employee("John", 35, "HR", 50000),
                new Employee("Alice", 28, "IT", 60000),
                new Employee("Bob", 40, "Finance", 70000),
                new Employee("Emily", 32, "Marketing", 55000)
        );

        // Using streams to generate concatenated strings of name and department
        List<String> nameAndDeptList = employees.stream()
                .map(EmployeeProcessor::getNameAndDepartment)
                .collect(Collectors.toList());

        System.out.println("Concatenated Name and Department:");
        nameAndDeptList.forEach(System.out::println);

        // Finding the average salary of all employees
        double averageSalary = EmployeeProcessor.calculateAverageSalary(employees);
        System.out.println("\nAverage Salary of all Employees: " + averageSalary);

        // Filter employees based on age threshold (e.g., 30)
        int ageThreshold = 30;
        List<Employee> filteredEmployees = EmployeeProcessor.filterByAge(employees, ageThreshold);

        System.out.println("\nEmployees above " + ageThreshold + " years old:");
        filteredEmployees.forEach(emp -> System.out.println(emp.getName()));
    }
}

Employee.java

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private int age;
    private String department;
    private double salary;

    public Employee(String name, int age, String department, double salary) {
        this.name = name;
        this.age = age;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getDepartment() {
        return department;
    }

    public double getSalary() {
        return salary;
    }
}

class EmployeeProcessor {
    // Function to concatenate employee name and department
    public static String getNameAndDepartment(Employee employee) {
        return employee.getName() + " - " + employee.getDepartment();
    }

    // Function to filter employees based on age threshold
    public static List<Employee> filterByAge(List<Employee> employees, int ageThreshold) {
        return employees.stream()
                .filter(emp -> emp.getAge() > ageThreshold)
                .collect(Collectors.toList());
    }

    // Function to calculate average salary of employees
    public static double calculateAverageSalary(List<Employee> employees) {
        return employees.stream()
                .mapToDouble(Employee::getSalary)
                .average()
                .orElse(0);
    }
}
