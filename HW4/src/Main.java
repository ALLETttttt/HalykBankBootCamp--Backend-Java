import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Welcome to Quiz App!");
        Quiz quiz = new Quiz();
        User user = new User();
        System.out.println("Enter the System!");
        System.out.println("1. Registration \n2. Login \n3. Admin Mode");
        int choice = Integer.parseInt(input.readLine());
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
            System.out.print("Email: ");
            String email = input.readLine();
            System.out.print("Password: ");
            String password = input.readLine();
            user.login(email, password);
            System.out.println(user.getEmail() + " user welcome back!");
            System.out.println("What you want to do?");
            System.out.println("1. See Leader Board \n2. Start Quiz");
            int choiceU = Integer.parseInt(input.readLine());
            if (choiceU == 1) {
                user.showAllUsers();
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
        } else if (choice == 3) {
            System.out.print("Email: ");
            String email = input.readLine();
            System.out.print("Password: ");
            String password = input.readLine();
            Admin admin = new Admin(email, password);
            if (admin.checkAdmin()) {
                System.out.println("Admin mode is entered!");
                System.out.println("1. See all existing users \n2. Create a Quiz");
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


}
