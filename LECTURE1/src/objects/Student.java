package objects;

public class Student {

    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setAge(22);
        student1.setName("Dana");
        System.out.println(student1.getAge() + " " + student1.getName());

        Student student2 = new Student();
        student2.setAge(22);
        student2.setName("Alikhan");
        System.out.println(student2.getAge() + " " + student2.getName());

        boolean equals = student1.equals(student2);
    }

    private int age;
    private String name;

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "age=" + age + ", name='" + name;
    }
}
