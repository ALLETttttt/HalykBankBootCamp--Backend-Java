package Ex6;

public class Main {
    public static void main(String[] args) {
        Book book1 = new Book("Война и мир", "Лев Толстой", 1869, "Издательство А", "Роман", 1225);

        book1.displayInfo();

        System.out.println();

        Book book2 = new Book();
        book2.setTitle("Преступление и наказание");
        book2.setAuthor("Федор Достоевский");
        book2.setYear(1866);
        book2.setPublisher("Издательство Б");
        book2.setGenre("Роман");
        book2.setPageCount(331);
        book2.setPageCount("332");

        book2.displayInfo();
    }
}
