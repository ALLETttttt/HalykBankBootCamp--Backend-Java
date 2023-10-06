package multithreading;

import java.util.concurrent.Executor;

public class Main extends Thread {

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());

        MyThread myThread = new MyThread();
        myThread.start();

        MyRunnable myRunnable = new MyRunnable();
        Thread thread = new Thread(myRunnable);
        thread.start();

        //2
        //executerservice 20
        //Callable, Future
        //stream parallel
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        //logic
        System.out.println("with extends: " + Thread.currentThread().getName());
        System.out.println(Thread.currentThread().getName());
    }
}

class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println("with runnable: " + Thread.currentThread().getName());
    }
}