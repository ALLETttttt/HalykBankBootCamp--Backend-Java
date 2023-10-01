package Ass_2;

import java.util.Scanner;

public class ex_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите дату рождения (день месяц год): ");
        int day = scanner.nextInt();
        String month = scanner.next();
        int year = scanner.nextInt();

        String zodiacSign = determineZodiacSign(day, month);
        String japaneseYear = determineJapaneseYear(year);

        System.out.println("Знак: " + zodiacSign);
        System.out.println("Год: " + japaneseYear);
    }

    public static String determineZodiacSign(int day, String month) {
        String[] zodiacSigns = {
                "Козерог", "Водолей", "Рыбы", "Овен", "Телец", "Близнецы",
                "Рак", "Лев", "Дева", "Весы", "Скорпион", "Стрелец"
        };

        String[] months = {
                "января", "февраля", "марта", "апреля", "мая", "июня",
                "июля", "августа", "сентября", "октября", "ноября", "декабря"
        };

        int monthIndex = 0;
        for (int i = 0; i < months.length; i++) {
            if (month.equals(months[i])) {
                monthIndex = i;
                break;
            }
        }

        return zodiacSigns[monthIndex];
    }

    public static String determineJapaneseYear(int year) {
        String[] japaneseYears = {
                "Крыса", "Бык", "Тигр", "Кролик", "Дракон", "Змея",
                "Лошадь", "Коза", "Обезьяна", "Петух", "Собака", "Свинья"
        };

        int offset = 1900;
        int yearIndex = (year - offset) % 12;

        return japaneseYears[yearIndex];
    }
}
