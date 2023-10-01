public class Admin extends Person implements IAdmin {
    public Admin(String email, String password) {
        super(email, password);
    }

    public String getAdminEmail() {
        return "kz@kbtu.kz";
    }

    public String getAdminPassword() {
        return "123";
    }


    @Override
    public boolean checkAdmin() {
        return getEmail().equals(getAdminEmail()) && getPassword().equals(getAdminPassword());
    }

    @Override
    public void createQuiz() {

    }
}
