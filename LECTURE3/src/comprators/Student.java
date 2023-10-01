package comprators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Student {

    int rollno;
    String name;

    public Student(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    public String toString() {
        return this.rollno + " " + this.name;
    }
}

class Sortbyroll implements Comparator<Student> {

    public int compare(Student a, Student b) {
        return a.rollno - b.rollno;
//        return b.rollno - a.rollno;
    }
}

class SortbyName implements Comparator<Student> {

    public int compare(Student a, Student b) {
        return a.name.compareTo(b.name);
    }
}

class Main {

    public static void main(String[] args) {
        List<Student> studentList = new ArrayList<Student>();
        studentList.add(new Student(111, "Madina"));
        studentList.add(new Student(131, "Kuanysh"));
        studentList.add(new Student(121, "Akhmet"));

        System.out.println("Unsorted");
        for (int i = 0; i < studentList.size(); i++)
            System.out.println(studentList.get(i));

        Collections.sort(studentList, new Sortbyroll());
        System.out.println("\nSorted by rollno");
        for (int i = 0; i < studentList.size(); i++) {
            System.out.println(studentList.get(i));
        }

        Collections.sort(studentList, new SortbyName());
        System.out.println("\nSorted by name");
        for (int i = 0; i < studentList.size(); i++)
            System.out.println(studentList.get(i));
    }
}
