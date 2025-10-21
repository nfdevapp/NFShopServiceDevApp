package org.nfshopservicedev.app;

import org.nfshopservicedev.app.shop.order.model.Order;
import org.nfshopservicedev.app.shop.order.service.OrderListRepo;
import org.nfshopservicedev.app.shop.product.model.Product;
import org.nfshopservicedev.app.shop.product.service.ProductRepo;
import org.nfshopservicedev.app.shop.service.ShopService;

import java.util.List;

public class Main {
    static void main() {
        var productRepo = new ProductRepo();
        productRepo.addProduct(new Product(1, "Laptop", 999.99));
        productRepo.addProduct(new Product(2, "Maus", 19.99));
        productRepo.addProduct(new Product(3, "Tastatur", 49.99));

        // Wähle zwischen OrderListRepo oder OrderMapRepo
//        var orderRepo = new OrderMapRepo();
        var orderRepo = new OrderListRepo();

        var shopService = new ShopService(productRepo, orderRepo);

        // Bestellung aufgeben
        var order1 = new Order(1, List.of(1, 2));
        shopService.placeOrder(order1);

        // Versuch, ungültige Bestellung aufzugeben
        var order2 = new Order(2, List.of(3, 4)); // Produkt 4 existiert nicht
        shopService.placeOrder(order2);
    }
}
