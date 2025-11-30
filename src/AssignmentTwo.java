public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();

        assignment.partThree();
        System.out.println("------------------------");
        assignment.partFourA();
        System.out.println("------------------------");
        assignment.partFourB();
        System.out.println("------------------------");
        assignment.partFive();
        System.out.println("------------------------");
        assignment.partSix();
        System.out.println("------------------------");
        assignment.partSeven();
    }

    public void partThree() {
        System.out.println("=== Part3 队列功能演示 ===");
        Employee operator = new Employee("E001", "张三", 30, "EMP001", "过山车操作员");
        Ride rollerCoaster = new Ride("R001", "过山车", 2, operator);

        rollerCoaster.addVisitorToQueue(new Visitor("V001", "杰克", 25, "Adult", "2025-12-01"));
        rollerCoaster.addVisitorToQueue(new Visitor("V002", "莎伦", 22, "Adult", "2025-12-01"));
        rollerCoaster.addVisitorToQueue(new Visitor("V003", "本尼", 18, "Youth", "2025-12-01"));
        rollerCoaster.addVisitorToQueue(new Visitor("V004", "利奥", 30, "Adult", "2025-12-01"));
        rollerCoaster.addVisitorToQueue(new Visitor("V005", "艾米", 28, "Adult", "2025-12-01"));

        rollerCoaster.printQueue();
        rollerCoaster.removeVisitorFromQueue();
        System.out.println("移除一名游客后：");
        rollerCoaster.printQueue();
    }