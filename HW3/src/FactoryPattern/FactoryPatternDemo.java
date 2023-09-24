package FactoryPattern;

public class FactoryPatternDemo {
    public static void main(String[] args) {
        EmployeeFactory employeeFactory = new EmployeeFactory();

        Employee employee1 = employeeFactory.getEmployee("DEVELOPER");
        employee1.work();

        System.out.println();

        Employee employee2 = employeeFactory.getEmployee("ENGINEER");
        employee2.work();

        System.out.println();

        Employee employee3 = employeeFactory.getEmployee("MANAGER");
        employee3.work();
    }
}
