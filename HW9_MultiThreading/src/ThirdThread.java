/*
Задание 3
При старте приложения запускаются четыре потока. Первый поток создает две коллекции:
одну с целыми числами и одну с вещественными числами. Три других потока ожидают завершения
первого потока. Когда коллекции созданы, остальные три потока запускаются. Второй поток
находит сумму всех целых чисел, третий поток находит сумму всех вещественных чисел, а четвертый
поток находит количество уникальных элементов в обеих коллекциях. Полученные коллекции,
суммы и количество уникальных элементов возвращаются в метод main, где должны быть отображены.
 */



import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class ThirdThread {

    private static final int LIST_SIZE = 22;
    public static void main(String[] args) {
        List<Integer> integerList = new ArrayList<>();
        List<Double> doubleList = new ArrayList<>();

        Thread fillRandomNumbersThread = new Thread(() -> fillRandomNumbers(integerList, doubleList));
        fillRandomNumbersThread.start();

        Thread sumOfIntegersThread = new Thread(() -> sumOfIntegers(integerList));

        Thread sumOfDoublesThread = new Thread(() -> sumOfDoubles(doubleList));

        Thread removeDuplicatesThread = new Thread(() -> removeDuplicates(integerList, doubleList));

        try {
            fillRandomNumbersThread.join();

            sumOfIntegersThread.start();
            sumOfDoublesThread.start();
            removeDuplicatesThread.start();

            sumOfIntegersThread.join();
            sumOfDoublesThread.join();
            removeDuplicatesThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static void fillRandomNumbers(
            List<Integer> integerList, List<Double> doubleList
    ) {
        Random random = new Random();
        for (int i = 0; i < LIST_SIZE; i++) {
            int integers = random.nextInt(10);
            double doubles = random.nextDouble() * 100;

            integerList.add(integers);
            doubleList.add(doubles);
        }
        System.out.println("Коллекции с целыми числами: " + integerList);
        System.out.println("Коллекции с вещественными числами: " + doubleList);
    }

    private static void sumOfIntegers(List<Integer> integerList) {
        int sumOfInteger = 0;
        for (int i: integerList) {
            sumOfInteger += i;
        }
        System.out.println("Сумма всех целых чисел: " + sumOfInteger);
    }

    private static void sumOfDoubles(List<Double> doubleList) {
        double sumOfDouble = 0.0;
        for (double i: doubleList) {
            sumOfDouble += i;
        }
        System.out.println("Сумма всех вещественных чисел: " + sumOfDouble);
    }

    private static void removeDuplicates(
            List<Integer> integerList, List<Double> doubleList
    ) {
        List<Integer> removerDuplicateIntegers = integerList
                .stream()
                .distinct()
                .toList();
        System.out.println("Количество уникальных элементов целых чисел: "
                + removerDuplicateIntegers.size());

        List<Double> removerDuplicatesDoubles = doubleList
                .stream()
                .distinct()
                .toList();
        System.out.println("Количество уникальных элементов вещественных чисел: "
                + removerDuplicatesDoubles.size());
    }
}
