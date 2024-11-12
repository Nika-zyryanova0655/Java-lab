import java.util.Scanner;
import java.util.Arrays;
import java.util.InputMismatchException;
public class Main {
    public static void main(String[] args){
        Scanner scanner = new Scanner(System.in);

        //№1
        // 1 линия
        new_Point origin1 = new new_Point(1, 3);
        new_Point end1 = new new_Point(23, 8);
        new_Line line1 = new new_Line(origin1, end1);

        // 2 линия
        new_Point origin2 = new new_Point(5, 10);
        new_Point end2 = new new_Point(25, 10);
        new_Line line2 = new new_Line(origin2, end2);

        // 3 линия
        new_Line line3 = new new_Line(line1.getStart(), line2.getEnd());

        //выводим линнии на экран
        System.out.println("Line 1: " + line1);
        System.out.println("Line 2: " + line2);
        System.out.println("Line 3: " + line3);

        // Меняем значения для 1 и 2 линии
        line1.setStart(new new_Point(2, 4));
        line1.setEnd(new new_Point(24, 9));
        line2.setStart(new new_Point(6, 10));
        line2.setEnd(new new_Point(26, 10));

        //изменение 3 линии
        line3.setStart(line1.getStart());
        line3.setEnd(line2.getEnd());

        //вывод изменееных линий
        System.out.println("Line 1: " + line1);
        System.out.println("Line 2: " + line2);
        System.out.println("Line 3: " + line3);

        //№1.1
//        // 1. Создание квадрата с вводом данных с клавиатуры
//        System.out.println("Создание квадрата:");
//        System.out.print("Введите координату X левого верхнего угла: ");
//        double x = getValidDoubleInput(scanner);
//        System.out.print("Введите координату Y левого верхнего угла: ");
//        double y = getValidDoubleInput(scanner);
//        System.out.print("Введите длину стороны: ");
//        double side = getValidDoubleInput(scanner);
//        Square square = new Square(x, y, side);
//        System.out.println("Квадрат: " + square);
//
//        // 2. Получение ломаной, представляющей углы квадрата
//        Polyline polyline = square.getPolyline();
//        System.out.println("Ломаная: " + polyline);
//
//        // 3. Вывод длины ломаной
//        System.out.println("Длина ломаной: " + polyline.getLength());
//
//        // 4. Изменение последней точки ломаной
//        System.out.println("Изменение последней точки ломаной:");
//        new_Point newPoint = getPointInput();
//        polyline.setPoint(3, newPoint);
//        System.out.println("Ломаная после изменения: " + polyline);
//
//        // 5. Вывод длины ломаной после изменения
//        System.out.println("Длина ломаной после изменения: " + polyline.getLength());

        //№2
//        // Создание неизменяемого списка с помощью массива
//        System.out.println("Введите значения для массива через пробел:");
//        int[] values1 = getArrayFromInput(scanner);
//        ImmutableList list1 = new ImmutableList(values1);
//        System.out.println("Создан список 1: " + list1);
//
//        // Создание неизменяемого списка с помощью значений через запятую
//        System.out.println("Введите значения через запятую:");
//        String inputValues = scanner.nextLine();
//        ImmutableList list2 = new ImmutableList(inputValues);
//        System.out.println("Создан список 2: " + list2);
//
//        // Создание неизменяемого списка с помощью копирования другого списка
//        ImmutableList list3 = new ImmutableList(list1);
//        System.out.println("Создан список 3 (копия списка 1): " + list3);
//
//        // Получение значения по индексу
//        int index = getValidIndex(scanner, list1, "Введите индекс для получения значения: ");
//        System.out.println("Значение по индексу " + index + ": " + list1.get(index));
//
//        // Замена значения по индексу
//        index = getValidIndex(scanner, list1, "Введите индекс для замены значения: ");
//        System.out.println("Введите новое значение: ");
//        int newValue = scanner.nextInt();
//        scanner.nextLine(); // Считываем оставшийся символ новой строки
//        ImmutableList updatedList = list1.set(index, newValue);
//        System.out.println("Обновленный список: " + updatedList);
//
//        // Проверка на пустоту
//        System.out.println("Список пуст: " + list1.isEmpty());
//
//        // Получение размера списка
//        System.out.println("Размер списка: " + list1.size());
//
//        // Получение массива значений
//        int[] arrayValues = list1.toArray();
//        System.out.println("Массив значений: " + Arrays.toString(arrayValues));

        //№3
//        System.out.println("Введите данные для точки:");
//        Point point = new Point();
//        System.out.println("Точка: " + point);

        //№4
//        Point_2 point = new Point_2();
//
//        // Ввод координат
//        point.addCharacteristic("X", InputUtils.getIntegerInput("Введите координату X: "));
//        point.addCharacteristic("Y", InputUtils.getIntegerInput("Введите координату Y: "));
//        point.addCharacteristic("Z", InputUtils.getIntegerInput("Введите координату Z: "));
//
//        // Ввод цвета
//        point.addCharacteristic("Цвет", InputUtils.getStringInput("Введите цвет точки: "));
//
//        // Ввод времени
//        point.addCharacteristic("Время", InputUtils.getStringInput("Введите время появления точки (HH:MM): "));
//
//        System.out.println("Точка: " + point);

    }
    //№2
//    private static int[] getArrayFromInput(Scanner scanner) {
//        String input = scanner.nextLine();
//        String[] parts = input.split(" ");
//        int[] values = new int[parts.length];
//        for (int i = 0; i < parts.length; i++) {
//            try {
//                values[i] = Integer.parseInt(parts[i]);
//            } catch (NumberFormatException e) {
//                System.err.println("Ошибка: некорректный формат ввода.");
//                return getArrayFromInput(scanner);
//            }
//        }
//        return values;
//    }
//    private static int getValidIndex(Scanner scanner, ImmutableList list, String message) {
//        int index;
//        do {
//            System.out.print(message);
//            try {
//                index = scanner.nextInt();
//                scanner.nextLine(); // Считываем оставшийся символ новой строки
//                if (index < 0 || index >= list.size()) {
//                    System.err.println("Ошибка: индекс вне диапазона.");
//                } else {
//                    break;
//                }
//            } catch (InputMismatchException e) {
//                System.err.println("Ошибка: некорректный формат ввода.");
//                scanner.nextLine(); // Считываем оставшийся символ новой строки
//            }
//        } while (true);
//        return index;
//    }
//№2
//    private static new_Point getPointInput() {
//        System.out.print("Введите координату X: ");
//        double x = getValidDoubleInput();
//        System.out.print("Введите координату Y: ");
//        double y = getValidDoubleInput();
//        return new new_Point(x, y);
//    }

    private static double getValidDoubleInput(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.print("ошибка: ");
            }
        }
    }
}