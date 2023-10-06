package cyclicbarrier;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class Main {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(11, new Football());
        for (int i = 0; i < 11; i++) {
            new Student(cyclicBarrier);
        }
    }

    static class Football extends Thread {

        @Override
        public void run() {
            System.out.println("go to football");
        }
    }

    static class Student extends Thread {

        CyclicBarrier cyclicBarrier;

        public Student(CyclicBarrier cyclicBarrier) {
            this.cyclicBarrier = cyclicBarrier;
            start();
        }

        @Override
        public void run() {
            try {
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
