package Stream.Ex4;

public class Projector {
    private String name;
    private int manufacturedYear;
    private int price;
    private String manufacturer;

    public Projector(String name, int manufacturedYear, int price, String manufacturer) {
        this.name = name;
        this.manufacturedYear = manufacturedYear;
        this.price = price;
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getManufacturedYear() {
        return manufacturedYear;
    }

    public void setManufacturedYear(int manufacturedYear) {
        this.manufacturedYear = manufacturedYear;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Projector{" +
                "name='" + name + '\'' +
                ", manufacturedYear=" + manufacturedYear +
                ", price=" + price +
                ", manufacturer='" + manufacturer + '\'' +
                '}';
    }
}
