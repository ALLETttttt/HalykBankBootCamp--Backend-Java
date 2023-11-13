
/*
Задание 3
Пользователь вводит с клавиатуры три цифры. Необходимо создать число,
содержащее эти цифры. Например, если с клавиатуры введено
7, 3, 8, тогда нужно сформировать число 738.
 */
package Ass_1;

import java.util.Scanner;

public class ex_3 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int first_number = input.nextInt();
        int second_number = input.nextInt();
        int third_number = input.nextInt();
        System.out.println(String.valueOf(first_number) + String.valueOf(second_number) + String.valueOf(third_number));
    }
}
