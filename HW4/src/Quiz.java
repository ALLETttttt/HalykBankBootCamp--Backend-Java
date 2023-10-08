import java.util.HashMap;

public class Quiz {

    private HashMap<Question, Answer> quiz = new HashMap<Question, Answer>();

    public Quiz(HashMap<Question, Answer> quiz) {
        this.quiz = quiz;
    }

    public HashMap<Question, Answer> getQuiz() {
        return quiz;
    }

    public void setQuiz(HashMap<Question, Answer> quiz) {
        this.quiz = quiz;
    }

}
