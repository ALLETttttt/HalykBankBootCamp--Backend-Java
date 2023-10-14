package ionio;

import java.io.File;
import java.io.IOException;

public class Io {
    public static void main(String[] args) {
        try {
            File.createTempFile("prefix", "suffix");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
