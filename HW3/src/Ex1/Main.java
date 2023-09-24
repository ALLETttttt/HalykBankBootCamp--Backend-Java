package Ex1;

public class Main {
    public static void main(String[] args) {
        Money price = new Money(10, 50);

        Product product = new Product("Chocolate Bar", price);

        product.display();

        product.reducePrice(3, 25);

        product.display();
    }
}
