package Multithreading;

import java.util.Random;

public class MyFirstThread {
    private static int SIZE = 100;

    private static int arr[] = new int[SIZE];

    private static int sum;

    private static double average;

    public static void main(String[] args) {
        Thread firstThread = new Thread();
    }

    private static void fillArray() {
        Random random = new Random();
        for (int i = 0; i < SIZE; i++) {
            arr[i] = random.nextInt(100);
        }
    }

    private static void getSum() {
        for (int i: arr) {
            sum += i;
        }
    }

    private static void getAverage() {
        average = (double) sum / SIZE;
    }
}
