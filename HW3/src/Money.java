public class Money {
    private int dollar;
    private int cent;

    public Money(int dollar, int cent) {
        this.dollar = dollar;
        this.cent = cent;
    }

    public int getCent() {
        return cent;
    }

    public void setCent(int cent) {
        this.cent = cent;
    }

    public int getDollar() {
        return dollar;
    }

    public void setDollar(int dollar) {
        this.dollar = dollar;
    }

    @Override
    public String toString() {
        return "Money{" +
                "dollar=" + dollar +
                ", cent=" + cent +
                '}';
    }

    public void getSum() {
        System.out.println(dollar + "$" + cent + "Cent");
    }
}
