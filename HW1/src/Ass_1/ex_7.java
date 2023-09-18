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
