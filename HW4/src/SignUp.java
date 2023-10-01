public class SignUp extends Authentication {
    private String confirmPass;

    public SignUp(String email, String password, String confirmPass) {
        super(email, password);
        this.confirmPass = confirmPass;
    }

    public String getConfirmPass() {
        return confirmPass;
    }

    public void setConfirmPass(String confirmPass) {
        this.confirmPass = confirmPass;
    }

    @Override
    public boolean equals(Object o) {
        return super.equals(o);
    }

    @Override
    public int hashCode() {
        return super.hashCode();
    }

}
