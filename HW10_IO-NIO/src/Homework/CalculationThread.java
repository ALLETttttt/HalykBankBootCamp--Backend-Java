/*
Задание 1
Пользователь с клавиатуры вводит путь к файлу. После
чего запускаются три потока. Первый поток заполняет
файл случайными числами. Два других потока ожидают
заполнения. Когда файл заполнен оба потока стартуют.
Первый поток находит все простые числа, второй поток
факториал каждого числа в файле. Результаты поиска
каждый поток должен записать в новый файл. В методе
main необходимо отобразить статистику выполненных
операций.
 */



package Homework;

import java.util.Arrays;
import java.util.Random;

public class CalculationThread {
    private static final int SIZE = 10;

    private static final int[] arr = new int[SIZE];

    private static int sum;

    private static double average;

    public static void main(String[] args) {
        Thread fillArray = new Thread(CalculationThread::fillArray);
        fillArray.start();

        Thread getSum = new Thread(CalculationThread::getSum);

        Thread getAverage = new Thread(CalculationThread::getAverage);

        try {
            fillArray.join();
            getSum.start();
            getAverage.start();

            getSum.join();
            getAverage.join();

            System.out.println("Исходный массив:");
            System.out.println(Arrays.toString(arr));

            System.out.println("Сумма элементов массива: " + sum);
            System.out.println("Среднее арифметическое массива: " + average);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void fillArray() {
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = random.nextInt(100);
        }
    }

    private static void getSum() {
        for (int i = 0; i < SIZE; i++) {
            sum += arr[i];
        }
    }

    private static void getAverage() {
        int total = 0;
        for (int i = 0; i < SIZE; i++) {
            total += arr[i];
        }
        average = (double) total / SIZE;
    }
}
