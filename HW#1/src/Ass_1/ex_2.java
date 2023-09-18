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
