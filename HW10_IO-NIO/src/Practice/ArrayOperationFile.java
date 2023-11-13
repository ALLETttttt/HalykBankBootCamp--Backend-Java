/*
Задание 4
Пользователь с клавиатуры вводит путь к файлу и массив целых.
Необходимо сохранить исходный массив в первой строке файла, четные значения
из массива во второй
строке файла, нечетные в третьей, перевернутый массив
в четвертой.
 */


package Practice;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

public class ArrayOperationFile {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.println("Введите путь к файлу: ");
        String path = input.nextLine();

        System.out.println("Введите массив целых чисел через пробел: ");
        String inputArray = input.nextLine();

        int[] originalArray = Arrays.stream(inputArray.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(path))) {

            writer.write(Arrays.toString(originalArray));
            writer.newLine();

            int[] evenArray = Arrays
                    .stream(originalArray)
                            .filter(num -> num % 2 == 0)
                                    .toArray();
            writer.write(Arrays.toString(evenArray));
            writer.newLine();

            int[] oddArray = Arrays
                    .stream(originalArray)
                    .filter(num -> num % 2 != 0)
                    .toArray();
            writer.write(Arrays.toString(oddArray));
            writer.newLine();

            int[] reversedArray = new int[originalArray.length];
            for (int i = 0; i < originalArray.length; i++) {
                reversedArray[i] = originalArray[originalArray.length-1-i];
            }
            writer.write(Arrays.toString(reversedArray));

            System.out.println("Данные успешно записаны в файл.");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
