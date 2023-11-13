/*
Задание 3
Реализовать базу данных налоговой инспекции по штрафам. Идентифицировать конкретного человека будет его
персональный идентификационный код. У одного человека
может быть много штрафов.
Реализовать:
1. Полная распечатка базы данных;
2. Распечатка данных по конкретному коду;
3. Распечатка данных по конкретному типу штрафа;
4. Распечатка данных по конкретному городу;
5. Добавление нового человека с информацией о нем;
6. Добавление новых штрафов для существующей записи;
7. Удаление штрафа;
8. Замена информации о человеке и его штрафах.
 */


package Collections;

import java.util.*;

public class TaxOfficeFines {

    private static Map<Integer, Person> database = new HashMap<Integer, Person>();

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
                    showDataByTypeOfPenalties();
                    break;
                case 4:
                    showDataByCity();
                    break;
                case 5:
                    addPersonWithInfo();
                    break;
                case 6:
                    addPersonPenalties();
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
        database.entrySet().forEach(System.out::println);
    }

    private static void showDataById() {
        System.out.println("Введите идентификатор:");
        Integer code = Integer.valueOf(getUserInput());

        if (database.containsKey(code)) {
            System.out.println(database.get(code));
            System.out.println("Распечатка данных по конкретному коду выполнена.");
        } else {
            System.out.println("Введенный данные не существуют в системе.");
        }
    }

    private static void showDataByTypeOfPenalties() {
        System.out.println("Введите тип штрафа:");
        String typeOfPenalties = getUserInput();

        database.entrySet()
                .stream()
                .filter(entry -> entry.getValue()
                        .getTypeOfPenalties()
                        .equals(typeOfPenalties))
                .forEach(System.out::println);

        System.out.println("Распечатка данных по конкретному типу штрафа выполнена.");
    }

    private static void showDataByCity() {
        System.out.println("Введите город:");
        String city = getUserInput();

        database.entrySet()
                .stream()
                .filter(entry -> entry.getValue().getCity().equals(city))
                .forEach(System.out::println);

        System.out.println("Распечатка данных по конкретному городу выполнена.");
    }

    private static void addPersonWithInfo() {
        System.out.println("Введите идентификатор:");
        Integer code = Integer.valueOf(getUserInput());

        System.out.println("Введите имя человека:");
        String name = getUserInput();

        System.out.println("Введите город:");
        String city = getUserInput();

        System.out.println("Введите тип штрафа:");
        String typeOfPenalties = getUserInput();

        System.out.println("Введите штраф:");
        String penalty = getUserInput();

        List<String> penalties = new ArrayList<String>();
        penalties.add(penalty);

        Person person = new Person();
        person.setName(name);
        person.setCity(city);
        person.setTypeOfPenalties(typeOfPenalties);
        person.setPenalties(penalties);

        database.put(code, person);
        System.out.println("Операция добавление нового человека с информацией о нем прошла успешно.");
    }

    private static void addPersonPenalties() {
        System.out.println("Введите идентификатор:");
        Integer code = Integer.valueOf(getUserInput());

        if (database.containsKey(code)) {
            System.out.println("Введите штраф:");
            String penalty = getUserInput();
            database.entrySet()
                    .stream()
                    .filter(entry -> entry.getValue().getPenalties().add(penalty))
                    .forEach(System.out::println);
            System.out.println("Добавление новых штрафов для существующей записи выполнена.");
        } else {
            System.out.println("Введенные данные не существуют.");
        }
    }

    private static void deleteFines() {
        System.out.println("Введите идентификатор:");
        Integer code = Integer.valueOf(getUserInput());

        if (database.containsKey(code)) {
            database.remove(code);
            System.out.println("Удаление штрафа выполнена.");
        } else {
            System.out.println("Введенные данные не существуют.");
        }
    }

    private static void changeInfo() {
        System.out.println("Введите идентификатор:");
        Integer code = Integer.valueOf(getUserInput());

        if (database.containsKey(code)) {

            System.out.println("Введите имя человека:");
            String name = getUserInput();

            System.out.println("Введите город:");
            String city = getUserInput();

            System.out.println("Введите тип штрафа:");
            String typeOfPenalties = getUserInput();

            System.out.println("Введите штраф:");
            String penalty = getUserInput();

            List<String> penalties = new ArrayList<String>();
            penalties.add(penalty);

            Person personData = database.get(code);
            personData.setName(name);
            personData.setCity(city);
            personData.setTypeOfPenalties(typeOfPenalties);
            personData.setPenalties(penalties);

            System.out.println("Замена информации о человеке и его штрафах выполнена.");

        } else {
            System.out.println("Введенные данные не существуют.");
        }
    }

    private static String getUserInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine().trim();
    }
}