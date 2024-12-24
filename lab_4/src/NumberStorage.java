import java.util.Scanner;

public class NumberStorage {
    private final Storage<Integer> storage;

    public NumberStorage(Storage<Integer> storage) {
        this.storage = storage;
    }

    public void demonstrate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter alternative value for IntegerStorage: ");
        int alternative = scanner.nextInt();
        System.out.println("Value from IntegerStorage: " + storage.getValue(alternative));
    }

    @Override
    public String toString() {
        return "IntegerStorageDemo{" +
                "storage=" + storage +
                '}';
    }
}
