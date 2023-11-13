
/*
Задание 7
Пользователь вводит с клавиатуры два числа. Нужно
показать все нечетные числа в указанном диапазоне. Если
границы диапазона указаны неправильно требуется произвести нормализацию границ.
Например, пользователь ввел 20 и 11, требуется нормализация, после которой
начало диапазона станет равно 11, а конец 20.
 */

package Ass_1;

import java.util.Scanner;

public class ex_7 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n1 = input.nextInt();
        int n2 = input.nextInt();
        if(n1 > n2) {
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }
        for (int i = n1; i <= n2; i++) {
            if (i % 2 == 0) {
                System.out.println(i);
            }
        }
    }
}
