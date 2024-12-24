import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Set;
import java.util.TreeSet;

public class FileWorker {
    private static final Set<Character> CONSONANTS = Set.of('б', 'в', 'г', 'д', 'ж', 'з', 'й', 'л', 'м', 'н', 'р');

    public static void getAllConsonants(String fileName) {
        Set<Character> consonants = new TreeSet<>(); // Чтобы уже само сортировалось
        try (BufferedReader reader = new BufferedReader(new FileReader(fileName))) {
            String line;
            while ((line = reader.readLine()) != null) {
                for (String word : line.split("\\s+")) {
                    for (char c : word.toCharArray()) {
                        if (CONSONANTS.contains(c)) {
                            consonants.add(c);
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (char c : consonants) {
            System.out.print(c + " ");
        }
    }
}