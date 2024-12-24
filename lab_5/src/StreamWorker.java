import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class StreamWorker {
    public static Polyline firstTask(Point[] points) {
        return new Polyline(Arrays.stream(points)
                .distinct()
                .filter(point -> point.getX() != point.getY())
                .map(point -> new Point(point.getX(), Math.abs(point.getY())))
                .sorted(Comparator.comparingDouble(Point::getX))
                .toArray(Point[]::new));
    }

    public static Map<Integer, List<String>> secondTask(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            return reader.lines()
                    .map(line -> line.split(":"))
                    .filter(parts -> parts.length == 2 && !parts[1].trim().isEmpty())
                    .map(parts -> parts[0].substring(0, 1).toUpperCase() + parts[0].substring(1).toLowerCase() + ":" + parts[1].trim())
                    .map(line -> line.split(":"))
                    .collect(Collectors.groupingBy(
                            parts -> Integer.parseInt(parts[1].trim()),
                            Collectors.mapping(
                                    parts -> parts[0],
                                    Collectors.toList()
                            )));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return Map.of();
    }
}
