/*
Задание 11
Напишите метод, который отображает горизонтальную или вертикальную линию из некоторого символа.
Метод принимает в качестве параметра: длину линии,
направление, символ.
 */


package Ass_1;

public class ex_11 {
    public static void main(String[] args) {
        draw(5, DIRECTION.horizontal, "&");
        draw(5, DIRECTION.horizontal, "*");
        draw(5, DIRECTION.vertical, "%");
    }

    enum DIRECTION {
        horizontal,
        vertical
    }

    public static void draw(int size, DIRECTION dir, String symbol) {
        switch (dir) {
            case vertical ->
            {
                for (int i = 0; i < size; i++) {
                    System.out.println(symbol);
                }
                System.out.println();
            }
            case horizontal ->
            {
                for (int i = 0; i < size; i++) {
                    System.out.print(symbol);
                }
                System.out.println();
            }
            default -> System.out.println("Something went wrong!");
        }
    }
}
