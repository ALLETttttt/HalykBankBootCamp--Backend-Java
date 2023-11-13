/*
Задание 3
В файле на разных строках находятся элементы массивов целых.
 Первая строка содержит элементы первого
массива, вторая второго и так далее. Например:
1 23 43 9
6 33 77 88
Необходимо загрузить данные из файла в разные массивы, показать каждый массив на экран,
показать максимум
и минимум в каждом массиве, сумму элементов каждого
массива. Также нужно отобразить максимум и минимум
среди всех массивов, а также общую сумму всех массивов.
 */


package Practice;

import java.io.*;
import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Scanner;

public class ReadArraysFromFile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String path = input.nextLine();
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            int[][] arrays = new int[0][0];

            String line;
            int lineNumber = 0;

            while ((line = reader.readLine()) != null) {
                int[] array = Arrays.stream(line.split("\\s+"))
                        .mapToInt(Integer::parseInt)
                        .toArray();
                arrays = Arrays.copyOf(arrays, arrays.length + 1);
                arrays[lineNumber++] = array;
            }

            System.out.println("Каждый массив на экран:");
            for (int[] arr: arrays) {
                System.out.println(Arrays.toString(arr));
            }

            System.out.println();

            for (int i = 0; i < arrays.length; i++) {
                int[] arr = arrays[i];
                int max = Arrays
                        .stream(arr)
                        .max()
                        .orElseThrow();

                int min = Arrays
                        .stream(arr)
                        .min()
                        .orElseThrow();

                int sum = Arrays
                        .stream(arr)
                        .sum();

                System.out.println("Массив " + (i + 1) + ":" + Arrays.toString(arr));
                System.out.println("Максимум: " + max);
                System.out.println("Минимум: " + min);
                System.out.println("Сумма: " + sum);
                System.out.println();
            }

            int overallMax = Arrays
                    .stream(arrays)
                    .flatMapToInt(Arrays::stream)
                    .max()
                    .orElseThrow();

            int overallMin = Arrays
                    .stream(arrays)
                    .flatMapToInt(Arrays::stream)
                    .min()
                    .orElseThrow();

            int overallSum = Arrays
                    .stream(arrays)
                    .flatMapToInt(Arrays::stream)
                    .sum();

            System.out.println("Общий максимум: " + overallMax);
            System.out.println("Общий минимум: " + overallMin);
            System.out.println("Общая сумма: " + overallSum);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
