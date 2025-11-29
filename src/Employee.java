public class Employee extends Person {
    // 2 exclusive instance variables
    private String employeeId;
    private String position;

    // Default constructor
    public Employee() {}

    // Constructor with parameters (including parent class properties)
    public Employee(String id, String name, int age, String employeeId, String position) {
        super(id, name, age);
        this.employeeId = employeeId;
        this.position = position;
    }

    // Getter and Setter
    public String getEmployeeId() { return employeeId; }
    public void setEmployeeId(String employeeId) { this.employeeId = employeeId; }
    public String getPosition() { return position; }
    public void setPosition(String position) { this.position = position; }

    @Override
    public String toString() {
        return super.toString() + "," + employeeId + "," + position;
    }
}