package Stream.Ex3;

public class Device {
    private String name;
    private String manufacturedYear;
    private int price;
    private String color;
    private DeviceType type;

    public Device(String name, String manufacturedYear, int price, String color, DeviceType type) {
        this.name = name;
        this.manufacturedYear = manufacturedYear;
        this.price = price;
        this.color = color;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturedYear() {
        return manufacturedYear;
    }

    public void setManufacturedYear(String manufacturedYear) {
        this.manufacturedYear = manufacturedYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public DeviceType getType() {
        return type;
    }

    public void setType(DeviceType type) {
        this.type = type;
    }

    @Override
    public String toString() {
        return "Device{" +
                "name='" + name + '\'' +
                ", manufacturedYear='" + manufacturedYear + '\'' +
                ", price=" + price +
                ", color='" + color + '\'' +
                ", type=" + type +
                '}';
    }
}
