package Multithreading;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.concurrent.*;

public class Main {
    private static final int NUM_THREADS = 3;
    private static final int FILE_SIZE = 10;
    private static final String INPUT_FILE_PATH = "input.txt";
    private static final String PRIME_OUTPUT_FILE_PATH = "prime_output.txt";
    private static final String FACTORIAL_OUTPUT_FILE_PATH = "factorial_output.txt";

    public static void main(String[] args) {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        try {
            System.out.print("Введите путь к файлу: ");
            String filePath = reader.readLine();

            // Генерируем случайные числа и записываем их в файл
            generateRandomNumbersToFile(filePath);

            // Ищем четные числа в файле
            ArrayList<Integer> evenNumbers = findEvenNumbers(filePath);

            // Создаем новый файл и записываем туда четные числа
            String newFilePath = "even_numbers.txt";
            writeEvenNumbersToFile(newFilePath, evenNumbers);

            // Выводим статистику выполненных операций
            System.out.println("Статистика выполненных операций:");
            System.out.println("Исходный файл: " + filePath);
            System.out.println("Новый файл с четными числами: " + newFilePath);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void generateRandomNumbersToFile(String filePath) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            Random random = new Random();

            for (int i = 0; i < 10; i++) {
                int randomNumber = random.nextInt(101); // случайное число от 0 до 100
                writer.println(randomNumber);
            }

            System.out.println("Сгенерированные числа успешно записаны xв файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static ArrayList<Integer> findEvenNumbers(String filePath) {
        ArrayList<Integer> evenNumbers = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line);
                if (number % 2 == 0) {
                    evenNumbers.add(number);
                }
            }

            System.out.println("Четные числа успешно найдены в файле.");
        } catch (IOException | NumberFormatException e) {
            e.printStackTrace();
        }

        return evenNumbers;
    }

    private static void writeEvenNumbersToFile(String filePath, ArrayList<Integer> evenNumbers) {
        try (PrintWriter writer = new PrintWriter(new FileWriter(filePath))) {
            for (int number : evenNumbers) {
                writer.println(number);
            }

            System.out.println("Четные числа успешно записаны в новый файл.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}