@Cache(value = {"FirstValue", "SecondValue"})
@Two(first = "FirstValue", second = "SecondValue")
@ToString(value = ToString.Value.YES)
//@Default(value = ExampleImpl.class)
//@Validate(value = {ExampleImpl.class})
public class ExampleImpl implements Example {
    @ToString(value = ToString.Value.YES)
    private int value;

    public ExampleImpl(int value) {
        this.value = value;
    }

    @Override
    public int getValue() {
        return value;
    }

    @Override
    public void incrementValue() {
        value += 1;
    }

    @Override
    public String toString() {
        return String.valueOf(value);
    }
}
