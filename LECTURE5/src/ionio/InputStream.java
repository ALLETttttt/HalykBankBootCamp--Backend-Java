package ionio;

import java.io.FileInputStream;
import java.io.IOException;

public class InputStream {
    public static void main(String[] args) {
        try (FileInputStream fin = new FileInputStream(Param.URL.getValue())) {
            System.out.printf("File size: %d bytes \n", fin.available());
            int i;
            while ((i = fin.read()) != -1) {
                System.out.print((char) i);
            }
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
