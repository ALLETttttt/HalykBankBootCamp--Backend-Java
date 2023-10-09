package Menu;

import Classes.Quiz;
import Classes.User;
import Filters.SortByUserName;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.Collections;
import java.util.Map;
import java.util.TreeMap;

public class UserMenu {

    MainMenu mainMenu = new MainMenu();

    public void registration(User user, BufferedReader input) throws IOException {
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
            mainMenu.mainMenu();
        }
        else {
            throw new IOException("Entered wrong data!!!");
        }
    }

    public void login(User user, Quiz quiz, String email, BufferedReader input) throws IOException {
        System.out.println("User " + email + " welcome back!");
        System.out.println("What you want to do?");
        int choiceU = 0;
        while (choiceU != -1) {
            System.out.println("1. See Leader Board \n2. Start Quiz \n3. Log out");
            choiceU = Integer.parseInt(input.readLine());
            if (choiceU == 1) {
                user.showLeaderBoard();
            } else if (choiceU == 2) {
                quiz.getQuiz().forEach(
                        (key, value) -> {
                            System.out.println(key.getQuestion());
                            value.getOptions().forEach(
                                    (key1, value1) -> {
                                        System.out.println(key1);
                                    }
                            );
                            try {
                                System.out.print("Your answer: ");
                                String answer = input.readLine();
                                if (value.getOptions().containsKey(answer) && value.getOptions().get(answer)) {
                                    user.getLeaderBoard().put(email, user.getLeaderBoard().get(email) + 1);
                                }
                            } catch (IOException e) {
                                throw new RuntimeException(e);
                            }
                        }
                );
            } else if (choiceU == 3) {
                mainMenu.mainMenu();
            }
        }
    }
}
