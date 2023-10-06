package semaphores;

import java.util.concurrent.Semaphore;

public class Philosopher extends Thread {

    private Semaphore semaphore;

    private boolean done = false;

    private String name;

    Philosopher(Semaphore semaphore, String name) {
        this.semaphore = semaphore;
        this.name = name;
    }

    public void run() {
        try {
            if (!done) {
                semaphore.acquire();
                System.out.println(name + " садится за стол");

                sleep(300);
                done = true;

                System.out.println(name + " поел! Он выходит из-за стола");
                semaphore.release();

                sleep(300);
            }
        } catch (InterruptedException e) {
            System.out.println("Что-то пошло не так!");
        }
    }
}