public final class Storage<T> {
    private final T value;

    public Storage(T value) {
        this.value = value;
    }

    public T getValue(T alternative) {
        if (value == null) {
            return alternative;
        }
        return value;
    }

    @Override
    public String toString() {
        return "Storage{" +
                "value=" + value +
                '}';
    }
}
