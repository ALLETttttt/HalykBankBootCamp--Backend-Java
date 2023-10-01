import java.util.HashMap;
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
            System.out.print("Email: ");
            String email = input.nextLine();
            System.out.print("Password: ");
            String password = input.nextLine();
            Admin admin = new Admin(email, password);
            if (admin.checkAdmin()) {
                System.out.println("Correct!");
            }
        } else if (Objects.equals(data, "U")) {
            System.out.println("Registration --> R || Login --> L");
            String enter = input.nextLine();
            if (Objects.equals(enter, "R")) {
                System.out.println("Enter your data");
                System.out.print("Email: ");
                String userEmail = input.nextLine();
                System.out.print("Password: ");
                String userPassword = input.nextLine();
                System.out.print("Confirm your password");
                String userConfirmPassword = input.nextLine();
                if (userPassword.equals(userConfirmPassword)){
                    HashMap<String, String> hm = new HashMap<>();
                    User user = new User(userEmail, userPassword, userConfirmPassword, hm);
                    user.registration();
                }
                else {
                    throw new Exception("Password do not match!");
                }
            }
        }
        else {
            throw new Exception(String.format("Case %s is not found", data));
        }

    }
}
