package Menu;

import Classes.Quiz;
import Classes.User;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu {
    public void mainMenu() throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to Classes.Quiz App!");
        Quiz quiz = new Quiz();
        User user = new User();
        System.out.println("Enter the System!");
        System.out.println("1. Registration \n2. Login \n3. Classes.Admin Mode");
        int choice = Integer.parseInt(input.readLine());
        UserMenu userMenu = new UserMenu();
        if (choice == 1) {
            userMenu.registration(user, input);
        } else if (choice == 2) {
            userMenu.login(user, quiz, input);
        } else if (choice == 3) {
            AdminMenu adminMenu = new AdminMenu();
            adminMenu.enterAdminMode(user, quiz, input);
        }
    }
}
