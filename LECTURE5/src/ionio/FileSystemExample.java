package ionio;

import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class FileSystemExample {
    public static void main(String[] args) {
        try {
            FileSystem filesystem = FileSystems.getDefault();
            for (Path rootdir : filesystem.getRootDirectories()) {
                System.out.println(rootdir.toString());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
