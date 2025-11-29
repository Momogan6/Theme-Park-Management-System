public abstract class Person {
    // 3 instance variables
    private String id;
    private String name;
    private int age;

    // Default constructor
    public Person() {}

    // Constructor with parameters
    public Person(String id, String name, int age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // Getter and Setter
    public String getId() { return id; }
    public void setId(String id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public int getAge() { return age; }
    public void setAge(int age) { this.age = age; }

    // Rewrite toString for easy printing
    @Override
    public String toString() {
        return id + "," + name + "," + age;
    }
}