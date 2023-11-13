/*
Задание 5
Создайте интерфейс ISort. В нём должно быть два
метода:
■ void SortAsc() — сортировка по возрастанию;
■ void SortDesc() — сортировка по убыванию.
Класс Array, созданный ранее, должен имплементировать интерфейс ISort.
Метод SortAsc — сортирует массив по возрастанию.
Метод SortDesc — сортирует массив по убыванию.
Напишите код для тестирования полученной функциональности
 */



package Ex5;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {5, 10, 15, 20, 25};

        Array array = new Array(numbers);

        System.out.println("Сортировка по возрастанию:");
        array.sortAsc();
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();

        System.out.println("Сортировка по убыванию:");
        array.sortDesc();
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
