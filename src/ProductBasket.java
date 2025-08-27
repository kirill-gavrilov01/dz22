import java.util.*;

public class ProductBasket {
    private Map<String, List<Product>> productsByName;

    public ProductBasket() {
        productsByName = new HashMap<>();
    }

    // Добавление нового продукта в корзину
    public void add(Product product) {
        if (!productsByName.containsKey(product.getName())) {
            productsByName.put(product.getName(), new ArrayList<>());
        }
        productsByName.get(product.getName()).add(product);
    }

    // Получение всех продуктов по заданному имени
    public List<Product> findProductsByName(String name) {
        return productsByName.getOrDefault(name, Collections.emptyList());
    }

    // Удаление продукта по его имени
    public boolean removeProductByName(String name) {
        return productsByName.remove(name) != null;
    }

    // Метод вывода всех продуктов из корзины (нужно перебор каждого элемента)
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();
        for (List<Product> products : productsByName.values()) {
            for (Product p : products) {
                result.append(p.toString())
                        .append("\\n");
            }
        }
        return result.toString();
    }
}
