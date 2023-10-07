import java.util.HashMap;

public class Answer implements IAnswer {
    private HashMap<String, Boolean> options = new HashMap<String, Boolean>();

    public HashMap<String, Boolean> getOptions() {
        return options;
    }

    public void setOptions(HashMap<String, Boolean> options) {
        this.options = options;
    }

    @Override
    public void createOptions() {
        for (int i = 0; i < 4; i++) {

        }
    }
}
