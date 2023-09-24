package Ex4;

public class Main {
    public static void main(String[] args) {
        int[] numbers = {5, 10, 15, 20, 25};

        Array array = new Array(numbers);

        int max = array.Max();
        int min = array.Min();
        float avg = array.Avg();

        System.out.println("Максимум: " + max);
        System.out.println("Минимум: " + min);
        System.out.println("Среднее арифметическое: " + avg);
    }
}
