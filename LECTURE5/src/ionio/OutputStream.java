package ionio;

import java.io.FileOutputStream;
import java.io.IOException;

public class OutputStream {
    public static void main(String[] args) {
        String text = "Hello world!";
        try (FileOutputStream fos = new FileOutputStream(Param.URL.getValue())) {
            byte[] buffer = text.getBytes();
            fos.write(buffer, 0, buffer.length);
            System.out.println("The file has been written");
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
