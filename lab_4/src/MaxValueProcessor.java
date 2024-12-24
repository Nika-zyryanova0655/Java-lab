import java.util.Arrays;
import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MaxValueProcessor {
    private List<int[]> intArrays;

    public MaxValueProcessor(List<int[]> intArrays) {
        this.intArrays = intArrays;
    }

    public List<Integer> process() {
        Function<int[], Integer> maxFunction = arr -> Arrays.stream(arr).max().getAsInt();
        return applyFunction(intArrays, maxFunction);
    }

    private <T, P> List<P> applyFunction(List<T> list, Function<T, P> function) {
        return list.stream().map(function).collect(Collectors.toList());
    }

    @Override
    public String toString() {
        return "MaxValueProcessor{" +
                "intArrays=" + intArrays +
                '}';
    }
}
