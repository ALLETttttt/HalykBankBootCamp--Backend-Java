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
