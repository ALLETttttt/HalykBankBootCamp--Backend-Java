package generics;

public class Gener<T> {

    T object;

    Gener(T object) {
        this.object = object;
    }

    T getObject() {
        return object;
    }

    void showType() {
        System.out.println("Type: " + object.getClass().getName());
    }

    public static void main(String[] args) {
        Gener<Integer> integerGener = new Gener<>(77);
        integerGener.showType();
        int value = integerGener.getObject();
        System.out.println("Value: " + value);

        Gener<String> strOb = new Gener<>("qwerty");
        strOb.showType();
        String str = strOb.getObject();
        System.out.println("Value: " + str);
    }
}