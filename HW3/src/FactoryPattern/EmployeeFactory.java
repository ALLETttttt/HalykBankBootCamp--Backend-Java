package FactoryPattern;

public class EmployeeFactory {
    public Employee getEmployee(String employeeType) {
        if(employeeType == null) {
            return null;
        }
        else if(employeeType.equalsIgnoreCase("DEVELOPER")) {
            return new Developer();
        }
        else if(employeeType.equalsIgnoreCase("ENGINEER")) {
            return new Engineer();
        }
        else if(employeeType.equalsIgnoreCase("MANAGER")) {
            return new Manager();
        }
        return null;
    }
}
