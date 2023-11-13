/*
Задание 10
Есть одномерный массив, заполненный случайными
числами. На основании данных этого массива нужно:
■ Создать одномерный массив, содержащий только
четные числа из первого массива;
■ Создать одномерный массив, содержащий только
нечетные числа из первого массива;
■ Создать одномерный массив, содержащий только
отрицательные числа из первого массива;
■ Создать одномерный массив, содержащий только
положительные числа из первого массива.
 */


package Ass_1;

public class ex_10 {
    public static void main(String[] args) {
        int[] arr = {1, 4, 3, -5, 9, -5, -234, -44, 23, 0, 23, 0, 0, 0, -34, -7, 10000, 0};
        int[] arrPos = filterPos(arr),
                arrNeg = filterNeg(arr),
                arrEven = filterEven(arr),
                arrOdd = filterOdd(arr);
        printArray(arrPos);
        printArray(arrNeg);
        printArray(arrEven);
        printArray(arrOdd);
    }

    public static int[] filterEven(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int num : arr) {
            if (num % 2 == 0) {
                result[index++] = num;
            }
        }
        return result;
    }

    public static int[] filterOdd(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num % 2 != 0) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int num : arr) {
            if (num % 2 != 0) {
                result[index++] = num;
            }
        }
        return result;
    }

    public static int[] filterPos(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num > 0) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int num : arr) {
            if (num > 0) {
                result[index++] = num;
            }
        }
        return result;
    }

    public static int[] filterNeg(int[] arr) {
        int count = 0;
        for (int num : arr) {
            if (num < 0) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int num : arr) {
            if (num < 0) {
                result[index++] = num;
            }
        }
        return result;
    }

    public static void printArray(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
