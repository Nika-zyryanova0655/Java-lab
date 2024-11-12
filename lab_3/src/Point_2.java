import java.util.InputMismatchException;
import java.util.Scanner;
class Point_2 {
    private String[] characteristics;

    public Point_2() {
        characteristics = new String[0];
    }

    public void addCharacteristic(String name, Object value) {
        String[] newCharacteristics = new String[characteristics.length + 2];
        for (int i = 0; i < characteristics.length; i++) {
            newCharacteristics[i] = characteristics[i];
        }
        newCharacteristics[characteristics.length] = name;
        newCharacteristics[characteristics.length + 1] = value.toString();
        characteristics = newCharacteristics;
    }

    public Object getCharacteristic(String name) {
        for (int i = 0; i < characteristics.length; i += 2) {
            if (characteristics[i].equals(name)) {
                return characteristics[i + 1];
            }
        }
        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("{");
        boolean first = true;
        for (int i = 0; i < characteristics.length; i += 2) {
            if (!first) {
                sb.append(", ");
            }
            sb.append(characteristics[i]).append(": ").append(characteristics[i + 1]);
            first = false;
        }
        sb.append("}");
        return sb.toString();
    }
}

class InputUtils {
    private static Scanner scanner = new Scanner(System.in);

    public static int getIntegerInput(String prompt) {
        while (true) {
            System.out.print(prompt);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Некорректный ввод. Введите целое число: ");
                scanner.nextLine(); // Очистка буфера ввода
            }
        }
    }

    public static String getStringInput(String prompt) {
        System.out.print(prompt);
        return scanner.nextLine();
    }
}