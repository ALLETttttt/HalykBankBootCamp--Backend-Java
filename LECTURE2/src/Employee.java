public class Employee extends Person{

    public interface IGetSalaryService{
        int getSalary();
    }

    private String company;

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }
}
