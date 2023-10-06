package sync;

public class Blok {

    private Object obj = new Object();

    public void doSomething() {
        synchronized (obj) {
            //logic
        }
        synchronized (this){
            //another logic
        }
    }
}
