import java.util.Arrays;
public class Student {
    private String name;
    private int[] estimates;

    // Constructor
    public Student(String name, int[] estimates) {
        this.name = name;
        this.estimates = estimates;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int[] getEstimates() {
        return estimates;
    }

    public void setEstimates(int[] estimates) {
        this.estimates = estimates;
    }

    // toString method
    @Override
    public String toString() {
        return "Name: " + name + " [" + Arrays.toString(estimates) + "]";
    }
}
