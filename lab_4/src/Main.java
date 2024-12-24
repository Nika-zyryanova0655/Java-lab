import java.util.Scanner;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
    // 1.2
//        // Создание хранилища чисел с значением null
//        Storage<Integer> nullIntegerStorage = new Storage<>(null);
//        NumberStorage nullIntegerDemo = new NumberStorage(nullIntegerStorage);
//        nullIntegerDemo.demonstrate();
//
//        // Создание хранилища чисел с значением 99
//        Storage<Integer> integerStorage = new Storage<>(99);
//        NumberStorage integerDemo = new NumberStorage(integerStorage);
//        integerDemo.demonstrate();
//
//        // Создание хранилища строк с значением null
//        Storage<String> nullStringStorage = new Storage<>(null);
//        StringStorage nullStringDemo = new StringStorage(nullStringStorage);
//        nullStringDemo.demonstrate();
//
//        // Создание хранилища строк с значением "hello"
//        Storage<String> stringStorage = new Storage<>("hello");
//        StringStorage stringDemo = new StringStorage(stringStorage);
//        stringDemo.demonstrate();


    // 1.5
//        // Ввод координат начала линии в трехмерном пространстве
//        System.out.println("Введите координаты начала линии в трехмерном пространстве (x1 y1 z1):");
//        double x1 = getDoubleInput(scanner);
//        double y1 = getDoubleInput(scanner);
//        double z1 = getDoubleInput(scanner);
//
//        // Ввод координат конца линии в трехмерном пространстве
//        System.out.println("Введите координаты конца линии в трехмерном пространстве (x2 y2 z2):");
//        double x2 = getDoubleInput(scanner);
//        double y2 = getDoubleInput(scanner);
//        double z2 = getDoubleInput(scanner);
//
//        // Создание объектов точек и линии в трехмерном пространстве
//        Point3D startPoint = new Point3D(x1, y1, z1);
//        Point3D endPoint = new Point3D(x2, y2, z2);
//        new_Line<Point3D> line = new new_Line<>(startPoint, endPoint);
//
//        // Вывод информации о линии
//        System.out.println(line);
//
//        // Сдвиг точки начала на 10 единиц по оси X
//        shiftStartPointX(line, 10);
//
//        // Вывод информации о линии после сдвига
//        System.out.println("Линия после сдвига: " + line);


     // 3.1
//        // Пример 1: Передача списка строк и получение списка их длин
//        System.out.println("Введите строки (например, qwerty asdfg zx):");
//        List<String> strings = Arrays.asList(scanner.nextLine().split(" "));
//        StringLengthProcessor stringLengthProcessor = new StringLengthProcessor(strings);
//        System.out.println("Длины строк: " + stringLengthProcessor.process());
//
//        // Пример 2: Передача списка чисел и получение списка, где отрицательные числа стали положительными
//        System.out.println("Введите числа через пробел (например, 1 -3 7):");
//        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//        AbsValueProcessor absValueProcessor = new AbsValueProcessor(numbers);
//        System.out.println("Абсолютные значения чисел: " + absValueProcessor.process());
//
//        // Пример 3: Передача списка массивов целых чисел и получение списка максимальных значений каждого массива
//        System.out.println("Введите массивы целых чисел через пробел (например, 1 2 3 4 5 6 7 8 9):");
//        List<int[]> intArrays = Arrays.asList(
//                Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray(),
//                Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray(),
//                Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray()
//        );
//        MaxValueProcessor maxValueProcessor = new MaxValueProcessor(intArrays);
//        System.out.println("Максимальные значения массивов: " + maxValueProcessor.process());


        // 3.2
//        // Пример 1: Передача списка строк и фильтрация строк, имеющих менее трех символов
//        System.out.println("Введите строки (например, qwerty asdfg zx):");
//        List<String> strings = Arrays.asList(scanner.nextLine().split(" "));
//        StringFilter stringFilter = new StringFilter(strings);
//        System.out.println("Отфильтрованные строки: " + stringFilter.process());
//
//        // Пример 2: Передача списка чисел и фильтрация положительных элементов
//        System.out.println("Введите числа через пробел (например, 1 -3 7):");
//        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//        NumberFilter numberFilter = new NumberFilter(numbers);
//        System.out.println("Отфильтрованные числа: " + numberFilter.process());
//
//        // Пример 3: Передача списка массивов целых чисел и фильтрация массивов, содержащих положительные элементы
//        System.out.println("Введите массивы целых чисел через пробел (например, 1 2 3 4 5 6 7 8 9):");
//        List<int[]> intArrays = Arrays.asList(
//                Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray(),
//                Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray(),
//                Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray()
//        );
//        ArrayFilter arrayFilter = new ArrayFilter(intArrays);
//        List<int[]> filteredIntArrays = arrayFilter.process();
//        System.out.println("Отфильтрованные массивы: " + filteredIntArrays.stream()
//                .map(Arrays::toString)
//                .collect(Collectors.joining(", ")));


    // 3.3
        // Пример 1: Передача списка строк и формирование одной большой строки
//        System.out.println("Введите строки (например, qwerty asdfg zx):");
//        List<String> strings = Arrays.asList(scanner.nextLine().split(" "));
//        StringConcatenator stringConcatenator = new StringConcatenator(strings);
//        System.out.println("Объединенная строка: " + stringConcatenator.process());
//
//        // Пример 2: Передача списка чисел и получение суммы всех значений
//        System.out.println("Введите числа через пробел (например, 1 -3 7):");
//        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//        NumberSumProcessor numberSumProcessor = new NumberSumProcessor(numbers);
//        System.out.println("Сумма чисел: " + numberSumProcessor.process());
//
//        // Пример 3: Передача списка списков целых чисел и получение общего количества элементов
//        System.out.println("Введите массивы целых чисел через пробел (например, 1 2 3 4 5 6 7 8 9):");
//        List<List<Integer>> listOfLists = Arrays.asList(
//                Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()),
//                Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()),
//                Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList())
//        );
//        SizeProcessor listSizeProcessor = new SizeProcessor(listOfLists);
//        System.out.println("Общее количество элементов: " + listSizeProcessor.process());



        // 3.4
//        // Пример 1: Передача списка строк и формирование одной большой строки
//        System.out.println("Введите строки (например, qwerty asdfg zx):");
//        List<String> strings = Arrays.asList(scanner.nextLine().split(" "));
//        StringFilter stringFilter = new StringFilter(strings);
//        System.out.println("Объединенная строка: " + stringFilter.process());
//
//        // Пример 2: Передача списка чисел и получение суммы всех значений
//        System.out.println("Введите числа через пробел (например, 1 -3 7):");
//        List<Integer> numbers = Arrays.stream(scanner.nextLine().split(" "))
//                .map(Integer::parseInt)
//                .collect(Collectors.toList());
//        NumberFilter numberFilter = new NumberFilter(numbers);
//        System.out.println("Сумма чисел: " + numberFilter.process());
//
//        // Пример 3: Передача списка списков целых чисел и получение общего количества элементов
//        System.out.println("Введите массивы целых чисел через пробел (например, 1 2 3 4 5 6 7 8 9):");
//        List<List<Integer>> listOfLists = Arrays.asList(
//                Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()),
//                Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList()),
//                Arrays.stream(scanner.nextLine().split(" ")).map(Integer::parseInt).collect(Collectors.toList())
//        );
//        SizeProcessor listSizeProcessor = new SizeProcessor(listOfLists);
//        System.out.println("Общее количество элементов: " + listSizeProcessor.process());

        scanner.close();
    }

    private static double getDoubleInput(Scanner scanner) {
        while (true) {
            try {
                return Double.parseDouble(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Некорректный ввод. Пожалуйста, введите число.");
            }
        }
    }
    // with 1.5
    // Метод для сдвига точки начала на заданное количество единиц по оси X
//    public static <T extends Point2D> void shiftStartPointX(new_Line<T> line, double shift) {
//        double newX = line.getStart().getX() + shift;
//        line.getStart().setX(newX);
//    }
}


