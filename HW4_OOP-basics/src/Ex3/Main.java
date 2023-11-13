/*
Задание 3
Создать базовый класс «Музыкальный инструмент»
и производные классы «Скрипка», «Тромбон», «Укулеле»,
«Виолончель». С помощью конструктора установить имя
каждого музыкального инструмента и его характеристики.
Реализуйте для каждого из классов методы:
■ Sound — издает звук музыкального инструмента
(пишем текстом в консоль);
■ Show — отображает название музыкального инструмента;
■ Desc — отображает описание музыкального инструмента;
■ History — отображает историю создания музыкального инструмента.
 */


package Ex3;

public class Main {
    public static void main(String[] args) {
        Cello c = new Cello("cello", "cool tool", "very good history");
        c.show();
        c.sound();
        c.desc();
        c.history();
        System.out.println();

        Trombone t = new Trombone("trombone", "awesome", "historical history");
        t.sound();
        t.show();
        t.desc();
        t.history();
        System.out.println();

        Ukulele u = new Ukulele("", "", "");
        u.desc();
        System.out.println();
        Violin v = new Violin("violin", "wonderful tool", "history unknown");
        v.history();
    }
}
