import java.util.List;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;

public class NumberSumProcessor {
    private List<Integer> numbers;

    public NumberSumProcessor(List<Integer> numbers) {
        this.numbers = numbers;
    }

    public Integer process() {
        BinaryOperator<Integer> sumFunction = Integer::sum;
        return reduceList(numbers, sumFunction, 0);
    }

    private <T> T reduceList(List<T> list, BinaryOperator<T> accumulator, T identity) {
        return list.stream().reduce(identity, accumulator);
    }

    @Override
    public String toString() {
        return "NumberSumProcessor{" +
                "numbers=" + numbers +
                '}';
    }
}
