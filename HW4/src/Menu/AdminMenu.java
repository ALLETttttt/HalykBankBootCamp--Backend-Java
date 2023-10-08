package Menu;

import Classes.*;

import java.io.BufferedReader;
import java.io.IOException;

public class AdminMenu {

    public void enterAdminMode(User user, Quiz quiz, BufferedReader input) throws IOException {
        System.out.print("Email: ");
        String email = input.readLine();
        System.out.print("Password: ");
        String password = input.readLine();
        Admin admin = new Admin(email, password);
        if (admin.checkAdmin()) {
            System.out.println("Classes.Admin mode is entered!");
            System.out.println("1. See all existing users \n2. Create a Classes.Quiz");
            int choiceA = Integer.parseInt(input.readLine());
            if (choiceA == 1) {
                admin.showAllUsers(user);
            } else if (choiceA == 2) {
                System.out.println("How many questions you wanna add? ");
                int size = Integer.parseInt(input.readLine());
                Answer answer = new Answer();
                for (int i = 1; i <= size; i++) {
                    System.out.print("Type your " + i + " question: ");
                    Question question = new Question(input.readLine());
                    System.out.println("Options to choose: ");
                    for (char j = 'A'; j <= 'D'; j++) {
                        System.out.print("Option " + j + ": ");
                        String option = input.readLine();
                        System.out.print("Condition: ");
                        boolean condition = Boolean.parseBoolean(input.readLine());
                        answer.getOptions().put(option, condition);
                    }
                    admin.createQuiz(quiz, question, answer);
                }
            }
        }
    }
}
