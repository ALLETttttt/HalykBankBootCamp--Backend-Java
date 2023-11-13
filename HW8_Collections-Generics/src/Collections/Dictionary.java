/*
Задание 2
Создать программу по работе со словарем. Например,
англо-испанский или французско-немецкий, или любое
другое направление. Программа должна:
■ Обеспечивать начальный ввод данных для словаря;
■ Позволять отобразить слово и его переводы;
■ Позволять добавить, заменить, удалить переводы слова;
■ Позволять добавить, заменить, удалить слово;
■ Отображать топ-10 самых популярных слов (определяем популярность на основании счетчика обращений);
■ Отображать топ-10 самых непопулярных слов (определяем непопулярность на основании счетчика обращений).
 */

package Collections;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Dictionary {

    private static Map<String, Integer> wordCounter = new HashMap<String, Integer>();

    private static Map<String, String> dictionary = new HashMap<String, String>();

    private static final int TOP_TEN = 10;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        while(true) {
            System.out.println("Выберите действие:");
            System.out.println("1. Показать словарь");
            System.out.println("2. Добавить/изменить перевод");
            System.out.println("3. Добавить/изменить слово");
            System.out.println("4. Удалить перевод");
            System.out.println("5. Удалить слово");
            System.out.println("6. Показать топ-" + TOP_TEN + " популярных слов");
            System.out.println("7. Показать топ-" + TOP_TEN + " непопулярных слов");
            System.out.println("8. Выход");

            int choice = input.nextInt();

            switch (choice) {
                case 1:
                    showDictionary();
                    break;
                case 2:
                    addOrUpdateTranslation();
                    break;
                case 3:
                    addOrUpdateWord();
                    break;
                case 4:
                    removeTranslation();
                    break;
                case 5:
                    removeWord();
                    break;
                case 6:
                    showTopPopularWords();
                    break;
                case 7:
                    showTopUnpopularWords();
                    break;
                case 8:
                    System.out.println("Программа завершена.");
                    System.exit(0);
                    break;
                default:
                    System.out.println("Неверный выбор. Попробуйте снова.");
            }
        }
    }

    private static void showDictionary() {
        for (Map.Entry<String, String> entry: dictionary.entrySet()) {
            System.out.println(entry.getKey() + "-" + entry.getValue());
        }
    }

    private static void addOrUpdateTranslation() {
        System.out.println("Введите слово:");
        String word = getUserInput();

        System.out.println("Введите перевод:");
        String translation = getUserInput();

        dictionary.put(word, translation);
        wordCounter.put(word, wordCounter.getOrDefault(word, 0) + 1);

        System.out.println("Добавление/изменение перевода прошла успешно!");

    }

    private static void addOrUpdateWord() {
        System.out.println("Введите слово:");
        String word = getUserInput();

        System.out.println("Введите перевод:");
        String translation = getUserInput();

        dictionary.put(word, translation);
        wordCounter.put(word, wordCounter.getOrDefault(word, 0) + 1);

        System.out.println("Добавление/изменение слова прошла успешно!");
    }

    private static void removeTranslation() {
        System.out.println("Введите слово, у которого нужно удалить перевод:");
        String removerTranslation = getUserInput();

        if (dictionary.containsKey(removerTranslation)) {
            dictionary.remove(removerTranslation);
            System.out.println("Перевод успешно удален.");
        } else {
            System.out.println("Перевод не найдено в словаре.");
        }
    }

    private static void removeWord() {
        System.out.println("Введите слово, у которого нужно удалить слово:");
        String removerWord = getUserInput();

        if (dictionary.containsKey(removerWord)) {
            dictionary.remove(removerWord);
            wordCounter.remove(removerWord);
            System.out.println("Слово успешно удалено из словаря.");
        } else {
            System.out.println("Слово не найдено в словаре.");
        }
    }

    private static void showTopPopularWords() {
        System.out.println(TOP_TEN + " популярных слов:");
        wordCounter.entrySet().stream()
                .sorted((entry1, entry2) -> Integer.compare(entry2.getValue(), entry1.getValue()))
                .limit(TOP_TEN)
                .forEach(entry -> System.out.println(entry.getKey() + "-" + entry.getValue()));
    }

    private static void showTopUnpopularWords() {
        System.out.println(TOP_TEN + " непопулярных слов:");
        wordCounter.entrySet().stream()
                .sorted((entry1, entry2) -> Integer.compare(entry1.getValue(), entry2.getValue()))
                .limit(TOP_TEN)
                .forEach(entry -> System.out.println(entry.getKey() + "-" + entry.getValue()));
    }

    private static String getUserInput() {
        Scanner input = new Scanner(System.in);
        return input.nextLine().trim();
    }

}
