package Lyambda.Ex2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Operations sumOperation = (a, b) -> a + b;
        Operations divideOperation = (a, b) -> a / b;
        Operations diffOperation = (a, b) -> Math.abs(a - b);
        Operations multiplyOperation = (a, b) -> a * b;

        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();

        System.out.println(sumOperation.doOperation(a, b));
        System.out.println(diffOperation.doOperation(a, b));
        System.out.println(divideOperation.doOperation(a, b));
        System.out.println(multiplyOperation.doOperation(a, b));
    }
}
