import java.util.Scanner;

public class NumberOperations {
    
    public static double fraction(double x) {
        return x - Math.floor(x);
    }

    public static int charToNum(char x) {
        return x - '0'; // '0' имеет код 48, поэтому вычитаем его, чтобы получить число
    }

    public static boolean is2Digits(int x) {
        return x >= 10 && x <= 99; // Проверяем, находится ли число в диапазоне от 10 до 99
    }

    public static boolean isInRange(int a, int b, int num) {
        return (num >= a && num <= b) || (num >= b && num <= a); // Проверяем, находится ли число в диапазоне, учитывая неопределенный порядок a и b
    }

    public static boolean isEqual(int a, int b, int c) {
        return a == b && a == c; // Проверяем равенство всех трех чисел
    }
    
    public static int abs(int x) {
    if (x < 0) {
        return -x; // Если x отрицательное, возвращаем его противоположное значение
    } else {
        return x; // Если x неотрицательное, возвращаем его без изменений
    }
    }



    public static boolean is35(int x) {
        return (x % 3 == 0 && x % 5 != 0) || (x % 5 == 0 && x % 3 != 0); // Проверяем делимость на 3 или 5, но не на оба одновременно
    }

    public static int max3(int x, int y, int z) {
        if (x > y) {
            if (x > z) {
                return x;
            } else {
                return z;
            }
        } else {
            if (y > z) {
                return y;
            } else {
                return z;
            }
        }
    }

    public static int sum2(int x, int y) {
        int sum = x + y;
        if (sum >= 10 && sum <= 19) {
            return 20;
        } else {
            return sum;
        }
    }

    public static String day(int x) {
        switch (x) {
            case 1:
                return "Понедельник";
            case 2:
                return "Вторник";
            case 3:
                return "Среда";
            case 4:
                return "Четверг";
            case 5:
                return "Пятница";
            case 6:
                return "Суббота";
            case 7:
                return "Воскресенье";
            default:
                return "Это не день недели";
        }
    }
    
    public static String listNums(int x) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= x; i++) {
            result.append(i).append(" ");
        }
        return result.toString();
    }

    public static String chet(int x) {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i <= x; i += 2) {
            result.append(i).append(" ");
        }
        return result.toString();
    }

    public static int numLen(long x) {
        if (x == 0) {
            return 1; // 0 имеет длину 1
        }
        int count = 0;
        while (x != 0) {
            x /= 10;
            count++;
        }
        return count;
    }

    public static void square(int x) {
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < x; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }

    public static void rightTriangle(int x) {
        for (int i = 1; i <= x; i++) {
            for (int j = 1; j <= x - i; j++) {
                System.out.print(" ");
            }
            for (int j = 1; j <= i; j++) {
                System.out.print('*');
            }
            System.out.println();
        }
    }
    
    public static int findFirst(int[] arr, int x) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                return i;
            }
        }
        return -1; // Число не найдено
    }

    public static int maxAbs(int[] arr) {
        int maxAbs = 0;
        for (int i = 0; i < arr.length; i++) {
            if (Math.abs(arr[i]) > maxAbs) {
                maxAbs = Math.abs(arr[i]);
            }
        }
        return maxAbs;
    }

    public static int[] add(int[] arr, int[] ins, int pos) {
        int[] result = new int[arr.length + ins.length];
        for (int i = 0; i < pos; i++) {
            result[i] = arr[i];
        }
        for (int i = 0; i < ins.length; i++) {
            result[pos + i] = ins[i];
        }
        for (int i = pos; i < arr.length; i++) {
            result[i + ins.length] = arr[i];
        }
        return result;
    }

    public static int[] reverseBack(int[] arr) {
        int[] result = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            result[i] = arr[arr.length - 1 - i];
        }
        return result;
    }

    public static int[] findAll(int[] arr, int x) {
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                count++;
            }
        }
        int[] result = new int[count];
        int index = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                result[index] = i;
                index++;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

    // Задача 1: Дробная часть
    System.out.print("Введите вещественное число: ");
    double number = scanner.nextDouble();
    double fractionalPart = fraction(number);
    System.out.println("Дробная часть числа: " + fractionalPart);

    // Задача 2: Преобразование символа в число
    System.out.print("Введите символ (0-9): ");
    char symbol = scanner.next().charAt(0);
    int numberFromSymbol = charToNum(symbol);
    System.out.println("Число, соответствующее символу: " + numberFromSymbol);

    // Задача 3: Проверка на двузначность
    System.out.print("Введите целое число: ");
    int numberForCheck = scanner.nextInt();
    if (is2Digits(numberForCheck)) {
      System.out.println("Число двузначное.");
    } else {
      System.out.println("Число не двузначное.");
    }

    // Задача 4: Проверка на принадлежность диапазону
    System.out.print("Введите левую границу диапазона: ");
    int leftBorder = scanner.nextInt();
    System.out.print("Введите правую границу диапазона: ");
    int rightBorder = scanner.nextInt();
    System.out.print("Введите число для проверки: ");
    int numberToCheck = scanner.nextInt();
    if (isInRange(leftBorder, rightBorder, numberToCheck)) {
      System.out.println("Число принадлежит диапазону.");
    } else {
      System.out.println("Число не принадлежит диапазону.");
    }

    // Задача 5: Проверка на равенство трех чисел
    System.out.print("Введите первое число: ");
    int firstNumber = scanner.nextInt();
    System.out.print("Введите второе число: ");
    int secondNumber = scanner.nextInt();
    System.out.print("Введите третье число: ");
    int thirdNumber = scanner.nextInt();
    if (isEqual(firstNumber, secondNumber, thirdNumber)) {
      System.out.println("Все три числа равны.");
    } else {
      System.out.println("Числа не равны.");
    }

    // Задача 6: Модуль числа
    System.out.print("Введите целое число: ");
    int numberForAbs = scanner.nextInt();
    int absoluteValue = abs(numberForAbs);
    System.out.println("Модуль числа: " + absoluteValue);

    // Задача 7: Делимость на 3 или 5
    System.out.print("Введите целое число: ");
    int numberFor35 = scanner.nextInt();
    if (is35(numberFor35)) {
      System.out.println("Число делится на 3 или 5, но не на оба одновременно.");
    } else {
      System.out.println("Число не делится на 3 или 5, или делится на оба.");
    }

    // Задача 8: Максимальное из трех чисел
    System.out.print("Введите первое число: ");
    int firstNum = scanner.nextInt();
    System.out.print("Введите второе число: ");
    int secondNum = scanner.nextInt();
    System.out.print("Введите третье число: ");
    int thirdNum = scanner.nextInt();
    int maxValue = max3(firstNum, secondNum, thirdNum);
    System.out.println("Максимальное число: " + maxValue);

    // Задача 9: Сумма двух чисел с условием
    System.out.print("Введите первое число: ");
    int num1 = scanner.nextInt();
    System.out.print("Введите второе число: ");
    int num2 = scanner.nextInt();
    int sum = sum2(num1, num2);
    System.out.println("Сумма чисел: " + sum);

    // Задача 10: День недели
    System.out.print("Введите номер дня недели (1-7): ");
    int dayNumber = scanner.nextInt();
    String dayName = day(dayNumber);
    System.out.println("День недели: " + dayName);
    
    // Задача 11: Список чисел
    System.out.print("Введите число: ");
    int numberForList = scanner.nextInt();
    String numbersList = listNums(numberForList);
    System.out.println("Список чисел от 0 до " + numberForList + ": " + numbersList);

    // Задача 12: Четные числа
    System.out.print("Введите число: ");
    int numberForEven = scanner.nextInt();
    String evenNumbers = chet(numberForEven);
    System.out.println("Четные числа от 0 до " + numberForEven + ": " + evenNumbers);

    // Задача 13: Длина числа
    System.out.print("Введите целое число: ");
    long numberForLength = scanner.nextLong();
    int length = numLen(numberForLength);
    System.out.println("Количество цифр в числе: " + length);

    // Задача 14: Квадрат
    System.out.print("Введите размер квадрата: ");
    int squareSize = scanner.nextInt();
    square(squareSize);

    // Задача 15: Прямоугольный треугольник
    System.out.print("Введите высоту треугольника: ");
    int triangleHeight = scanner.nextInt();
    rightTriangle(triangleHeight);
    
    // Задача 16: Поиск первого вхождения
        System.out.print("Введите размер массива: ");
        int arraySize = scanner.nextInt();
        int[] array = new int[arraySize];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < arraySize; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.print("Введите число для поиска: ");
        int numberToFind = scanner.nextInt();
        int firstIndex = findFirst(array, numberToFind);
        if (firstIndex != -1) {
            System.out.println("Индекс первого вхождения: " + firstIndex);
        } else {
            System.out.println("Число не найдено в массиве.");
        }

        // Задача 17: Максимальное по модулю
        System.out.print("Введите размер массива: ");
        arraySize = scanner.nextInt();
        array = new int[arraySize];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < arraySize; i++) {
            array[i] = scanner.nextInt();
        }
        int maxAbsValue = maxAbs(array);
        System.out.println("Максимальное по модулю значение: " + maxAbsValue);

        // Задача 18: Вставка элементов в массив
        System.out.print("Введите размер первого массива: ");
        arraySize = scanner.nextInt();
        array = new int[arraySize];
        System.out.println("Введите элементы первого массива:");
        for (int i = 0; i < arraySize; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.print("Введите размер массива для вставки: ");
        int insertArraySize = scanner.nextInt();
        int[] insertArray = new int[insertArraySize];
        System.out.println("Введите элементы массива для вставки:");
        for (int i = 0; i < insertArraySize; i++) {
            insertArray[i] = scanner.nextInt();
        }
        System.out.print("Введите позицию вставки: ");
        int insertPosition = scanner.nextInt();
        int[] resultArray = add(array, insertArray, insertPosition);
        System.out.println("Результат вставки:");
        for (int i = 0; i < resultArray.length; i++) {
            System.out.print(resultArray[i] + " ");
        }
        System.out.println();

        // Задача 19: Переворот массива
        System.out.print("Введите размер массива: ");
        arraySize = scanner.nextInt();
        array = new int[arraySize];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < arraySize; i++) {
            array[i] = scanner.nextInt();
        }
        int[] reversedArray = reverseBack(array);
        System.out.println("Перевернутый массив:");
        for (int i = 0; i < reversedArray.length; i++) {
            System.out.print(reversedArray[i] + " ");
        }
        System.out.println();

        // Задача 20: Поиск всех вхождений
        System.out.print("Введите размер массива: ");
        arraySize = scanner.nextInt();
        array = new int[arraySize];
        System.out.println("Введите элементы массива:");
        for (int i = 0; i < arraySize; i++) {
            array[i] = scanner.nextInt();
        }
        System.out.print("Введите число для поиска: ");
        numberToFind = scanner.nextInt();
        int[] allIndices = findAll(array, numberToFind);
        System.out.println("Индексы всех вхождений: ");
        for (int i = 0; i < allIndices.length; i++) {
            System.out.print(allIndices[i] + " ");
        }
        System.out.println();

    scanner.close();
  }
}
