package org.nfshopservicedev.app.shop.product.repository;
import org.nfshopservicedev.app.shop.product.model.Product;
import java.util.ArrayList;
import java.util.List;

public class ProductRepo {
    private final List<Product> products = new ArrayList<>();

    public void addProduct(Product product) {
        products.add(product);
    }

    public void remove(String id) {
        products.removeIf(p -> p.id().equals(id));
    }

    public Product getProduct(String id) {
        for(Product product : products) {
            if(product.id().equals(id)) {
                return product;
            }
        }
        return null;
    }

    //Java Stream
//    public Product getProduct(int id) {
//        return products.stream().filter(p -> p.id() == id).findFirst().orElse(null);
//    }

    public List<Product> getAllProducts() {
        return new ArrayList<>(products);
    }

    public void updateStock(String id, int newStock) {
        for (int i = 0; i < products.size(); i++) {
            Product p = products.get(i);
            if (p.id().equals(id)) {
                products.set(i, new Product(p.id(), p.name(), p.price(), newStock));
            }
        }
    }
}
