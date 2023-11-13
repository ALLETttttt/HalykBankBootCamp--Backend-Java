
/*
Задание 2
Пользователь вводит с клавиатуры два числа. Первое
число — это значение, второе число процент, который
необходимо посчитать. Например, мы ввели с клавиатуры
50 и 10. Требуется вывести на экран 10 процентов от 50.
Результат: 5
 */

package Ass_1;

import java.util.Scanner;

public class ex_2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int number = input.nextInt();
        int percent = input.nextInt();
        System.out.println((number*percent)/100);
    }
}
