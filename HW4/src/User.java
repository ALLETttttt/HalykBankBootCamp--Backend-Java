import java.util.HashMap;

public class User extends Person implements IUser {


    public HashMap<String, String> userList = new HashMap<String, String>();
    public HashMap<String, Integer> leaderBoard = new HashMap<String, Integer>();

    public User(String email, String password) {
        super(email, password);
    }

    public User() {
        super();
    }


    public HashMap<String, String> getUserList() {
        return this.userList;
    }

    public void setUserList(HashMap<String, String> userList) {
        this.userList = userList;
    }

    public HashMap<String, Integer> getLeaderBoard() {
        return leaderBoard;
    }

    public void setLeaderBoard(HashMap<String, Integer> leaderBoard) {
        this.leaderBoard = leaderBoard;
    }

    @Override
    public void registration() {
        getUserList().put(getEmail(), getPassword());
        getLeaderBoard().put(getEmail(), 0);
        System.out.println("Registration done successfully!!!");
    }

    @Override
    public boolean login(String email, String password) {
        return getUserList().containsKey(email) && getUserList().containsValue(password);
    }

    @Override
    public void showLeaderBoard() {
        getLeaderBoard().forEach(
                (key, value) ->
                        System.out.println("User: " + key + " -> Points: " + value)
        );
    }


    public void showAllUsers() {
        getUserList().forEach(
                (key, value) ->
                        System.out.println("User: " + key + " -> Password: " + value)
        );
    }



}
