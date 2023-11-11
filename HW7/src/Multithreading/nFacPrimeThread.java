package Multithreading;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class nFacPrimeThread {
    public static void main(String[] args) {

        String filePath = "randomNumbers.txt";

        Thread fillFileThread = new Thread(() -> generateRandomNumbersToFile(filePath));
        fillFileThread.start();

        ArrayList<Integer> factorialNumbers = new ArrayList<>();
        Thread findFactorialThread = new Thread(() -> findFactorial(factorialNumbers, filePath));

        Thread findPrimeNumbersThread = new Thread(nFacPrimeThread::findPrimeNumbers);

        try {
            fillFileThread.join();

            findFactorialThread.start();
            findFactorialThread.join();

            String factorialPath = "factorialNumbers.txt";

            fillFactorialNumbersToFile(factorialPath, factorialNumbers);

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void generateRandomNumbersToFile(String filePath) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            Random random = new Random();

            for (int i = 0; i < 100; i++) {
                int randomNumber = random.nextInt(10);
                writer.write(Integer.toString(randomNumber));
                writer.newLine();
            }
            System.out.println("Сгенерированные числа успешно записаны в файл.");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void findFactorial(ArrayList<Integer> factorialNumbers, String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line);
                factorialNumbers.add(factorial(number));
            }
            System.out.println("Факториал чисел найден.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static int factorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }
        return number * factorial(number-1);
    }

    private static void fillFactorialNumbersToFile(String filePath, ArrayList<Integer> factorialNumbers) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (int number: factorialNumbers) {
                writer.write(Integer.toString(number));
                writer.newLine();
            }
            System.out.println("Факториал числа записаны в данный файл:" + filePath);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void findPrimeNumbers() {}
}
