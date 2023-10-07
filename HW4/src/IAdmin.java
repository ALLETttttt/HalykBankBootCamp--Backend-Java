public interface IAdmin {
    boolean checkAdmin();

    void showAllUsers(User user);

    void createQuiz(Quiz quiz);
}
