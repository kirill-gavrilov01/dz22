import java.util.Arrays;
import java.util.List;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        List<Searchable> items = Arrays.asList(
                new Searchable("Laptop"),
                new Searchable("Smartphone"),
                new Searchable("Headphones")
        );

        SearchEngine engine = new SearchEngine(items);

        // Ищем объекты, содержащие букву 'p'
        Map<String, Searchable> foundItems = engine.search(s -> s.getName().contains("p"));

        // Печатаем результат поиска
        foundItems.forEach((key, value) -> System.out.println(key + ": " + value));
    }
}
