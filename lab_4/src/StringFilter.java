import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class StringFilter {
    private List<String> strings;

    public StringFilter(List<String> strings) {
        this.strings = strings;
    }

    public List<String> process() {
        Predicate<String> stringLengthPredicate = s -> s.length() >= 3;
        return filterList(strings, stringLengthPredicate);
    }

    private <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "StringFilter{" +
                "strings=" + strings +
                '}';
    }
}
//test