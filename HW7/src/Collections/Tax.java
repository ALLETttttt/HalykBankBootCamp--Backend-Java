package Collections;

public class Tax {

    private String personName;
    private String typeOfTax;
    private String city;

    public Tax(String personName, String typeOfTax, String city) {
        this.personName = personName;
        this.typeOfTax = typeOfTax;
        this.city = city;
    }

    public String getPersonName() {
        return personName;
    }

    public void setPersonName(String personName) {
        this.personName = personName;
    }

    public String getTypeOfTax() {
        return typeOfTax;
    }

    public void setTypeOfTax(String typeOfTax) {
        this.typeOfTax = typeOfTax;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public String toString() {
        return "Tax{" +
                "personName='" + personName + '\'' +
                ", typeOfTax='" + typeOfTax + '\'' +
                ", city='" + city + '\'' +
                '}';
    }

}
