/*
Задание 2
Пользователь с клавиатуры вводит путь к файлу. Программа должна найти длину самой
длинной строки. После
работы программы на экран отображается полученное
число и сама строка.
 */


package Practice;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class LongStringFile {
    public static void main(String[] args) {

        List<String> Strings = new ArrayList<>();


        Scanner input = new Scanner(System.in);
        String path = input.nextLine();


        try (BufferedReader reader = new BufferedReader(new FileReader(path))) {
            String line;
            while ((line = reader.readLine()) != null) {
                Strings.add(line);
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        String str = Strings.get(0);
        for (String s: Strings) {
            if (str.length() < s.length()) {
                str = s;
            }
        }
        System.out.println("Самая длинная строка " + str + " ее длина: " + str.length());
    }
}
