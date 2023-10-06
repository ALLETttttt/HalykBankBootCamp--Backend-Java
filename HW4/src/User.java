import java.util.HashMap;

public class User extends Person {

    private String confirmPassword;
    public HashMap<String, Integer> userList = new HashMap<String, Integer>();
    public User(String email, String password, String confirmPassword) {
        super(email, password);
        this.confirmPassword = confirmPassword;
    }

    public HashMap<String, Integer> getUserList() {
        return this.userList;
    }

    public void setUserList(HashMap<String, Integer> userList) {
        this.userList = userList;
    }

    public void registration() {
        getUserList().put(getEmail(), 0);
        System.out.println("Registration done successfully!!!");
    }

    public void showAllUsers() {
        getUserList().forEach(
                (key, value) ->
                        System.out.println("User: " + key + " -> Points: " + value)
        );
    }


    public String getConfirmPassword() {
        return confirmPassword;
    }

    public void setConfirmPassword(String confirmPassword) {
        this.confirmPassword = confirmPassword;
    }
}
