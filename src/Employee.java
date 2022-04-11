public class Employee implements Component{

    private String last_name;
    private int salary;

    public Employee(String last_name, int salary) {
        this.last_name = last_name;
        this.salary = salary;
    }


    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }


    @Override
    public void increaseTheSalary(int value) {
        salary += value;
    }

    @Override
    public void decreaseTheSalary(int value) {
        salary -= value;
    }

    @Override
    public int getPayslip() {
        return salary;
    }

    @Override
    public void getInformation() {
        System.out.println(last_name + " " + salary);
    }


    @Override
    public String toString() {
        return "Employee{" +
                "last_name='" + last_name + '\'' +
                ", salary=" + salary +
                '}';
    }
}
