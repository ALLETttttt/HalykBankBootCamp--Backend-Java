import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SecondThread {

    private static final int LIST_SIZE = 30;
    public static void main(String[] args) {

        ArrayList<String> randomStrings = new ArrayList<>();
        Thread randomStringsThread = new Thread(() -> generateRandomString(randomStrings));
        randomStringsThread.start();



        Thread longestStringThread = new Thread(() -> findLongestString(randomStrings));

        Thread shortestStringThread = new Thread(() -> findShortestString(randomStrings));

        Thread calculateLengthOfStringsThread = new Thread(() -> calculateLengthOfStrings(randomStrings));

        try {
            randomStringsThread.join();
            System.out.println("Полученный список строк: " + randomStrings);

            longestStringThread.start();
            shortestStringThread.start();
            calculateLengthOfStringsThread.start();

            longestStringThread.join();
            shortestStringThread.join();
            calculateLengthOfStringsThread.join();

        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static void generateRandomString(ArrayList<String> randomStrings) {
        Random random = new Random();
        for (int i = 0; i < LIST_SIZE; i++) {
            int length = random.nextInt(22) + 1;
            StringBuilder string = new StringBuilder();
            for (int j = 0; j < length; j++) {
                char randomChar = (char) (random.nextInt(26) + 'a');
                string.append(randomChar);
            }
            randomStrings.add(string.toString());
        }
    }

    private static void findLongestString(ArrayList<String> randomStrings) {
        String str = randomStrings.get(0);
        for (String s: randomStrings) {
            if (str.length() < s.length()) {
                str = s;
            }
        }
        System.out.println("Самая длинная строка: " + str);
    }

    private static void findShortestString(ArrayList<String> randomStrings) {
        String str = randomStrings.get(0);
        for (String s: randomStrings) {
            if (str.length() > s.length()) {
                str = s;
            }
        }
        System.out.println("Самая короткая строка: " + str);
    }

    private static void calculateLengthOfStrings(ArrayList<String> randomStrings) {
        int sumOfLength = 0;
        for (String s: randomStrings) {
            sumOfLength += s.length();
        }
        System.out.println("Общее количество символов:" + sumOfLength);
    }
}
