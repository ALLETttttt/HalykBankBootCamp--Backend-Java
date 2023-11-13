
/*
Задание 8
Показать на экран таблицу умножения в диапазоне,
указанном пользователем. Например, если пользователь
указал 3 и 5, таблица может выглядеть так:
3*1 = 3 3*2 = 6 3*3 = 9 ………… 3* 10 = 30
……………………………………………………
5*1 = 5 5 *2 = 10 5 *3 = 15 ………….
 */

package Ass_1;

import java.util.Scanner;

public class ex_8 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int m = input.nextInt();
        if(n > m) {
            int temp = n;
            n = m;
            m = temp;
        }
        for (int i = n; i <= m; i++) {
            for (int j = 1; j <= 10; j++) {
                System.out.println(i + "*" + j + "=" + i*j);
            }
        }
    }
}
