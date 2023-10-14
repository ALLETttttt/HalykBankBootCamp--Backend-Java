package ionio;

public enum Param {

    URL("C:/IdeaProjects/justcode/src/lecture5/ionio/java.txt");

    private final String value;

    Param(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }
}
