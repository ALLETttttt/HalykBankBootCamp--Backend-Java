package Stream.Ex2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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



    }
}
