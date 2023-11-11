package Multithreading;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class nFacPrimeThread {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Введите путь к файлу: ");
        String filePath = input.nextLine();

        Thread fillFileThread = new Thread(() -> generateRandomNumbersToFile(filePath));
        fillFileThread.start();

        Thread findFactorialThread = new Thread(() -> findFactorial(filePath));

        Thread findPrimeNumbersThread = new Thread(nFacPrimeThread::findPrimeNumbers);

        try {
            fillFileThread.join();

            ArrayList<Long> factorialNumbers = findFactorial(filePath);
            String factorialPath = "factorialNumbers.txt";

            fillFactorialNumbersToFile(factorialPath, factorialNumbers);
//            findFactorialThread.start();
//            findPrimeNumbersThread.start();
//
//            findFactorialThread.join();
//            findPrimeNumbersThread.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void generateRandomNumbersToFile(String filePath) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            Random random = new Random();

            for (int i = 0; i < 10; i++) {
                int randomNumber = random.nextInt(10);
                writer.write(Integer.toString(randomNumber));
                writer.newLine();
            }
            System.out.println("Сгенерированные числа успешно записаны в файл.");

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static ArrayList<Long> findFactorial(String filePath) {
        ArrayList<Long> factorialNumbers = new ArrayList<Long>();
        long factorial = 1;
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line);
                factorial *= factorial(number);
            }
            factorialNumbers.add(factorial);
            System.out.println("Факториал чисел найден.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return factorialNumbers;
    }

    private static long factorial(int number) {
        if (number == 0 || number == 1) {
            return 1;
        }
        return number * factorial(number-1);
    }

    private static void fillFactorialNumbersToFile(String filePath, ArrayList<Long> factorialNumbers) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (long number: factorialNumbers) {
                writer.write((int) number);
                writer.newLine();
            }
            System.out.println("");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void findPrimeNumbers() {}
}
