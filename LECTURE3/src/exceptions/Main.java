package exceptions;

import java.util.Random;

public class Main {
    public static void main(String[] args) {
        try {
            System.out.println("1");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("2");
        } finally {
            System.out.println("3");
        }

//        try {
//
//        }catch (Exception e){
//
//        }
//
//        try {
//
//        }finally {
//
//        }

        new Main().print();
    }

    private static String getName() {
        return null;
    }

    public void print() {
        int i = new Random().nextInt(1, 100);
        System.out.println(i);
        if (i % 2 == 0) {
//            throw new NullPointerException();//ok with unchecked exc
        } else {
//            throw new FileNotFoundException();//no to checked exc
        }
        //logic
        //perevod
    }
}
