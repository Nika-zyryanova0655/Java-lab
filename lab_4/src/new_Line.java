class new_Line<T extends Point2D> {
    private T start;
    private T end;

    // Constructor with two Point objects
    public new_Line(T start, T end) {
        if (start == end) {
            throw new IllegalArgumentException("Start and end points cannot be the same object.");
        }
        this.start = start;
        this.end = end;
    }

    // Getters and Setters
    public T getStart() {
        return start;
    }

    public void setStart(T start) {
        if (start == this.end) {
            throw new IllegalArgumentException("Start and end points cannot be the same object.");
        }
        this.start = start;
    }

    public T getEnd() {
        return end;
    }

    public void setEnd(T end) {
        if (end == this.start) {
            throw new IllegalArgumentException("Start and end points cannot be the same object.");
        }
        this.end = end;
    }

    // Methods to change coordinates
    public void setStartCoordinates(double x, double y) {
        this.start.setX(x);
        this.start.setY(y);
    }

    public void setEndCoordinates(double x, double y) {
        this.end.setX(x);
        this.end.setY(y);
    }

    // Methods to get coordinates
    public double[] getStartCoordinates() {
        return new double[]{start.getX(), start.getY()};
    }

    public double[] getEndCoordinates() {
        return new double[]{end.getX(), end.getY()};
    }

    // toString method
    @Override
    public String toString() {
        return "Line from " + start + " to " + end;
    }

    // equals method
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        new_Line<?> that = (new_Line<?>) obj;
        return (start.equals(that.start) && end.equals(that.end)) ||
                (start.equals(that.end) && end.equals(that.start));
    }

    // hashCode method
    @Override
    public int hashCode() {
        return java.util.Objects.hash(start, end);
    }

    public int getLength() {
        double dx = end.getX() - start.getX();
        double dy = end.getY() - start.getY();
        if (start instanceof Point3D && end instanceof Point3D) {
            double dz = ((Point3D) end).getZ() - ((Point3D) start).getZ();
            return (int) Math.round(Math.sqrt(dx * dx + dy * dy + dz * dz));
        } else {
            return (int) Math.round(Math.sqrt(dx * dx + dy * dy));
        }
    }
}