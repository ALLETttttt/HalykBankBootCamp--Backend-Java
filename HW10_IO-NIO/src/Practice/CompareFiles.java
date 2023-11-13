/*
Задание 1
Пользователь вводит с клавиатуры пути к двум текстовым файла.
Программа должна проверить совпадают
ли их строки. Если нет, то вывести несовпадающую строку
из каждого файла.
 */




package Practice;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CompareFiles {
    private static final String url = "/Users/bakdaulet/IdeaProjects/JustCode/HW9/firstFile.txt";
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        List<String> firstFilesData = new ArrayList<>();
        String path1 = input.nextLine();

        parseDataFromFile(path1, firstFilesData);

        List<String> secondFilesData = new ArrayList<>();
        String path2 = input.nextLine();

        parseDataFromFile(path2, secondFilesData);

        System.out.println("Не совпадают строки файла: " + firstFilesData);
        for (String s: firstFilesData) {
            if (!secondFilesData.contains(s)) {
                System.out.println(s);
            }
        }

        System.out.println();

        System.out.println("Не совпадают строки файла: " + secondFilesData);
        for (String s: secondFilesData) {
            if (!firstFilesData.contains(s)) {
                System.out.println(s);
            }
        }
    }

    private static void parseDataFromFile(String path, List<String> filesData) {
        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while((line = reader.readLine()) != null) {
                filesData.add(line);
            }
            System.out.println(filesData);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
