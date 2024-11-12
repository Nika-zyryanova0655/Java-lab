class Polyline {
    private new_Point[] points;

    // Конструктор
    public Polyline(new_Point[] points) {
        this.points = points;
    }

    // Метод для получения длины ломаной
    public int getLength() {
        int length = 0;
        for (int i = 0; i < points.length - 1; i++) {
            length += new new_Line(points[i], points[i + 1]).getLength();
        }
        return length;
    }

    // Метод для изменения точки ломаной
    public void setPoint(int index, new_Point newPoint) {
        if (index >= 0 && index < points.length) {
            points[index] = newPoint;
        } else {
            System.out.println("Неверный индекс точки.");
        }
    }

    // Метод для текстового представления ломаной
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Ломаная: ");
        for (new_Point point : points) {
            sb.append(point).append(" ");
        }
        return sb.toString().trim();
    }
}