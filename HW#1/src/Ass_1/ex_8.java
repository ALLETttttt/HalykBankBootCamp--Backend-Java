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
