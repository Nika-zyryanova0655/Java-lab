public class Fraction<T extends Number> {
    private T numerator;
    private T denominator;

    public Fraction(T numerator, T denominator) {
        if (denominator.doubleValue() < 0) {
            throw new IllegalArgumentException("Знаменатель не может быть отрицательным");
        }
        if (denominator.doubleValue() == 0) {
            throw new IllegalArgumentException("Знаменатель не может быть равен нулю");
        }
        this.numerator = numerator;
        this.denominator = denominator;
    }

    @Override
    public String toString() {
        return numerator + "/" + denominator;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Fraction<?> fraction = (Fraction<?>) obj;
        return numerator.equals(fraction.numerator) && denominator.equals(fraction.denominator);
    }

    @Override
    public int hashCode() {
        return 31 * numerator.hashCode() + denominator.hashCode();
    }
}
