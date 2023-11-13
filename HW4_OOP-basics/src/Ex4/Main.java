/*
Задание 4
Создайте интерфейс IMath. В нём должно быть три
метода:
■ int Max()  — возвращает максимум;
■ int Min() — возвращает минимум;
■ float Avg() — возвращает среднеарифметическое.
Класс Array, созданный ранее, должен имплементировать интерфейс IMath.
Метод Max — возвращает максимум среди элементов
массива.
Метод Min — возвращает минимум среди элементов
массива.
Метод Avg — возвращает среднеарифметическое
среди элементов массива.
Напишите код для тестирования полученной функциональности.
 */


package Ex4;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {5, 10, 15, 20, 25};

        Array array = new Array(numbers);

        int max = array.Max();
        int min = array.Min();
        float avg = array.Avg();

        System.out.println("Максимум: " + max);
        System.out.println("Минимум: " + min);
        System.out.println("Среднее арифметическое: " + avg);
    }
}
