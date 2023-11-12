package Practice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

public class ReadArraysFromFile {
    public static void main(String[] args) {
        try {
            // Укажите путь к вашему файлу
            File file = new File("arrays.txt");

            // Создайте объект Scanner для чтения из файла
            Scanner scanner = new Scanner(file);

            // Создайте массивы для хранения данных
            int[] firstArray = null;
            int[] secondArray = null;

            // Читайте данные из файла и загружайте их в массивы
            if (scanner.hasNextLine()) {
                String[] firstLine = scanner.nextLine().split(" ");
                firstArray = new int[firstLine.length];
                for (int i = 0; i < firstLine.length; i++) {
                    firstArray[i] = Integer.parseInt(firstLine[i]);
                }
            }
            System.out.println(Arrays.toString(firstArray));

            if (scanner.hasNextLine()) {
                String[] secondLine = scanner.nextLine().split(" ");
                secondArray = new int[secondLine.length];
                for (int i = 0; i < secondLine.length; i++) {
                    secondArray[i] = Integer.parseInt(secondLine[i]);
                }
            }
            System.out.println(Arrays.toString(secondArray));

            // Ваши массивы теперь содержат данные из файла
            // Можете использовать их по вашему усмотрению

            // Закройте Scanner после использования
            scanner.close();

        } catch (FileNotFoundException e) {
            System.err.println("Файл не найден: " + e.getMessage());
        }
    }
}
