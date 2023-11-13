/*
5. Сформируйте массив из 10 элементов, заполнив его
целыми случайными числами от –10 до 10. Определите
среднее арифметическое элементов массива. Сформируйте новый массив, переписав в него элементы
исходного массива, меньшие среднего.
Выполните сортировку исходного массива по возрастанию элементов.
 */


package Ass_2;

import java.util.Arrays;
import java.util.Random;

public class ex_5 {
    public static void main(String[] args) {
        int[] arr = new int[10];
        Random random = new Random();
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            arr[i] = random.nextInt(21) - 10;
            sum += arr[i];
        }
        int average = sum/ arr.length;
        System.out.println(Arrays.toString(arr));
        System.out.println("Average of randomly pushed elements in array: " + average);
        int counter = 0;
        for (int j : arr) {
            if (j < average) {
                counter++;
            }
        }
        int[] newArr = new int[counter];
        int index = 0;
        for (int j : arr) {
            if (j < average) {
                newArr[index++] = j;
            }
        }
        Arrays.sort(newArr);
        System.out.println("New sorted array with low element than average: " + Arrays.toString(newArr));
    }
}
