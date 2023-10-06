package sync;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        Resource resource = new Resource();
        resource.i = 5;

        MyThread myThread = new MyThread();
        myThread.setName("first");
        MyThread myThread2 = new MyThread();

        myThread.setResource(resource);
        myThread2.setResource(resource);

        myThread.start();
        myThread2.start();

        myThread.join();
        myThread2.join();

        System.out.println(resource.i);
    }
}

class MyThread extends Thread {

    Resource resource;

    public void setResource(Resource resource) {
        this.resource = resource;
    }

    @Override
    public void run() {
        resource.changeI();
    }
}

class Resource {

    int i;

    //lock reentrantlock
    //trylock

    public synchronized void changeI() {
        int i = this.i;
        if ("first".equals(Thread.currentThread().getName())) {
            Thread.yield();//уступать
        }
        i++;
        this.i = i;
    }
}
