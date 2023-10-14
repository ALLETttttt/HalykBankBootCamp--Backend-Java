package Lyambda.Ex4;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 11};

    }

    public static int sumIf(int[] array, ArrayCondition condition) {
        int sum = 0;
        for (int num : array) {
            if (condition.condition(num)) {
                sum += num;
            }
        }
        return sum;
    }
}
