public class new_Line {
    private new_Point start;
    private new_Point end;

    // Constructor with two Point objects
    public new_Line(new_Point start, new_Point end) {
        this.start = start;
        this.end = end;
    }

    // Constructor with four coordinates
    public new_Line(double x1, double y1, double x2, double y2) {
        this.start = new new_Point(x1, y1);
        this.end = new new_Point(x2, y2);
    }

    // Getters and Setters
    public new_Point getStart() {
        return start;
    }

    public void setStart(new_Point start) {
        this.start = start;
    }

    public new_Point getEnd() {
        return end;
    }

    public void setEnd(new_Point end) {
        this.end = end;
    }

    // toString method
    @Override
    public String toString() {
        return "Line from " + start + " to " + end;
    }

    public int getLenght() {
        double dx = end.getX() - start.getX();
        double dy = end.getY() - start.getY();
        return (int) Math.round(Math.sqrt(dx*dx + dy*dy));
    }
}
