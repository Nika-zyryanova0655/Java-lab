import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class NumberFilter {
    private List<Integer> numbers;

    public NumberFilter(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public List<Integer> process() {
        Predicate<Integer> positiveNumberPredicate = n -> n < 0;
        return filterList(numbers, positiveNumberPredicate);
    }

    private <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "NumberFilter{" +
                "numbers=" + numbers +
                '}';
    }
}
