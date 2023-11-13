/*
Задание 1
Для набора случайно сгенерированных целых чисел
нужно:
■ Количество положительных;
■ Количество отрицательных;
■ Количество двухзначных;
■ Количество зеркальных чисел. Например, 121 или 4224.
 */


package Stream.Ex1;


import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        List<Integer> randomNumbers = new Random().ints(100, -100, 100)
                .boxed()
                .toList();

        long positiveCount = randomNumbers.stream()
                .filter(n -> n > 0)
                .count();
        System.out.print("Positive numbers: " + positiveCount);

        System.out.println();

        long negativeCount = randomNumbers.stream()
                .filter(n -> n < 0)
                .count();
        System.out.print("Negative numbers: " + negativeCount);

        System.out.println();

        long twoDigitCount = randomNumbers.stream()
                .filter(n -> (n >= 10 && n <= 99) || (n >= -10 && n <= -99))
                .count();
        System.out.print("Two digit numbers: " + twoDigitCount);

        System.out.println();

        long palindromeCount = randomNumbers.stream()
                .filter(Main::isPalindrome)
                .count();
        System.out.print("Palindrome numbers: " + palindromeCount);

    }

    public static boolean isPalindrome(int number) {
        String numberStr = Integer.toString(number);
        String reversed = new StringBuilder(numberStr).reverse().toString();
        return numberStr.equals(reversed);
    }
}
