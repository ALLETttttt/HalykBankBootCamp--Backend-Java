package Stream.Ex4;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Projector> projectors = new ArrayList<>();

        projectors.add(new Projector("Projector1", 2021, 1500, "Manufacturer1"));
        projectors.add(new Projector("Projector2", 2022, 800, "Manufacturer2"));
        projectors.add(new Projector("Projector3", 2023, 600, "Manufacturer1"));
        projectors.add(new Projector("Projector4", 2022, 300, "Manufacturer3"));
        projectors.add(new Projector("Projector5", 2013, 1200, "Manufacturer2"));

        System.out.println("Show all projectors");
        projectors.forEach(System.out::println);
        System.out.println();

        System.out.println("Show all projectors from the same manufacturer");
        String manufacturer = "Manufacturer1";
        projectors.stream()
                .filter(projector -> projector.getManufacturer().equalsIgnoreCase(manufacturer))
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Show all projectors of the current year");
        int year = 2023;
        projectors.stream()
                .filter(projector -> projector.getManufacturedYear() == year)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Show all projectors that are more expensive than a given price");
        int price = 700;
        projectors.stream()
                .filter(projector -> projector.getPrice() > price)
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Show all projectors sorted by price Ascending");
        projectors.stream()
                .sorted(Comparator.comparingInt(Projector::getPrice))
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Show all projectors sorted by price Descending");
        projectors.stream()
                .sorted(Comparator.comparingInt(Projector::getPrice).reversed())
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Show all projectors sorted by year releases in ascending order");
        projectors.stream()
                .sorted(Comparator.comparingInt(Projector::getManufacturedYear))
                .forEach(System.out::println);
        System.out.println();

        System.out.println("Show all projectors sorted by year releases in descending order");
        projectors.stream()
                .sorted(Comparator.comparingInt(Projector::getManufacturedYear).reversed())
                .forEach(System.out::println);
    }
}
