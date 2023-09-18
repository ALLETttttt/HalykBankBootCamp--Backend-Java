package Ass_1;

import java.util.Scanner;

public class ex_6 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Введите количество метров:");
        int n = input.nextInt();
        System.out.println("Выберите на что хотите перевести:");
        System.out.println("1. Мили");
        System.out.println("2. Ярды");
        System.out.println("3. Дюймы");
        int num = input.nextInt();
        switch (num) {
            case 1 -> System.out.println("В милях " + num / 1609);
            case 2 -> System.out.println("В ярдах " + num * 1.094);
            case 3 -> System.out.println("В дюймах " + num * 39.37);
            default -> System.out.println("Как ты мог ошибиться!");
        }
    }
}
