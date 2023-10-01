import lecture1.constructors.Car;

public class Toyota extends Car implements Runnable {

    public Toyota() {
        super();
        System.out.println("toyota");
    }

    @Override
    public int getSpeed() {
        return super.getSpeed();
    }

    public static void main(String[] args) {
        Toyota car = new Toyota();
        if (car instanceof Toyota) {
            //add camry 3.5
        } else {

        }
    }

    @Override
    public void doAction() {
        System.out.println("start engine");
    }
}
