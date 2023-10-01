package reflections;

public class MyClass {

    private int number = 10;
    private String name = "China";

    //    public MyClass(int number, String name) {
//        this.number = number;
//        this.name = name;
//    }
    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void printData() {
        System.out.println("printData is called");
    }

    private void printSmth(String smth) {
        System.out.println(smth);
    }
}
