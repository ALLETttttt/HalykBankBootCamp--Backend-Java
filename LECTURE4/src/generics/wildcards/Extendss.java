package generics.wildcards;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class Extendss {

    public static void iterateAnimals(Collection<Animal> animals) {
        for (Animal animal : animals) {
            System.out.println("foreach");
        }
    }

    public static void iterateAnimalsWithWildcard(Collection<? extends Animal> animals) {
        for (Animal animal : animals) {
            System.out.println("foreach wildcard");
        }
    }

    public static void main(String[] args) {
        List<Cat> cats = new ArrayList<>();
        cats.add(new Cat());
        cats.add(new Cat());
        cats.add(new Cat());
        cats.add(new Cat());

//        iterateAnimals(cats);//error
        iterateAnimalsWithWildcard(cats);
    }
}
