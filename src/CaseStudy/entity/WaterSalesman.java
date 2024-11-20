package CaseStudy.entity;
public class WaterSalesman extends Sale {
    private int salary;
    private String position;
    private String address;

    public WaterSalesman() {
    }

    public WaterSalesman(int id, String name, String address, int salary, String position) {
        super(id, name);
        this.address = address;
        this.salary = salary;
        this.position = position;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    @Override
    public String toString() {
        return "WaterSales: " + "id=" + this.getId() + ", name='" + this.getName() + ", address=" + this.getAddress()
                + ", salary=" + this.getSalary() + ", position=" + this.getPosition();
    }


}
