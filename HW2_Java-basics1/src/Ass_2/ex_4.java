/*
4. Необходимо нарисовать ёлочку символом звёздочки.
Каждый новый ярус должен быть шире предыдущего.
С клавиатуры вводится количество ярусов, и высота
первого (верхнего) яруса ёлочки. Ёлочка должна быть
симметричная.
Пример работы программы:
 */


package Ass_2;


import java.util.Scanner;

public class ex_4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the height of tree: ");
        int h = sc.nextInt();
        for (int i = 1; i <= h; i++) {
            for (int j = h - i; j > 0; j--) {
                System.out.print(" ");
            }
            for (int k = 1; k < i*2; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
