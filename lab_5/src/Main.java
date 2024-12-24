import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.LinkedList;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

           // 1.1
        // Демонстрация работы класса Fraction
//        System.out.println("Введите числитель и знаменатель для первой дроби:");
//        int numerator1 = scanner.nextInt();
//        int denominator1 = scanner.nextInt();
//
//        // Проверка входных данных
//        if (denominator1 == 0) {
//            System.out.println("Знаменатель не может быть равен нулю. Попробуйте снова.");
//            return;
//        }
//
//        Fraction<Integer> fraction1 = new Fraction<>(numerator1, denominator1);
//
//        System.out.println("Введите числитель и знаменатель для второй дроби:");
//        int numerator2 = scanner.nextInt();
//        int denominator2 = scanner.nextInt();
//
//        // Проверка входных данных
//        if (denominator2 == 0) {
//            System.out.println("Знаменатель не может быть равен нулю. Попробуйте снова.");
//            return;
//
//        }
//
//        Fraction<Integer> fraction2 = new Fraction<>(numerator2, denominator2);
//
//        System.out.println("Дроби:");
//        System.out.println(fraction1);
//        System.out.println(fraction2);
//        System.out.println("Дроби равны: " + fraction1.equals(fraction2));
//
//        // 2.1
        // Ввод данных для создания объектов Cat
//        System.out.print("Введите имя первого кота: ");
//        String catName1 = scanner.next();
//        System.out.print("Введите имя второго кота: ");
//        String catName2 = scanner.next();
//
//        Cat cat1 = new Cat(catName1);
//        Cat cat2 = new Cat(catName2);
//
//        System.out.println(cat1);
//        System.out.println(cat2);
//
//        MeowingService meowingService = new MeowingService();
//        meowingService.makeAllMeow(Arrays.asList(cat1, cat2));
//
//        // 3.1
//        // Ввод данных для удаления элементов из списка
//        List<Integer> L = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5, 3));
//        RemoverList listRemover = new RemoverList();
//
//        System.out.print("Введите элемент E для удаления: ");
//        int E = scanner.nextInt();
//
//        listRemover.removeAll(L, E);
//        System.out.println("Обновленный список L: " + L);

        // 4.1
//        LoginWorker.generateLogin();


        // 5.1
//        FileWorker.getAllConsonants("src/input.txt");

        // 6.1
        // Создаем очередь и добавляем элементы
//        Queue<Integer> queue = new LinkedList<>();
//        queue.add(1);
//        queue.add(2);
//        queue.add(3);
//        queue.add(4);
//        queue.add(5);
//
//        // Создаем объект ReverseQueue и печатаем элементы в обратном порядке
//        ReverseQueue reverseQueue = new ReverseQueue(queue);
//        reverseQueue.printReverse();

        // 7.1
        Point[] points = new Point[] {
        new Point(1, 2),
        new Point(2, 3),
        new Point(3, 4),
        new Point(4, 5),
        new Point(5, 6),
        new Point(6, 7),
        new Point(7, 8),
        new Point(8, 9),
        new Point(9, 10),
        new Point(10, 11),
};
        Polyline polyline = StreamWorker.firstTask(points);
        System.out.println(polyline);


        scanner.close();
    }
}
