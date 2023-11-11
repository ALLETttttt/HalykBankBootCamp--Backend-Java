package Multithreading;

import java.io.*;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class nFacPrimeThread {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Введите название файла:");
        String filePath = input.nextLine();

        Thread fillFileThread = new Thread(() -> generateRandomNumbersToFile(filePath));
        fillFileThread.start();

        String factorialPath = "factorialNumbers.txt";
        ArrayList<Integer> factorialNumbers = new ArrayList<>();
        Thread findFactorialThread = new Thread(() -> findFactorial(factorialNumbers, filePath));

        String primePath = "primeNumbers.txt";
        ArrayList<Integer> primeNumbers = new ArrayList<>();
        Thread findPrimeNumbersThread = new Thread(() -> findPrimeNumbers(primeNumbers, filePath));

        try {
            fillFileThread.join();

            findFactorialThread.start();
            findPrimeNumbersThread.start();

            findFactorialThread.join();
            findPrimeNumbersThread.join();

            fillNumbersToFile(factorialPath, factorialNumbers);
            fillNumbersToFile(primePath, primeNumbers);

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

    private static void findPrimeNumbers(ArrayList<Integer> primeNumbers, String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while((line = reader.readLine()) != null) {
                int number = Integer.parseInt(line);
                if (isPrime(number)) {
                    primeNumbers.add(number);
                }
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static boolean isPrime(int number) {
        if (number <= 1) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(number); i++) {
            if (number % i == 0) {
                return false;
            }
        }
        return true;
    }

    private static void fillNumbersToFile(String path, ArrayList<Integer> numbers) {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {
            for (int number: numbers) {
                writer.write(Integer.toString(number));
                writer.newLine();
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
