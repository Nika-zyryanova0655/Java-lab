import java.util.Scanner;
import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // № 1
//        System.out.println("Введите координату первой точки:");
//        System.out.print("X: ");
//        double x1 = getValidDoubleInput(scanner);
//        System.out.print("Y: ");
//        double y1 = getValidDoubleInput(scanner);
//        Point point1 = new Point(x1, y1);
//
//        System.out.println("Введите координату второй точки:");
//        System.out.print("X: ");
//        double x2 = getValidDoubleInput(scanner);
//        System.out.print("Y: ");
//        double y2 = getValidDoubleInput(scanner);
//        Point point2 = new Point(x2, y2);
//
//        System.out.println("Введите координату третьей точки:");
//        System.out.print("X: ");
//        double x3 = getValidDoubleInput(scanner);
//        System.out.print("Y: ");
//        double y3 = getValidDoubleInput(scanner);
//        Point point3 = new Point(x3, y3);
//
//        System.out.println("Точка 1: " + point1);
//        System.out.println("Тока 2: " + point2);
//        System.out.println("Точка 3: " + point3);
//
//        scanner.close();
//
//        // № 2
//        // 1 линия
//        Point origin1 = new Point(1, 3);
//        Point end1 = new Point(23, 8);
//        Line line1 = new Line(origin1, end1);
//
//        // 2 линия
//        Point origin2 = new Point(5, 10);
//        Point end2 = new Point(25, 10);
//        Line line2 = new Line(origin2, end2);
//
//        // 3 линия
//        Line line3 = new Line(line1.getOrigin(), line2.getEnd());
//
//        //выводим линнии на экран
//        System.out.println("Line 1: " + line1);
//        System.out.println("Line 2: " + line2);
//        System.out.println("Line 3: " + line3);
//
//        // Меняем значения для 1 и 2 линии
//        line1.setOrigin(new Point(2, 4));
//        line1.setEnd(new Point(24, 9));
//        line2.setOrigin(new Point(6, 10));
//        line2.setEnd(new Point(26, 10));
//
//        //изменение 3 линии
//        line3.setOrigin(line1.getOrigin());
//        line3.setEnd(line2.getEnd());
//
//        //вывод изменееных линий
//        System.out.println("Line 1: " + line1);
//        System.out.println("Line 2: " + line2);
//        System.out.println("Line 3: " + line3);

        // № 3
//        int[] vasyaEstimates = {3, 4, 5};
//        Student vasya = new Student("Vasya", vasyaEstimates);
//        Student petya = new Student("Petya", vasyaEstimates);
//        petya.getEstimates()[0] = 5;
//
//        System.out.println("Vasya: " + vasya);
//        System.out.println("Petya: " + petya);
//
//        int[] andreyEstimates = Arrays.copyOf(vasyaEstimates, vasyaEstimates.length);
//        Student andrey = new Student("Andrey", andreyEstimates);
//        andrey.getEstimates()[0] = 2;
//
//        System.out.println("Vasya: " + vasya);
//        System.out.println("Andrey: " + andrey);

        // № 4.1
//        Point point1 = new Point(3, 5);
//        System.out.println("Point 1: " + point1);
//        Point point2 = new Point(25, 6);
//        System.out.println("Point 2: " + point2);

        // №4.2

//        new_Line line1 = new new_Line(1, 3, 23, 8);
//        System.out.println("Line 1: " + line1);
//
//        // Create Line 2, horizontal, at a height of 10, from point 5 to point 25
//        new_Line line2 = new new_Line(5, 10, 25, 10);
//        System.out.println("Line 2: " + line2);
//
//        // Create Line 3 which always starts where Line 1 starts and always ends where Line 2 ends
//        new_Line line3 = new new_Line(line1.getStart(), line2.getEnd());
//        System.out.println("Line 3: " + line3);
//
//        // Change the coordinates of Line 1 and Line 2
//        line1.setStart(new new_Point(2, 4));
//        line1.setEnd(new new_Point(24, 9));
//        line2.setStart(new new_Point(6, 10));
//        line2.setEnd(new new_Point(26, 10));
//
//        line3.setStart(line1.getStart());
//        line3.setEnd(line2.getEnd());
//
//        // Display the updated lines
//        System.out.println("\nUpdated Lines:");
//        System.out.println("Line 1: " + line1);
//        System.out.println("Line 2: " + line2);
//        System.out.println("Line 3: " + line3);
//
//        // Change the coordinates of Line 1 so that Line 3 does not change
//        new_Point newStart1 = new new_Point(line3.getStart().getX(), line3.getStart().getY());
//        new_Point newEnd1 = new new_Point(line3.getEnd().getX(), line3.getEnd().getY());
//        line1.setStart(newStart1);
//        line1.setEnd(newEnd1);
//
//        // Display the final lines
//        System.out.println("\nFinal Lines:");
//        System.out.println("Line 1: " + line1);
//        System.out.println("Line 2: " + line2);
//        System.out.println("Line 3: " + line3);
    }

    // Method to get valid double input
//    private static double getValidDoubleInput(Scanner scanner) {
//        while (true) {
//            try {
//                return Double.parseDouble(scanner.nextLine());
//            } catch (NumberFormatException e) {
//                System.out.print("ошибка: ");
//            }
//        }
//    }
}

