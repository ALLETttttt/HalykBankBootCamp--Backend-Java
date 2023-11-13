package Ex7;

public class Car {
    private String name;
    private String manufacturer;
    private int year;
    private double engineVolume;

    public Car() {

    }

    public Car(String name, String manufacturer, int year, double engineVolume) {
        this.name = name;
        this.manufacturer = manufacturer;
        this.year = year;
        this.engineVolume = engineVolume;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public void setEngineVolume(String engineVolume) {
        try {
            this.engineVolume = Double.parseDouble(engineVolume);
        } catch (NumberFormatException e) {
            System.out.println("Ошибка: Неверный формат количества страниц.");
        }
    }

    public void displayInfo() {
        System.out.println("Название автомобиля: " + name);
        System.out.println("Производитель: " + manufacturer);
        System.out.println("Год выпуска: " + year);
        System.out.println("Объём двигателя: " + engineVolume + " литра");
    }
}
