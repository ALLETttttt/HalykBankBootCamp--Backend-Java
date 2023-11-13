/*
Задание 3
Создайте и вызовите следующие лямбда-выражения.
Обязательно использовать шаблоны:
■ Максимум из четырёх;
■ Минимум из четырёх.
 */

package Lyambda.Ex3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        MinMaxOfFour maxOfFour = (a, b, c, d) -> Math.max(Math.max(a, b), Math.max(c, d));
        MinMaxOfFour minOfFour = (a, b, c, d) -> Math.min(Math.min(a, b), Math.min(c, d));

        Scanner input = new Scanner(System.in);
        int a = input.nextInt();
        int b = input.nextInt();
        int c = input.nextInt();
        int d = input.nextInt();

        System.out.print("Max Number: ");
        System.out.println(maxOfFour.MinMaxOfFour(a, b, c, d));
        System.out.print("Min number: ");
        System.out.println(minOfFour.MinMaxOfFour(a, b, c, d));
    }
}
