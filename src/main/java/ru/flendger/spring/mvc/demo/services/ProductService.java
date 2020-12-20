package ru.flendger.spring.mvc.demo.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.flendger.spring.mvc.demo.model.Product;
import ru.flendger.spring.mvc.demo.repositories.ProductRepository;

import java.util.List;

@Service
public class ProductService {

    private ProductRepository productRepository;

    @Autowired
    private void setProductRepository(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public List<Product> getProducts() {
        return productRepository.getProducts();
    }

    public Product getProduct(int id) {
        return productRepository.getProduct(id);
    }

    public void addProduct(Product product) {
        productRepository.add(product);
    }

    public void removeProduct(int id) {
        productRepository.remove(productRepository.getProduct(id));
    }
}
