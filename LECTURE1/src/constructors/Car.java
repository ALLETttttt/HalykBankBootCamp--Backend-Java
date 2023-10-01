package constructors;

public class Car {

    private int speed;

    public Car() {
        System.out.println("car");
    }

    public Car(String name, String model) {
        this.name = name;
        this.model = model;
    }

    public int getSpeed(){
        return speed;
    }

    private String name;
    private String model;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }
}
