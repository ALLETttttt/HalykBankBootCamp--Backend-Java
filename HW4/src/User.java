import java.util.HashMap;

public class User extends Person {

    private String confirmPassword;
    private final HashMap<String, String> userList;
    public User(String email, String password, String confirmPassword, HashMap<String, String> userList) {
        super(email, password);
        this.userList = userList;
        this.confirmPassword = confirmPassword;
    }

    public void registration() {
        userList.put(getEmail(), getPassword());
        System.out.println("Registration done successfully!!!");
    }

    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
