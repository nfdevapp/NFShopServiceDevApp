package org.nfshopservicedev.app.shop.product.service;

import org.nfshopservicedev.app.shop.product.model.Product;

import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    private List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public boolean removeProduct(int id) {
        return products.removeIf(p -> p.id() == id);
    }

    public Product getProduct(int id) {
        return products.stream().filter(p -> p.id() == id).findFirst().orElse(null);
    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }
}
