
/*
Задание 5
Пользователь вводит с клавиатуры номер месяца (от
1 до 12). В зависимости от полученного номера месяца
программа выводит на экран надпись: Winter (если введено
значение 1,2 или 12), Spring (если введено значение от 3
до 5), Summer (если введено значение от 6 до 8), Autumn
(если введено значение от 9 до 11).
Если пользователь ввел значение не в диапазоне от 1
до 12 требуется вывести сообщение об ошибке.
 */

package Ass_1;

import java.util.Scanner;

public class ex_5 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        if (n >= 1 && n <= 12) {
            if (n <= 2 || n == 12) System.out.println("Winter");
            else if (n < 6) System.out.println("Spring");
            else if (n < 9) System.out.println("Summer");
            else System.out.println("Autumn");
        }
        else {
            System.out.println("You are a mistake");
        }
    }
}
