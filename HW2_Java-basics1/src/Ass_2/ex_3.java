/*
3. Показать на консоли все числа Армстронга в диапазоне от 0 до 10.000.000.
Число Армстронга, или Самовлюблённое число, или совершенный цифровой
инвариант или — натуральное число, которое равно
сумме своих цифр, возведённых в степень, равную
количеству его цифр. НаПример: 13 + 53 + 33 = 153.
 */

package Ass_2;

public class ex_3 {
    public static void main(String[] args) {
        int maxLimit = 10_000_000;

        System.out.println("Числа Армстронга в диапазоне от 0 до " + maxLimit + ":");
        for (int number = 0; number <= maxLimit; number++) {
            if (isArmstrongNumber(number)) {
                System.out.println(number);
            }
        }
    }

    public static boolean isArmstrongNumber(int number) {
        int originalNumber = number;
        int numberOfDigits = String.valueOf(number).length();
        int sum = 0;

        while (number > 0) {
            int digit = number % 10;
            sum += (int) Math.pow(digit, numberOfDigits);
            number /= 10;
        }

        return sum == originalNumber;

    }
}
