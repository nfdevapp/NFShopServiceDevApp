package org.nfshopservicedev.app.shop.service;

import org.nfshopservicedev.app.shop.order.model.Order;
import org.nfshopservicedev.app.shop.order.service.IOrderRepo;
import org.nfshopservicedev.app.shop.product.model.Product;
import org.nfshopservicedev.app.shop.product.service.ProductRepo;

import java.util.Map;

public class ShopService {
    private final ProductRepo productRepo;
    private final IOrderRepo iOrderRepo;

    public ShopService(ProductRepo productRepo, IOrderRepo iOrderRepo) {
        this.productRepo = productRepo;
        this.iOrderRepo = iOrderRepo;
    }

    public void placeOrder(String orderId, Map<String, Integer> productQuantities) {
        double total = 0.0;

        for (Map.Entry<String, Integer> entry : productQuantities.entrySet()) {
            Product p = productRepo.getProduct(entry.getKey());
            int qty = entry.getValue();

            if (p == null) {
                System.out.println("❌ Produkt nicht gefunden: ID " + entry.getKey());
                return;
            }

            if (p.stock() < qty) {
                System.out.println("⚠️ Nicht genug Lagerbestand für: " + p.name() + " = " + p.stock());
                return;
            }

            total += p.price() * qty;
        }

        // Bestände anpassen
        for (Map.Entry<String, Integer> entry : productQuantities.entrySet()) {
            Product p = productRepo.getProduct(entry.getKey());
            productRepo.updateStock(p.id(), p.stock() - entry.getValue());
        }
        // Bestellung speichern
        Order order = new Order(orderId, productQuantities, total);
        iOrderRepo.addOrder(order);
        System.out.println("✅ Bestellung erfolgreich mit Gesamtbetrag: €" + total);
    }
}
