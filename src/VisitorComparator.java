import java.util.Comparator;

// Sort by ascending age+descending name
public class VisitorComparator implements Comparator<Visitor> {
    @Override
    public int compare(Visitor v1, Visitor v2) {
        // Compare by age first
        int ageCompare = Integer.compare(v1.getAge(), v2.getAge());
        if (ageCompare != 0) {
            return ageCompare;
        }
        // If the age is the same, sort by name in descending order
        return v2.getName().compareTo(v1.getName());
    }
}