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
