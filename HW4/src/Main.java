import java.util.HashMap;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws Exception {
        HashMap<String, Integer> userList = new HashMap<>();
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
                System.out.println("Correct! Welcome back!");
                System.out.println("1. Show all users \n2. Create Quiz");
                int choice = input.nextInt();
                if (choice == 1) {
//                    User user = new User(null, null, null, userList);
//                    System.out.println(userList);
                }
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
                System.out.print("Confirm your password: ");
                String userConfirmPassword = input.nextLine();
                if (userPassword.equals(userConfirmPassword)){
                    User user = new User(userEmail, userPassword, userConfirmPassword, userList);
                    user.registration();
                }
                else {
                    throw new Exception("Password does not match!");
                }
            }
        }
        else {
            throw new Exception(String.format("Case %s is not found!", data));
        }

    }
}
