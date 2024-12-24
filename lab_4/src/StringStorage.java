import java.util.Scanner;

public class StringStorage {
    private final Storage<String> storage;

    public StringStorage(Storage<String> storage) {
        this.storage = storage;
    }

    public void demonstrate() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter alternative value for StringStorage: ");
        String alternative = scanner.nextLine();
        System.out.println("Value from StringStorage: " + storage.getValue(alternative));
    }

    @Override
    public String toString() {
        return "StringStorageDemo{" +
                "storage=" + storage +
                '}';
    }
}
