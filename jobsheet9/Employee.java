package jobsheet9;

public class Employee {
    protected String name;

    public Employee(String name) {
        this.name = name;
    }

    public String getEmployeeInfo(){
        return "Name = " + name;
    }
}
