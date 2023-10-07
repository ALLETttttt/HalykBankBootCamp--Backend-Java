import java.util.HashMap;

public class User extends Person implements IUser {
    private int counter;

    public HashMap<String, String> userList = new HashMap<String, String>();

    public User(String email, String password) {
        super(email, password);
        this.counter = 0;
    }

    public int getCounter() {
        return counter;
    }

    public void setCounter(int counter) {
        this.counter = counter;
    }

    public HashMap<String, String> getUserList() {
        return this.userList;
    }

    public void setUserList(HashMap<String, String> userList) {
        this.userList = userList;
    }

    @Override
    public void registration() {
        getUserList().put(getEmail(), getPassword());
        System.out.println("Registration done successfully!!!");
    }

    @Override
    public boolean login(String email, String password) {
        return getUserList().containsKey(email) && getUserList().containsValue(password);
    }

    public void showAllUsers() {
        getUserList().forEach(
                (key, value) ->
                        System.out.println("User: " + key + " -> Points: " + value)
        );
    }


}
