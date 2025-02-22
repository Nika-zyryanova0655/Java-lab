public class new_Point {
    private double x;
    private double y;

    // Constructor
    public new_Point(double x, double y) {
        this.x = x;
        this.y = y;
    }

    // Getters and Setters
    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    // toString method
    @Override
    public String toString() {
        return "{" + x + ";" + y + "}";
    }
}
