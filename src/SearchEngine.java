import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

// Класс SearchEngine обеспечивает возможность поиска по объектам
public class SearchEngine {
    private final List<Searchable> items;

    public SearchEngine(List<Searchable> items) {
        this.items = items;
    }

    // Метод поиска объектов, удовлетворяющих предикату
    public Map<String, Searchable> search(SearchPredicate predicate) {
        TreeMap<String, Searchable> results = new TreeMap<>();

        for (Searchable item : items) {
            if (predicate.test(item)) {
                results.put(item.getName(), item);
            }
        }
        return results;
    }

    // Функциональный интерфейс для условий поиска
    @FunctionalInterface
    public interface SearchPredicate {
        boolean test(Searchable s);
    }
}