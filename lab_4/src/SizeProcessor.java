import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class SizeProcessor {
    private List<List<Integer>> listOfLists;

    public SizeProcessor(List<List<Integer>> listOfLists) {
        this.listOfLists = listOfLists;
    }

    public Integer process() {
        BinaryOperator<Integer> countFunction = Integer::sum;
        List<Integer> sizes = listOfLists.stream().map(List::size).collect(Collectors.toList());
        return reduceList(sizes, countFunction, 0);
    }

    private <T> T reduceList(List<T> list, BinaryOperator<T> accumulator, T identity) {
        return list.stream().reduce(identity, accumulator);
    }

    @Override
    public String toString() {
        return "ListSizeProcessor{" +
                "listOfLists=" + listOfLists +
                '}';
    }
}
