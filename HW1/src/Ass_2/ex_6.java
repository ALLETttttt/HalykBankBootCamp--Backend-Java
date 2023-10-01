package Ass_2;

import java.util.Random;
import java.util.Scanner;

public class ex_6 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите количество строк: ");
        int numRows = scanner.nextInt();

        System.out.print("Введите количество столбцов: ");
        int numCols = scanner.nextInt();

        int[][] array = initializeArray(numRows, numCols);
        System.out.println(array.length);
        System.out.println("Исходный массив:");
        printArray(array);

        System.out.print("Введите номер строки для удаления (от 0 до " + (numRows - 1) + "): ");
        int rowToDelete = scanner.nextInt();

        array = deleteRow(array, rowToDelete);

        System.out.println("Массив после удаления строки:");
        printArray(array);
    }

    public static int[][] initializeArray(int numRows, int numCols) {
        int[][] array = new int[numRows][numCols];
        Random random = new Random();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j < numCols; j++) {
                array[i][j] = random.nextInt(11);
            }
        }

        return array;
    }

    public static void printArray(int[][] array) {
        for (int[] row : array) {
            for (int value : row) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }

    public static int[][] deleteRow(int[][] array, int rowIndex) {
        if (rowIndex < 0 || rowIndex >= array.length) {
            System.out.println("Неверный номер строки для удаления.");
            return array;
        }

        int numRows = array.length - 1;
        int numCols = array[0].length;
        int[][] newArray = new int[numRows][numCols];

        for (int i = 0, newRow = 0; i < array.length; i++) {
            if (i != rowIndex) {
                newArray[newRow++] = array[i];
            }
        }

        return newArray;
    }
}
