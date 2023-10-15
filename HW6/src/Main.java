import Exceptions.AggregationException;
import Exceptions.EmptyListException;
import Classes.Person;
import Exceptions.NoMatchingDataException;
import Exceptions.SortingException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>();

        personList.add(new Person("John", 20));
        personList.add(new Person("Alice", 30));
        personList.add(new Person("Bob", 25));
        personList.add(new Person("Charlie", 35));

        try {
            if (personList.isEmpty()) {
                throw new EmptyListException("The list is empty.");
            } else {
                for (Person person : personList) {
                    System.out.println("Name: " + person.getName() + ", Age: " + person.getAge());
                }
            }
        } catch (EmptyListException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        try {
            int limitAge = 21;
            List<Person> list = personList.stream()
                    .filter(person -> person.getAge() > limitAge)
                    .toList();
            if (list.isEmpty()) {
                throw new NoMatchingDataException("No matching data!");
            }
            else {
                list.forEach(System.out::println);
            }
        } catch (NoMatchingDataException e) {
            System.out.println(e.getMessage());
        }
        System.out.println();

        try {
            List<Person> list = personList.stream()
                    .sorted(Comparator.comparing(Person::getName))
                    .toList();
            if (list.isEmpty()) {
                throw new SortingException("Sorting is not done!");
            }
            else {
                list.forEach(System.out::println);
            }
        } catch (SortingException e) {
           System.out.println(e.getMessage());
        }
        System.out.println();

        try {
            String aggregatedNames = personList.stream()
                    .map(Person::getName)
                    .collect(Collectors.joining(", "));
            if (aggregatedNames.isEmpty()) {
                throw new AggregationException("Data aggregation not done!");
            }
            else {
                System.out.println("Aggregated Names: " + aggregatedNames);
            }
        } catch (AggregationException e) {
            System.out.println(e.getMessage());
        }
    }
}
