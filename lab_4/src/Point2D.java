class Point2D {
    private double x;
    private double y;

    // Constructor
    public Point2D(double x, double y) {
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

    // equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Point2D that = (Point2D) obj;
        return Double.compare(that.x, x) == 0 && Double.compare(that.y, y) == 0;
    }

    // hashCode method
    @Override
    public int hashCode() {
        return java.util.Objects.hash(x, y);
    }
}