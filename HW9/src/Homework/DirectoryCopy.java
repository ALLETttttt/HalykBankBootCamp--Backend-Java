package Homework;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.Scanner;

public class DirectoryCopy {

    private static int filesCopied = 0;
    private static int directoriesCopied = 0;

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        String sourcePath = input.nextLine();
        String destinationPath = input.nextLine();

        try {
            copyDirectory(Paths.get(sourcePath), Paths.get(destinationPath));

            System.out.println("Копирование завершено успешно.");
            System.out.println("Скопировано файлов: " + filesCopied);
            System.out.println("Скопировано директорий: " + directoriesCopied);
        } catch (IOException e) {
            System.out.println("Ошибка при копировании: " + e.getMessage());
        }
    }

    private static void copyDirectory(Path source, Path destination) throws IOException {
        Files.walkFileTree(source, new SimpleFileVisitor<Path>() {
            @Override
            public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
                Path targetDir = destination.resolve(source.relativize(dir));
                try {
                    Files.copy(dir, targetDir);
                    directoriesCopied++;
                } catch (FileAlreadyExistsException e) {
                    // Игнорируем, если директория уже существует
                }
                return FileVisitResult.CONTINUE;
            }

            @Override
            public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
                Path targetFile = destination.resolve(source.relativize(file));
                Files.copy(file, targetFile, StandardCopyOption.REPLACE_EXISTING);
                filesCopied++;
                return FileVisitResult.CONTINUE;
            }
        });
    }
}
