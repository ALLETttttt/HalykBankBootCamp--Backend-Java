package Collections;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class TaxOfficeFines {

    private static Map<Integer, List<Tax>> database = new HashMap<Integer, List<Tax>>();

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Полная распечатка базы данных");
            System.out.println("2. Распечатка данных по конкретному коду");
            System.out.println("3. Распечатка данных по конкретному типу штрафа");
            System.out.println("4. Распечатка данных по конкретному городу");
            System.out.println("5. Добавление нового человека с информацией о нем");
            System.out.println("6. Добавление новых штрафов для существующей записи");
            System.out.println("7. Удаление штрафа");
            System.out.println("8. Замена информации о человеке и его штрафах");
            System.out.println("9. Выход");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    showDatabase();
                    break;
                case 2:
                    showDataById();
                    break;
                case 3:
                    showDataByTypeOfFines();
                    break;
                case 4:
                    showDataByCity();
                    break;
                case 5:
                    addPersonWithInfo();
                    break;
                case 6:
                    updatePersonFines();
                    break;
                case 7:
                    deleteFines();
                    break;
                case 8:
                    changeInfo();
                    break;
                case 9:
                    System.out.println("Программа завершена.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void showDatabase() {

    }

    private static void showDataById() {

    }

    private static void showDataByTypeOfFines() {

    }

    private static void showDataByCity() {

    }

    private static void addPersonWithInfo() {

    }

    private static void updatePersonFines() {

    }

    private static void deleteFines() {

    }

    private static void changeInfo() {

    }
}
