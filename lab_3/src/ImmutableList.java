import java.util.Arrays;
class ImmutableList {
    private final int[] values;

    // Конструктор с массивом значений
    public ImmutableList(int[] values) {
        this.values = Arrays.copyOf(values, values.length);
    }

    // Конструктор с перечнем значений через запятую
    public ImmutableList(String valuesString) {
        String[] parts = valuesString.split(",");
        this.values = new int[parts.length];
        for (int i = 0; i < parts.length; i++) {
            try {
                this.values[i] = Integer.parseInt(parts[i].trim());
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("Ошибка: некорректный формат ввода значений.");
            }
        }
    }

    // Конструктор с копированием другого списка
    public ImmutableList(ImmutableList other) {
        this.values = Arrays.copyOf(other.values, other.values.length);
    }

    // Получение значения по индексу
    public int get(int index) {
        if (index < 0 || index >= values.length) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона.");
        }
        return values[index];
    }

    // Замена значения по индексу
    public ImmutableList set(int index, int newValue) {
        if (index < 0 || index >= values.length) {
            throw new IndexOutOfBoundsException("Индекс вне диапазона.");
        }
        int[] newValues = Arrays.copyOf(values, values.length);
        newValues[index] = newValue;
        return new ImmutableList(newValues);
    }

    // Проверка на пустоту
    public boolean isEmpty() {
        return values.length == 0;
    }

    // Получение размера
    public int size() {
        return values.length;
    }

    // Получение массива значений
    public int[] toArray() {
        return Arrays.copyOf(values, values.length);
    }

    @Override
    public String toString() {
        return "[" + Arrays.toString(values) + "]";
    }
}