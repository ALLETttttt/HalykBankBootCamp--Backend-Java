package ionio;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class PathExample {
    public static void main(String[] args) {
//        Path relative = Paths.get("PathExample.java");
//        System.out.println("Файл: " + relative);
//        System.out.println(relative.getFileSystem());

        Path path = Paths.get(Param.URL.getValue());
        boolean pathExists = Files.exists(path);
        System.out.println(pathExists);
    }
}
