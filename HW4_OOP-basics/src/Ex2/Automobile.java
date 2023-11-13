package Ex2;

public class Automobile extends Device {

    @Override
    public void sound(String sound) {
        super.sound(sound);
    }

    @Override
    public void show() {
        super.show();
    }

    @Override
    public void desc() {
        super.desc();
    }

    public Automobile(String name, String descr) {
        super(name, descr);
    }
}
