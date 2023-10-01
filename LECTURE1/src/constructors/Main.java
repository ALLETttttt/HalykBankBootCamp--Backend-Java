package constructors;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Car car=new Car();
        car.setModel("Toyota");
        car.setName("Camry");
        System.out.println(car.getModel()+" "+car.getName());

        Car car2=new Car("Mercedes", "S500");
        System.out.println(car2.getModel()+" "+car2.getName());
    }
}
