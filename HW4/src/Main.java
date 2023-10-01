import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        System.out.println("Welcome to Quiz App!");
        System.out.println("In which role you want to enter the system?");
        System.out.println("Admin --> A || User --> U");
        Scanner input = new Scanner(System.in);
        String data = input.nextLine();
        if (Objects.equals(data, "A")) {
            System.out.println("Verify that you are Admin");
            System.out.println("Email: ");
            String email = input.nextLine();
            System.out.println("Password: ");
            String password = input.nextLine();
            Admin admin = new Admin(email, password);
            if (admin.checkAdmin()) {
                System.out.println("Correct!");
            }
        } else if (Objects.equals(data, "U")) {
            System.out.println();
        }
        else {
            throw new Exception(String.format("Case %s is not found", data));
        }

    }
}
