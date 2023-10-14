package Lyambda.Ex4;

public class Main {
    public static void main(String[] args) {
        int[] array = {1, 2, -3, 4, -5, 6, 7, 8, 9, 11};

        System.out.println("Проверка на равенство конкретному числу");
        int target = 7;
        int sum1 = sumIf(array, n -> n != target);
        System.out.println(sum1);

        System.out.println("Число не находится в диапазоне от A до B");
        int a = 1;
        int b = 7;
        int sum2 = sumIf(array, n -> n < a || n > b);
        System.out.println(sum2);

        System.out.println("Проверка на положительность числа");
        int sum3 = sumIf(array, n -> n > 0);
        System.out.println(sum3);

        System.out.println("Проверка на отрицательность числа");
        int sum4 = sumIf(array, n -> n < 0);
        System.out.println(sum4);

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
