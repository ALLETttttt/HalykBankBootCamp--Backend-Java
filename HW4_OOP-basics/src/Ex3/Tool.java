package Ex3;

public abstract class Tool {
    private String name;
    private String descr;
    private String history;

    public Tool(String name, String descr, String history) {
        this.name = name;
        this.descr = descr;
        this.history = history;
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }



    @Override
    public String toString() {
        return "Tool{" +
                "name='" + name + '\'' +
                ", descr='" + descr + '\'' +
                '}';
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescr() {
        return descr;
    }

    public void setDescr(String descr) {
        this.descr = descr;
    }

    public void sound() {
        System.out.println("Here you will listen the sound of a Tool");
    }

    public void show() {
        System.out.println("The Tool name is: " + this.name);
    }

    public void desc() {
        System.out.println("Description: " + this.descr);
    }

    public void history() {
        System.out.println("History: " + this.history);
    }
}
