import java.util.HashMap;

public class User extends Person {

    private String confirmPassword;
    private HashMap<String, Integer> userList;
    public User(String email, String password, String confirmPassword, HashMap<String, Integer> userList) {
        super(email, password);
        this.userList = userList;
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
        getUserList().forEach(
                (key, value) ->
                        System.out.println("User: " + key + "->" + "points: " + value)
        );
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
