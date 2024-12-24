import java.util.List;

public class RemoverList {
    public <T> void removeAll(List<T> list, T element) {
        list.removeIf(item -> item.equals(element));
    }
}
