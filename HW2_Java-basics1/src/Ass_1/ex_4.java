/*
Задание 4
Пользователь вводит шестизначное число. Необходимо
поменять в этом числе первую и шестую цифры, а также
вторую и пятую цифры.
Например, 723895 должно превратиться в 593827.
Если пользователь ввел не шестизначное число требуется вывести сообщение об ошибке.
 */

package Ass_1;

import java.util.Scanner;

public class ex_4 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int num = input.nextInt();
        String str = String.valueOf(num);
        if (str.length() != 6) {
            System.out.println("You are a mistake");
        }
        else {
            char[] ch = str.toCharArray();
            char temp1 = ch[0];
            char temp2 = ch[1];
            ch[0] = ch[5];
            ch[5] = temp1;
            ch[1] = ch[4];
            ch[4] = temp2;
            System.out.println(ch);
        }
    }
}
