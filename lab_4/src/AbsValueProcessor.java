import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class AbsValueProcessor {
    private List<Integer> numbers;

    public AbsValueProcessor(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> process() {
        Function<Integer, Integer> absFunction = Math::abs;
        return applyFunction(numbers, absFunction);
    }

    private <T, P> List<P> applyFunction(List<T> list, Function<T, P> function) {
        return list.stream().map(function).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "AbsValueProcessor{" +
                "numbers=" + numbers +
                '}';
    }
}
