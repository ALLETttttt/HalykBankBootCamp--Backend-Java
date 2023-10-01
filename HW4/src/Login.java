public class Login extends Authentication implements CheckUser {
    public Login(String email, String password) {
        super(email, password);
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    @Override
    public boolean checkUser(Login user) {
        return equals(user);
    }
}
