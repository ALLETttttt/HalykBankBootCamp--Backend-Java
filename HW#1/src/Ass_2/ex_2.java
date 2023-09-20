package Ass_2;

import java.util.Scanner;

public class ex_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите шестизначный номер билета: ");
        int ticketNumber = scanner.nextInt();

        boolean isHappy = checkHappyTicket(ticketNumber);

        if (isHappy) {
            System.out.println("Да");
        } else {
            System.out.println("Нет");
        }
    }

    public static boolean checkHappyTicket(int ticketNumber) {
        if (ticketNumber < 100000 || ticketNumber > 999999) {
            return false;
        }

        int sumFirstHalf = 0;
        int sumSecondHalf = 0;
        int temp = ticketNumber;

        for (int i = 0; i < 3; i++) {
            sumFirstHalf += temp % 10;
            temp /= 10;
        }

        for (int i = 0; i < 3; i++) {
            sumSecondHalf += temp % 10;
            temp /= 10;
        }

        return sumFirstHalf == sumSecondHalf;
    }
}
