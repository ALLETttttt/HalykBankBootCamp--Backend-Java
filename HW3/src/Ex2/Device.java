package Ex2;

public abstract class Device {
    private String name;
    private String descr;

    public Device(String name, String descr) {
        this.name = name;
        this.descr = descr;
    }

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", descr='" + descr + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public void sound(String sound) {
        System.out.println("The sound of " + this.name + ": " + sound);
    }

    public void show() {
        System.out.println("The name of a device: " + this.name);
    }

    public void desc() {
        System.out.println("Description: " + this.descr);
    }
}
