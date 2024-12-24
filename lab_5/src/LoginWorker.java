import java.util.*;

public class LoginWorker {
    public static void generateLogin() {
        {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Введите количество фамилий:");
            int n = Integer.parseInt(scanner.nextLine());
            Map<String, Integer> surnameCount = new HashMap<>();
            List<String> logins = new ArrayList<>();


            for (int i = 0; i < n; i++) {
                System.out.printf("Введите фамилию и имя для %d человека:%n", i + 1);
                String fullName = scanner.nextLine();
                String surname = fullName.split(" ")[0];

                if (surnameCount.containsKey(surname)) {
                    int count = surnameCount.get(surname) + 1;
                    surnameCount.put(surname, count);
                    logins.add(surname + count);
                } else {
                    surnameCount.put(surname, 1);
                    logins.add(surname);
                }
            }

            System.out.println("\nБудут сформированы следующие логины:");
            for (String login : logins) {
                System.out.println(login);
            }
        }
    }
}