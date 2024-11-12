class Square {
    private new_Point topLeft;
    private double side;

    // Конструктор с указанием точки и длины стороны
    public Square(new_Point topLeft, double side) {
        this.topLeft = topLeft;
        this.side = side;
    }

    // Конструктор с указанием координат и длины стороны
    public Square(double x, double y, double side) {
        this.topLeft = new new_Point(x, y);
        this.side = side;
    }

    // Метод для получения ломаной, представляющей углы квадрата
    public Polyline getPolyline() {
        new_Point[] points = new new_Point[4];
        points[0] = topLeft;
        points[1] = new new_Point(topLeft.getX() + side, topLeft.getY());
        points[2] = new new_Point(topLeft.getX() + side, topLeft.getY() + side);
        points[3] = new new_Point(topLeft.getX(), topLeft.getY() + side);
        return new Polyline(points);
    }

    // Метод для текстового представления квадрата
    @Override
    public String toString() {
        return "Квадрат в точке " + topLeft.toString() + " со стороной " + side;
    }
}