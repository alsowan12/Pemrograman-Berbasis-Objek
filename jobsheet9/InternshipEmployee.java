package jobsheet9;

public class InternshipEmployee  extends Employee{
    private int lenght;

    public InternshipEmployee(String name, int length){
        super(name);
        this.lenght = length;
    }

    public int getLenght(){
        return lenght;
    }

    public void setLenght(int length){
        this.lenght = length;
    }
    @Override
    public String getEmployeeInfo(){
        String info = super.getEmployeeInfo() + "\n";
        info += "Registered as internship employee for " + lenght + " month/s\n";
        return info;
    }
    
}
