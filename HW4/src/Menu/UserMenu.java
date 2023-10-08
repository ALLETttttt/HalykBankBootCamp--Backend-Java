package Menu;

import Classes.Quiz;
import Classes.User;

import java.io.BufferedReader;
import java.io.IOException;

public class UserMenu {

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
        }
    }

    public void login(User user, Quiz quiz, BufferedReader input) throws IOException {
        System.out.print("Email: ");
        String email = input.readLine();
        System.out.print("Password: ");
        String password = input.readLine();
        user.login(email, password);
        System.out.println(user.getEmail() + " user welcome back!");
        System.out.println("What you want to do?");
        System.out.println("1. See Leader Board \n2. Start Classes.Quiz");
        int choiceU = Integer.parseInt(input.readLine());
        if (choiceU == 1) {
            user.showLeaderBoard();
        } else if (choiceU == 2) {
            quiz.getQuiz().forEach(
                    (key, value) -> {
                        System.out.println(key);
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
        }
    }
}
