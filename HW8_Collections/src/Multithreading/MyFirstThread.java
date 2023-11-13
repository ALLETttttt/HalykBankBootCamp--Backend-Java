/*
Задание 1
При старте приложения запускаются три потока. Первый поток заполняет массив случайными числами.
Два других потока ожидают заполнения. Когда массив заполнен оба потока запускаются.
Первый поток находит сумму элементов массива, второй поток среднеарифметическое
значение в массиве. Полученный массив, сумма и среднеарифметическое возвращаются
в метод main, где должны быть отображены.
 */


package Multithreading;

import java.util.Arrays;
import java.util.Random;

public class MyFirstThread {
    private static final int SIZE = 10;

    private static final int[] arr = new int[SIZE];

    private static int sum;

    private static double average;

    public static void main(String[] args) {
        Thread fillArray = new Thread(MyFirstThread::fillArray);
        fillArray.start();

        Thread getSum = new Thread(MyFirstThread::getSum);

        Thread getAverage = new Thread(MyFirstThread::getAverage);

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


