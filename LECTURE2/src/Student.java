public class Student extends Person {

    public static void main(String[] args) {
        Student student=new Student();
        Person person=(Person) student;
    }

    String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
