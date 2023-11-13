/*
Задание 3
Пользователь с клавиатуры вводит путь к существующей
директории и слово для поиска. После чего запускаются
два потока. Первый должен найти файлы, содержащие
искомое слово и слить их содержимое в один файл. Второй
поток ожидает завершения работы первого потока. После
чего проводит вырезание всех запрещенных слов (список
этих слов нужно считать из файла с запрещенными словами)
 из полученного файла. В методе main необходимо
отобразить статистику выполненных операций
 */


package Homework;

import java.io.*;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.*;

public class FileProcessing {

    private static int filesProcessed = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        String directoryPath = input.nextLine();
        String searchWord = "target";

        Path mergedFilePath = Paths.get("mergedFile.txt");
        Path filteredFilePath = Paths.get("filteredFile.txt");

        Path forbiddenWordsFilePath = Paths.get("forbiddenWords.txt");

        try {
            ExecutorService executorService = Executors.newFixedThreadPool(2);
            Future<String> mergeResult = executorService.submit(() -> mergeFiles(directoryPath, searchWord, mergedFilePath));

            String mergeFilePath = mergeResult.get();

            Future<String> filterResult = executorService.submit(() -> filterForbiddenWords(mergeFilePath, filteredFilePath, forbiddenWordsFilePath));

            String filteredFilePathString = filterResult.get();

            System.out.println("Обработка завершена успешно.");
            System.out.println("Обработано файлов: " + filesProcessed);
            System.out.println("Итоговый файл после фильтрации: " + filteredFilePathString);

            executorService.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            System.out.println("Ошибка при выполнении задач: " + e.getMessage());
        }
    }

    private static String mergeFiles(String directoryPath, String searchWord, Path mergedFilePath) throws IOException {
        try (BufferedWriter writer = Files.newBufferedWriter(mergedFilePath)) {
            Files.walkFileTree(Paths.get(directoryPath), new SimpleFileVisitor<Path>() {
                @Override
                public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                    if (Files.isRegularFile(file) && file.toString().endsWith(".txt")) {
                        if (containsWord(file, searchWord)) {
                            List<String> lines = Files.readAllLines(file);
                            for (String line : lines) {
                                writer.write(line);
                                writer.newLine();
                            }
                            filesProcessed++;
                        }
                    }
                    return FileVisitResult.CONTINUE;
                }
            });
        }
        return mergedFilePath.toString();
    }

    private static boolean containsWord(Path filePath, String searchWord) throws IOException {
        List<String> lines = Files.readAllLines(filePath);
        for (String line : lines) {
            if (line.contains(searchWord)) {
                return true;
            }
        }
        return false;
    }

    private static String filterForbiddenWords(String inputFilePath, Path filteredFilePath, Path forbiddenWordsFilePath) throws IOException {
        List<String> forbiddenWords = Files.readAllLines(forbiddenWordsFilePath);
        try (BufferedReader reader = Files.newBufferedReader(Paths.get(inputFilePath));
             BufferedWriter writer = Files.newBufferedWriter(filteredFilePath)) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String forbiddenWord : forbiddenWords) {
                    line = line.replaceAll(forbiddenWord, "");
                }
                writer.write(line);
                writer.newLine();
            }
        }
        return filteredFilePath.toString();
    }
}
