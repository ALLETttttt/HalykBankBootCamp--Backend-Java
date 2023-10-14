package ionio;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderAndWriter {
    public static void main(String[] args) {
        try (FileWriter writer = new FileWriter(Param.URL.getValue())) {
            writer.write("java is good,\n 3 billion devices\n");
            writer.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (FileReader fr = new FileReader(Param.URL.getValue())) {
            char[] a = new char[200];
            fr.read(a);
            for (char c : a) {
                System.out.print(c);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
