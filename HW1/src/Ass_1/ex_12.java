package Ass_1;

import java.lang.reflect.Array;
import java.util.Arrays;

public class ex_12 {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, -5, 9, -5, -234, -44, 23, 0, 23, 0, 0, 0, -34, -7, 10000, 0};
        System.out.println("Your current array: " + Arrays.toString(arr));
        System.out.println("Your array in ascending order: ");
        sortedArr(arr, SortType.Ascending);
        System.out.println("Your array in descending order: ");
        sortedArr(arr, SortType.Descending);
    }

    enum SortType {
        Ascending,
        Descending
    }

    public static void sortedArr(int[] arr, SortType srt) {
        Arrays.sort(arr);
        switch (srt) {
            case Ascending ->
            {
                System.out.println(Arrays.toString(arr));
            }
            case Descending ->
            {
                for (int i = 0; i < arr.length/2; i++) {
                    int temp = arr[i];
                    arr[i] = arr[arr.length - 1 - i];
                    arr[arr.length - 1 - i] = temp;
                }
                System.out.println(Arrays.toString(arr));
            }
            default ->
                System.out.println("You are a mistake");
        }
    }
}
