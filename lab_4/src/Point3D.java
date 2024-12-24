class Point3D extends Point2D {
    private double z;

    // Constructor
    public Point3D(double x, double y, double z) {
        super(x, y);
        this.z = z;
    }

    // Getters and Setters
    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    // toString method
    @Override
    public String toString() {
        return "{" + getX() + ";" + getY() + ";" + z + "}";
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        if (!super.equals(obj)) return false;
        Point3D that = (Point3D) obj;
        return Double.compare(that.z, z) == 0;
    }

    // hashCode method
    @Override
    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), z);
    }
}