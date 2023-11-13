package Ex1;

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
        return "Ex1.Money{" +
                "dollar=" + dollar +
                ", cent=" + cent +
                '}';
    }

    public void display() {
        System.out.println(dollar + " dollars " + cent + " cents");
    }

    public void add(int dollar, int cent) {
        this.dollar += dollar;
        this.cent += cent;
        if (this.cent >= 100) {
            this.dollar += this.cent / 100;
            this.cent %= 100;
        }
    }

    public void subtract(int dollar, int cent) {
        this.dollar -= dollar;
        this.cent -= cent;
        if (this.cent < 0) {
            this.dollar -= 1;
            this.cent += 100;
        }
    }
}



