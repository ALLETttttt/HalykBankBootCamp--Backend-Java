import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome  to Quiz App!");
        User user = new User();
        while (true) {
            System.out.println("Enter the System!");
            System.out.println("1. Registration \n2. Login \n3.Admin Mode");
            int choice = input.read();
            if (choice == 1) {
                System.out.print("Email: ");
                String email = input.readLine();
                System.out.print("Password: ");
                String password = input.readLine();
                System.out.print("Confirm your password: ");
                String confPassword = input.readLine();
                if (password.equals(confPassword)) {
                    user.setEmail(email);
                    user.setPassword(password);
                    user.registration();
                }
            } else if (choice == 2) {

            }
        }
    }


}
