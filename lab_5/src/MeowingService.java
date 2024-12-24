import java.util.List;

public class MeowingService {
    public void makeAllMeow(List<Meowable> meowables) {
        for (Meowable meowable : meowables) {
            meowable.meow();
        }
    }
}
