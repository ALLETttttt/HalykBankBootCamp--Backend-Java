package java9;

public interface MyInterface {

    void print();//7

    default void invoke() {//8
        System.out.println("invoke");
    }

    static int sum(int a, int b) {//8
        return a + b;
    }

    public static void main(String[] args) {
        myPrivateMethod();
    }

    private static void myPrivateMethod() {//9
        System.out.println("Yay, I am private!");
    }
}
