import java.util.Scanner;
import java.util.InputMismatchException;
class Point {
    private int x;
    private int y;
    private int z;

    public Point(int x, int y, int z) {
        this.x = x;
        this.y = y;
        this.z = z;
    }

    public Point() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите координату X: ");
        this.x = getIntegerInput(scanner);

        System.out.print("Введите координату Y: ");
        this.y = getIntegerInput(scanner);

        System.out.print("Введите координату Z: ");
        this.z = getIntegerInput(scanner);
    }

    private int getIntegerInput(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод. Введите целое число: ");
                scanner.nextLine(); // очистка буфера ввода
            }
        }
    }

    @Override
    public String toString() {
        return "{" + x + ";" + y + ";" + z + "}";
    }
}
