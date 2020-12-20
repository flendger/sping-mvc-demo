package ru.flendger.spring.mvc.demo.repositories;

import org.springframework.stereotype.Repository;
import ru.flendger.spring.mvc.demo.model.Product;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Repository(value = "rep")
public class ProductRepository {

    private final List<Product> products;

    public ProductRepository() {
        products = new ArrayList<>();
    }

    @PostConstruct
    private void initProducts() {
        for (int i = 0; i < 5; i++) {
            String title = "продукт" + i;
            products.add(new Product(i, title, (float) (Math.random() * 3) + 1));
        }
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    public Product getProduct(int id) {
        Optional<Product> p = products.stream().
                filter(arg -> arg.getId() == id).
                findFirst();
        if (p.isEmpty()) return null;
        return p.get();
    }

    public void add(Product product) {
        if (products.contains(product)) return;

        products.add(product);
    }

    public void remove(Product product) {
        products.remove(product);
    }
}
