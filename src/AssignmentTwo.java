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

    public void partFourA() {
        System.out.println("=== Part4A 乘坐历史功能演示 ===");
        Ride thunderstorm = new Ride("R002", "雷暴飞车", 4, null);

        Visitor v1 = new Visitor("V006", "汤姆", 35, "Adult", "2025-12-01");
        Visitor v2 = new Visitor("V007", "雪莉", 27, "Adult", "2025-12-01");
        Visitor v3 = new Visitor("V008", "本", 20, "Youth", "2025-12-01");
        Visitor v4 = new Visitor("V009", "大卫", 32, "Adult", "2025-12-01");
        Visitor v5 = new Visitor("V010", "露西", 24, "Adult", "2025-12-01");

        thunderstorm.addVisitorToHistory(v1);
        thunderstorm.addVisitorToHistory(v2);
        thunderstorm.addVisitorToHistory(v3);
        thunderstorm.addVisitorToHistory(v4);
        thunderstorm.addVisitorToHistory(v5);

        System.out.println("游客雪莉是否乘坐过？" + thunderstorm.checkVisitorFromHistory(v2));
        System.out.println("游客杰克是否乘坐过？" + thunderstorm.checkVisitorFromHistory(new Visitor("V001", "杰克", 25, "Adult", "2025-12-01")));

        System.out.println("乘坐总人数：" + thunderstorm.numberOfVisitors());
        thunderstorm.printRideHistory();
    }

    public void partFourB() {
        System.out.println("=== Part4B 排序功能演示 ===");
        Ride logRide = new Ride("R003", "原木漂流", 3, null);

        logRide.addVisitorToHistory(new Visitor("V011", "迈克", 28, "Adult", "2025-12-01"));
        logRide.addVisitorToHistory(new Visitor("V012", "安娜", 22, "Adult", "2025-12-01"));
        logRide.addVisitorToHistory(new Visitor("V013", "约翰", 28, "Adult", "2025-12-01"));
        logRide.addVisitorToHistory(new Visitor("V014", "莉莉", 19, "Youth", "2025-12-01"));
        logRide.addVisitorToHistory(new Visitor("V015", "鲍勃", 33, "Adult", "2025-12-01"));

        System.out.println("排序前：");
        logRide.printRideHistory();

        logRide.sortRideHistory(new VisitorComparator());

        System.out.println("排序后（年龄升序+姓名降序）：");
        logRide.printRideHistory();
    }

    public void partFive() {
        System.out.println("=== Part5 运行游乐设施演示 ===");
        Employee operator = new Employee("E002", "李四", 35, "EMP002", "海盗船操作员");
        Ride pirateShip = new Ride("R004", "海盗船", 3, operator);

        for (int i = 0; i < 10; i++) {
            pirateShip.addVisitorToQueue(new Visitor(
                    "V" + String.format("%03d", 20 + i),
                    "游客" + (i + 1),
                    18 + (i % 20),
                    "Adult",
                    "2025-12-01"
            ));
        }

        System.out.println("运行前等待队列：");
        pirateShip.printQueue();

        pirateShip.runOneCycle();

        System.out.println("运行后等待队列：");
        pirateShip.printQueue();
        System.out.println("运行后乘坐历史：");
        pirateShip.printRideHistory();
    }