import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class StringConcatenator {
    private List<String> strings;

    public StringConcatenator(List<String> strings) {
        this.strings = strings;
    }

    public String process() {
        BinaryOperator<String> stringConcatenator = (s1, s2) -> s1 + " " + s2;
        return reduceList(strings, stringConcatenator, "");
    }

    private <T> T reduceList(List<T> list, BinaryOperator<T> accumulator, T identity) {
        return list.stream().reduce(identity, accumulator);
    }

    @Override
    public String toString() {
        return "StringConcatenator{" +
                "strings=" + strings +
                '}';
    }
}
//