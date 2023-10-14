package Stream.Ex3;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        List<Device> devices = new ArrayList<>();

        devices.add(new Device("Laptop", "2021", 1500, "Silver", DeviceType.computer));
        devices.add(new Device("Smartphone", "2022", 800, "Black", DeviceType.phone));
        devices.add(new Device("Airpods pro 2", "2020", 600, "White", DeviceType.airpods));
        devices.add(new Device("Smartwatch", "2022", 300, "Black", DeviceType.watch));
        devices.add(new Device("TV", "2019", 1200, "Black", DeviceType.tv));

        System.out.println("Show all devices: ");
        devices.forEach(System.out::println);

        String colorFilter = "Black";
        System.out.println("Specified" + colorFilter + "color on all devices");
        devices.stream()
                .filter(device -> device.getColor().equalsIgnoreCase(colorFilter))
                .forEach(System.out::println);

        String year = "2022";
        System.out.println("Specified" + year + "year on all devices");
        devices.stream()
                .filter(device -> device.getManufacturedYear().equalsIgnoreCase(year))
                .forEach(System.out::println);

    }
}
