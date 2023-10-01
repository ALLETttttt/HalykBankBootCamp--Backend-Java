package staticclass;

public class OuterClass {

    private String name;
    private static int age;

    static class StaticNestedClass {
        public static void main(String[] args) {
//            System.out.println(name);
            System.out.println(age);
        }
    }
}
