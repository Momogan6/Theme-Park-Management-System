public class Visitor extends Person {
    // 2 exclusive instance variables
    private String visitorType; // Such as "Adult", "Child", "Senior"
    private String visitDate;

    // Default constructor
    public Visitor() {}

    // Constructor with parameters (including parent class properties)
    public Visitor(String id, String name, int age, String visitorType, String visitDate) {
        super(id, name, age);
        this.visitorType = visitorType;
        this.visitDate = visitDate;
    }

    // Getter and Setter
    public String getVisitorType() { return visitorType; }
    public void setVisitorType(String visitorType) { this.visitorType = visitorType; }
    public String getVisitDate() { return visitDate; }
    public void setVisitDate(String visitDate) { this.visitDate = visitDate; }

    @Override
    public String toString() {
        return super.toString() + "," + visitorType + "," + visitDate;
    }
}