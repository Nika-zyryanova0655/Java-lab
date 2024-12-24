import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class StringLengthProcessor {
    private List<String> strings;

    public StringLengthProcessor(List<String> strings) {
        this.strings = strings;
    }

    public List<Integer> process() {
        Function<String, Integer> stringLengthFunction = String::length;
        return applyFunction(strings, stringLengthFunction);
    }

    private <T, P> List<P> applyFunction(List<T> list, Function<T, P> function) {
        return list.stream().map(function).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "StringLengthProcessor{" +
                "strings=" + strings +
                '}';
    }
}
