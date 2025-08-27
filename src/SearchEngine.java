import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class SearchEngine {
    private final List<Searchable> searchables;

    public SearchEngine(List<Searchable> searchables) {
        this.searchables = searchables;
    }

    /**
     * Метод ищет объекты по определенному критерию и возвращает отсортированную мапу,
     * где ключ — имя объекта, а значение — сам объект.
     */
    public Map<String, Searchable> search(SearchPredicate predicate) {
        TreeMap<String, Searchable> results = new TreeMap<>();

        for (Searchable item : searchables) {
            if (predicate.test(item)) { // Проверяем условие фильтрации
                results.put(item.getName(), item); // Добавляем найденный объект в мапу
            }
        }
        return results;
    }
}

@FunctionalInterface
interface SearchPredicate {
    boolean test(Searchable s);
}
