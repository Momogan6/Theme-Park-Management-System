import java.io.*;
import java.util.*;

public class Ride implements RideInterface {
    // 3 instance variables (including Employee type)
    private String rideId;
    private String rideName;
    private int maxRider; // Part 5 added: Maximum number of passengers per round
    private int numOfCycles; // Part 5 added: Number of runs
    private Employee operator; // The employee responsible for the facility
    private Queue<Visitor> waitingLine;
    private LinkedList<Visitor> rideHistory;

    // Default constructor
    public Ride() {
        this.waitingLine = new LinkedList<>();
        this.rideHistory = new LinkedList<>();
        this.numOfCycles = 0;
    }

    // Constructor with parameters
    public Ride(String rideId, String rideName, int maxRider, Employee operator) {
        this();
        this.rideId = rideId;
        this.rideName = rideName;
        this.maxRider = maxRider;
        this.operator = operator;
    }

    // Getter and Setter
    public String getRideId() { return rideId; }
    public void setRideId(String rideId) { this.rideId = rideId; }
    public String getRideName() { return rideName; }
    public void setRideName(String rideName) { this.rideName = rideName; }
    public int getMaxRider() { return maxRider; }
    public void setMaxRider(int maxRider) { this.maxRider = maxRider; }
    public int getNumOfCycles() { return numOfCycles; }
    public Employee getOperator() { return operator; }
    public void setOperator(Employee operator) { this.operator = operator; }

    // Part 3: Queue Operation Method
    @Override
    public void addVisitorToQueue(Visitor visitor) {
        if (visitor != null) {
            waitingLine.offer(visitor);
            System.out.println("Successfully added tourist" + visitor.getName() + "to" + rideName + "waiting queue");
        } else {
            System.out.println("Add failed: Tourist information is empty");
        }
    }

    @Override
    public void removeVisitorFromQueue() {
        if (waitingLine.isEmpty()) {
            System.out.println("Removal failed:" + rideName + "Waiting queue is empty");
            return;
        }
        Visitor removed = waitingLine.poll();
        System.out.println("Successfully removed tourists from the waiting queue:" + removed.getName());
    }

    @Override
    public void printQueue() {
        if (waitingLine.isEmpty()) {
            System.out.println(rideName + "Waiting queue is empty");
            return;
        }
        System.out.println(rideName + "Waiting queue (a total of " + waitingLine.size() + " people)：");
        int index = 1;
        for (Visitor visitor : waitingLine) {
            System.out.println(index + ". " + visitor);
            index++;
        }
    }

    // Part 4A: Riding history operation method
    @Override
    public void addVisitorToHistory(Visitor visitor) {
        if (visitor != null) {
            rideHistory.add(visitor);
            System.out.println("Successfully recorded tourists" + visitor.getName() + "to" + rideName + "Riding history");
        } else {
            System.out.println("Record failed: Tourist information is empty");
        }
    }

    @Override
    public boolean checkVisitorFromHistory(Visitor visitor) {
        if (visitor == null || rideHistory.isEmpty()) {
            return false;
        }
        for (Visitor v : rideHistory) {
            if (v.getId().equals(visitor.getId())) {
                return true;
            }
        }
        return false;
    }

    @Override
    public int numberOfVisitors() {
        return rideHistory.size();
    }

    @Override
    public void printRideHistory() {
        if (rideHistory.isEmpty()) {
            System.out.println(rideName + "No ride history available at the moment");
            return;
        }
        System.out.println(rideName + "Riding history (a total of " + rideHistory.size() + " people)：");
        Iterator<Visitor> iterator = rideHistory.iterator();
        int index = 1;
        while (iterator.hasNext()) {
            Visitor visitor = iterator.next();
            System.out.println(index + ". " + visitor);
            index++;
        }
    }

    // Part 4B: Sorting method (using a comparator)
    public void sortRideHistory(Comparator<Visitor> comparator) {
        if (comparator == null) {
            System.out.println("Sorting failed: comparator is empty");
            return;
        }
        Collections.sort(rideHistory, comparator);
        System.out.println(rideName + "Travel history sorting completed");
    }

    // Part 5: Running a round of amusement facilities
    @Override
    public void runOneCycle() {
        // Check if there is an operator present
        if (operator == null) {
            System.out.println("Running failed:" + rideName + "Unallocated operator");
            return;
        }
        // Check if there are any waiting tourists
        if (waitingLine.isEmpty()) {
            System.out.println("Running failed:" + rideName + "Waiting queue is empty");
            return;
        }

        System.out.println("Start running" + rideName + "No." + (numOfCycles + 1) + "Wheel (maximum " + maxRider + " people)");
        int count = 0;
        // Retrieve tourists from the queue and add them to history
        while (!waitingLine.isEmpty() && count < maxRider) {
            Visitor visitor = waitingLine.poll();
            addVisitorToHistory(visitor);
            count++;
        }
        numOfCycles++;
        System.out.println(rideName + "No." + numOfCycles + "wheel running completed, this ride" + count + "people");
    }

    // Part 6: Export ride history to CSV file
    public void exportRideHistory(String filePath) {
        if (rideHistory.isEmpty()) {
            System.out.println("Export failed:" + rideName + "No ride history available at the moment");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
            for (Visitor visitor : rideHistory) {
                writer.write(visitor.toString());
                writer.newLine();
            }
            System.out.println("Successfully exported" + rideName + "Riding history to:" + filePath);
        } catch (IOException e) {
            System.out.println("Export failed:" + e.getMessage());
        }
    }

    // Part 7: Importing Ride History from CSV File
    public void importRideHistory(String filePath) {
        File file = new File(filePath);
        if (!file.exists()) {
            System.out.println("Import failed: file" + filePath + "does not exist");
            return;
        }

        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            int importCount = 0;
            while ((line = reader.readLine()) != null) {
                if (line.trim().isEmpty()) continue;
                String[] parts = line.split(",");
                // Analyze CSV data (corresponding to Visitor's toString format)
                if (parts.length == 5) {
                    Visitor visitor = new Visitor(
                            parts[0], parts[1], Integer.parseInt(parts[2]),
                            parts[3], parts[4]
                    );
                    rideHistory.add(visitor);
                    importCount++;
                } else {
                    System.out.println("Skip invalid data rows:" + line);
                }
            }
            System.out.println("Success from" + filePath + "import" + importCount + "Tourist Records");
        } catch (IOException | NumberFormatException e) {
            System.out.println("Import failed:" + e.getMessage());
        }
    }
}