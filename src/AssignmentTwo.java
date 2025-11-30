public class AssignmentTwo {
    public static void main(String[] args) {
        AssignmentTwo assignment = new AssignmentTwo();

        // Run each module in sequence for demonstration
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

    // Part 3: Queue Function Demonstration
    public void partThree() {
        System.out.println("=== Part 3 Queue Function Demonstration ===");
        // Create operator
        Employee operator = new Employee("E001", "Zhang San", 30, "EMP001", "Roller Coaster Operator");
        // Create amusement facilities
        Ride rollerCoaster = new Ride("R001", "roller coaster", 2, operator);

        // Add 5 tourists to the queue
        rollerCoaster.addVisitorToQueue(new Visitor("V001", "Jack", 25, "Adult", "2025-12-01"));
        rollerCoaster.addVisitorToQueue(new Visitor("V002", "Sharon", 22, "Adult", "2025-12-01"));
        rollerCoaster.addVisitorToQueue(new Visitor("V003", "Benny", 18, "Youth", "2025-12-01"));
        rollerCoaster.addVisitorToQueue(new Visitor("V004", "Leo", 30, "Adult", "2025-12-01"));
        rollerCoaster.addVisitorToQueue(new Visitor("V005", "Amy", 28, "Adult", "2025-12-01"));

        // Print queue
        rollerCoaster.printQueue();
        // Remove a tourist
        rollerCoaster.removeVisitorFromQueue();
        // Print queue again
        System.out.println("After removing a tourist:");
        rollerCoaster.printQueue();
    }

    // Part 4A: Demonstration of Riding History Function
    public void partFourA() {
        System.out.println("=== Part 4A Ride History Function Demonstration ===");
        Ride thunderstorm = new Ride("R002", "Thunderstorm flying car", 4, null);

        // Add 5 tourists to history
        Visitor v1 = new Visitor("V006", "Tom", 35, "Adult", "2025-12-01");
        Visitor v2 = new Visitor("V007", "Sherry", 27, "Adult", "2025-12-01");
        Visitor v3 = new Visitor("V008", "Ben", 20, "Youth", "2025-12-01");
        Visitor v4 = new Visitor("V009", "David", 32, "Adult", "2025-12-01");
        Visitor v5 = new Visitor("V010", "Lucy", 24, "Adult", "2025-12-01");

        thunderstorm.addVisitorToHistory(v1);
        thunderstorm.addVisitorToHistory(v2);
        thunderstorm.addVisitorToHistory(v3);
        thunderstorm.addVisitorToHistory(v4);
        thunderstorm.addVisitorToHistory(v5);

        // Check if tourists are in history
        System.out.println("Has tourist Sherry taken it before?" + thunderstorm.checkVisitorFromHistory(v2));
        System.out.println("Has tourist Jack ever taken it?" + thunderstorm.checkVisitorFromHistory(new Visitor("V001", "Jack", 25, "Adult", "2025-12-01")));

        // Print the number and details of historical records
        System.out.println("Total number of passengers:" + thunderstorm.numberOfVisitors());
        thunderstorm.printRideHistory();
    }

    // Part 4B: Sorting Function Demonstration
    public void partFourB() {
        System.out.println("=== Part 4B Sorting Function Demonstration ===");
        Ride logRide = new Ride("R003", "Drifting of logs", 3, null);

        // Add 5 tourists
        logRide.addVisitorToHistory(new Visitor("V011", "Mike", 28, "Adult", "2025-12-01"));
        logRide.addVisitorToHistory(new Visitor("V012", "Anna", 22, "Adult", "2025-12-01"));
        logRide.addVisitorToHistory(new Visitor("V013", "John", 28, "Adult", "2025-12-01"));
        logRide.addVisitorToHistory(new Visitor("V014", "Lily", 19, "Youth", "2025-12-01"));
        logRide.addVisitorToHistory(new Visitor("V015", "Bob", 33, "Adult", "2025-12-01"));

        // Before sorting
        System.out.println("Before sorting:");
        logRide.printRideHistory();

        // Sort by age+name
        logRide.sortRideHistory(new VisitorComparator());

        // Sorted
        System.out.println("After sorting (age ascending+name descending):");
        logRide.printRideHistory();
    }

    // Part 5: Demonstration of Running Amusement Facilities
    public void partFive() {
        System.out.println("=== Part 5 Demonstration of Running Amusement Facilities ===");
        // Create operator
        Employee operator = new Employee("E002", "Li Si", 35, "EMP002", "Pirate ship operator");
        // Create amusement facilities (maximum of 3 people per round)
        Ride pirateShip = new Ride("R004", "Pirate Ship", 3, operator);

        // Add 10 tourists to the queue
        for (int i = 0; i < 10; i++) {
            pirateShip.addVisitorToQueue(new Visitor(
                    "V" + String.format("%03d", 20 + i),
                    "tourist" + (i + 1),
                    18 + (i % 20),
                    "Adult",
                    "2025-12-01"
            ));
        }

        // Print queue before running
        System.out.println("Waiting queue before running:");
        pirateShip.printQueue();

        // Run one round
        pirateShip.runOneCycle();

        // Print queue and history after running
        System.out.println("Wait queue after running:");
        pirateShip.printQueue();
        System.out.println("Ride history after operation:");
        pirateShip.printRideHistory();
    }

    // Part 6: Export Function Demonstration
    public void partSix() {
        System.out.println("=== Part 6 Export Function Demonstration ===");
        Ride ferrisWheel = new Ride("R005", "Ferris wheel", 6, null);

        // Add 5 tourists
        ferrisWheel.addVisitorToHistory(new Visitor("V030", "Alice", 26, "Adult", "2025-12-01"));
        ferrisWheel.addVisitorToHistory(new Visitor("V031", "Charlie", 30, "Adult", "2025-12-01"));
        ferrisWheel.addVisitorToHistory(new Visitor("V032", "Daisy", 24, "Adult", "2025-12-01"));
        ferrisWheel.addVisitorToHistory(new Visitor("V033", "Ethan", 29, "Adult", "2025-12-01"));
        ferrisWheel.addVisitorToHistory(new Visitor("V034", "Phoebe", 27, "Adult", "2025-12-01"));

        // Export to CSV file
        ferrisWheel.exportRideHistory("ferris_wheel_history.csv");
    }

    // Part 7: Import Function Demonstration
    public void partSeven() {
        System.out.println("=== Part 7 Import Function Demonstration ===");
        Ride importRide = new Ride("R006", "Import testing facilities", 5, null);

        // Import CSV file before
        importRide.importRideHistory("ferris_wheel_history.csv");

        // Verify import results
        System.out.println("Total number of imported tourists:" + importRide.numberOfVisitors());
        importRide.printRideHistory();
    }
}