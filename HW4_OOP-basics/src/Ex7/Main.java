/*
Задание 6
Реализуйте класс «Автомобиль». Необходимо хранить
в полях класса: название автомобиля, название производителя, год выпуска, объём двигателя. Реализуйте конструкторы и методы класса для ввода данных, вывода данных,
реализуйте доступ к отдельным полям через методы класса.
Используйте механизм перегрузки методов
 */

package Ex7;

public class Main {
    public static void main(String[] args) {
        Car car1 = new Car("Модель S", "Tesla", 2021, 2.0);

        car1.displayInfo();

        System.out.println();

        Car car2 = new Car();
        car2.setName("Civic");
        car2.setManufacturer("Honda");
        car2.setYear(2022);
        car2.setEngineVolume(1.5);
        car2.setEngineVolume("1.2");

        car2.displayInfo();
    }
}
