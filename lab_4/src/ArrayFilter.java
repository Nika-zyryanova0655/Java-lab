import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class ArrayFilter {
    private List<int[]> intArrays;

    public ArrayFilter(List<int[]> intArrays) {
        this.intArrays = intArrays;
    }

    public List<int[]> process() {
        Predicate<int[]> noPositiveElementsPredicate = arr -> Arrays.stream(arr).noneMatch(n -> n > 0);
        return filterList(intArrays, noPositiveElementsPredicate);
    }

    private <T> List<T> filterList(List<T> list, Predicate<T> predicate) {
        return list.stream().filter(predicate).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "ArrayFilter{" +
                "intArrays=" + intArrays +
                '}';
    }
}
