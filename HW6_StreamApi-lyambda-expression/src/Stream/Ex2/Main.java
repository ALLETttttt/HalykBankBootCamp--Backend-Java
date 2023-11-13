/*
Задание 2
Для набора названий продуктов (продукты могут повторяться) нужно:
■ Показать все продукты;
■ Показать все продукты с названием меньше пяти
символов;
■ Посчитать сколько раз встречается продукт, чье название ввёл пользователь;
■ Показать все продукты, которые начинаются на заданную букву;
■ Показать все продукты из категории «Молоко».
 */




package Stream.Ex2;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<String> products = Arrays.asList("Молоко", "Хлеб", "Яблоко", "Молоко", "Сыр", "Мясо", "Молоко");

        System.out.println("All products:");
        products.forEach((element) -> System.out.print(element + " "));
        System.out.println();
        System.out.println();

        System.out.println("All products with a name less than five symbols:");
        products.stream()
                .filter(product -> product.length() < 5)
                .forEach(System.out::println);
        System.out.println();

        Scanner input = new Scanner(System.in);
        String userInput = input.nextLine();
        long count = products.stream()
                .filter(product -> product.equalsIgnoreCase(userInput))
                .count();
        System.out.println("Number of times a product matching the user's title was discovered: " + count);
        System.out.println();

        String inputLetter = input.nextLine().toLowerCase();
        System.out.println("All products that begin with a letter: " + inputLetter);
        products.stream()
                .filter(product -> product.toLowerCase().startsWith(inputLetter))
                .forEach(System.out::println);

        System.out.println("All products from the Milk category:");
        products.stream()
                .filter(product -> product.equalsIgnoreCase("Молоко"))
                .forEach(System.out::println);
    }
}
