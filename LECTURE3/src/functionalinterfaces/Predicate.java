package functionalinterfaces;

public class Predicate {

    public static void main(String[] args) {
        java.util.function.Predicate<Integer> isEvenNumber = x -> x % 2 == 0;

        System.out.println(isEvenNumber.test(4));
        System.out.println(isEvenNumber.test(3));
    }
}
