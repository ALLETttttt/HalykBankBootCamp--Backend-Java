package arrays;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        int[] arr = new int[2];
        arr[0] = 1;
        arr[1] = 2;
        Arrays.stream(arr).forEach(System.out::println);

        int[] arr3 = new int[10];
        arr3[0] = 1;
        arr3[1] = 2;
        Arrays.stream(arr3).forEach(System.out::println);

        int[] arr2 = new int[1];
        arr2[0] = 1;
        arr2[1] = 2;
        Arrays.stream(arr2).forEach(System.out::println);
    }
}
