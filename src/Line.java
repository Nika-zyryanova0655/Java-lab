public class Line {
    private Point origin;
    private Point end;

    public Line(Point origin, Point end) {
        this.origin = origin;
        this.end = end;
    }

    public Point getOrigin() {
        return origin;
    }

    public void setOrigin(Point origin) {
        this.origin = origin;
    }

    public Point getEnd() {
        return end;
    }

    public void setEnd(Point end) {
        this.end = end;
    }

    public String toString() {
        return "Линия от " + origin + " до " + end;
    }
}
