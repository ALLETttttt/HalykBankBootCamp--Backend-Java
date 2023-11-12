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

        try {
            fillRandomNumbersThread.join();
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }

    private static void fillRandomNumbers(List<Integer> integerList, List<Double> doubleList) {
        Random random = new Random();
        for (int i = 0; i < LIST_SIZE; i++) {
            int integers = random.nextInt(100);
            double doubles = random.nextDouble() * 100;

            integerList.add(integers);
            doubleList.add(doubles);
        }
        System.out.println("Коллекции с целыми числами: " + integerList);
        System.out.println("Коллекции с вещественными числами: " + doubleList);
    }
}
