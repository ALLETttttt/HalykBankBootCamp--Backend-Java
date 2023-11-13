package Practice;


import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;

public class CorporationSystem {

    private static final ArrayList<Employee> employees = new ArrayList<>();
    public static void main(String[] args) {

        loadEmployeesFromFile();

        while (true) {
            System.out.println("\n===== Корпорация: Информационная Система =====");
            System.out.println("1. Ввод данных о сотруднике");
            System.out.println("2. Редактирование данных сотрудника");
            System.out.println("3. Удаление сотрудника");
            System.out.println("4. Поиск сотрудника по фамилии");
            System.out.println("5. Вывод информации о сотрудниках указанного возраста или фамилия начинается на букву");
            System.out.println("6. Сохранить данные в файл и выйти");

            int choice = Integer.parseInt(getUserInput());

            switch (choice) {
                case 1:
                    addEmployee();
                    break;
                case 2:
                    editEmployee();
                    break;
                case 3:
                    deleteEmployee();
                    break;
                case 4:
                    searchByLastName();
                    break;
                case 5:
                    filterAndDisplay();
                    break;
                case 6:
                    saveEmployeesToFile();
                    System.exit(0);
                default:
                    System.out.println("Неверный выбор. Пожалуйста, повторите.");
            }
        }
    }

    private static void loadEmployeesFromFile() {
        System.out.println("Введите путь к файлу:");
        String path = getUserInput();

        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                String[] data = line.split(" ");
                Employee employee = new Employee(data[0], data[1], Integer.parseInt(data[2]));
                employees.add(employee);
            }
            for (Employee e: employees) {
                System.out.println(e);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void addEmployee() {
        System.out.println("Введите данные о сотруднике:");
        System.out.print("Имя: ");
        String firstName = getUserInput();
        System.out.print("Фамилия: ");
        String lastName = getUserInput();
        System.out.print("Возраст: ");
        int age = Integer.parseInt(getUserInput());
        employees.add(new Employee(firstName, lastName, age));
        System.out.println("Сотрудник добавлен успешно.");
    }

    private static void editEmployee() {
        System.out.print("Введите фамилию сотрудника для редактирования: ");
        String lastName = getUserInput();
        for (Employee employee : employees) {
            if (employee.lastName.equalsIgnoreCase(lastName)) {
                System.out.println("Найден сотрудник: " + employee);
                System.out.println("Введите новые данные:");
                System.out.print("Имя: ");
                employee.firstName = getUserInput();
                System.out.print("Фамилия: ");
                employee.lastName = getUserInput();
                System.out.print("Возраст: ");
                employee.age = Integer.parseInt(getUserInput());
                System.out.println("Данные успешно отредактированы.");
                return;
            }
        }
        System.out.println("Сотрудник с фамилией " + lastName + " не найден.");
    }

    private static void deleteEmployee() {
        System.out.print("Введите фамилию сотрудника для удаления: ");
        String lastName = getUserInput();
        employees.removeIf(employee -> employee.lastName.equalsIgnoreCase(lastName));
        System.out.println("Сотрудник успешно удален.");
    }

    private static void searchByLastName() {
        System.out.print("Введите фамилию для поиска: ");
        String lastName = getUserInput();
        for (Employee employee : employees) {
            if (employee.lastName.equalsIgnoreCase(lastName)) {
                System.out.println("Найден сотрудник: " + employee);
                return;
            }
        }
        System.out.println("Сотрудник с фамилией " + lastName + " не найден.");
    }

    private static void filterAndDisplay() {
        System.out.print("Введите возраст или первую букву фамилии для фильтрации: ");
        String filter = getUserInput();
        for (Employee employee : employees) {
            if (String.valueOf(employee.age).equals(filter) || employee.lastName.startsWith(filter)) {
                System.out.println(employee);
                return;
            }
        }
        System.out.println("Сотрудник не найден.");
    }

    private static void saveEmployeesToFile() {
        System.out.println("Введите путь к файлу:");
        String path = getUserInput();
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (Employee e: employees) {
                writer.write(e.firstName + " " + e.lastName + " " + e.age);
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getUserInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine().trim();
    }
}
