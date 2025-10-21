package org.nfshopservicedev.app.shop.service;

import org.nfshopservicedev.app.shop.order.model.Order;
import org.nfshopservicedev.app.shop.order.service.IOrderRepo;
import org.nfshopservicedev.app.shop.product.service.ProductRepo;

public class ShopService {
    private ProductRepo productRepo;
    private IOrderRepo iOrderRepo;

    public ShopService(ProductRepo productRepo, IOrderRepo iOrderRepo) {
        this.productRepo = productRepo;
        this.iOrderRepo = iOrderRepo;
    }

    public void placeOrder(Order order) {
        boolean allExist = true;
        for (int productId : order.productIds()) {
            if (productRepo.getProduct(productId) == null) {
                System.out.println("Produkt mit ID " + productId + " existiert nicht.");
                allExist = false;
            }
        }

        if (allExist) {
            iOrderRepo.addOrder(order);
            System.out.println("Bestellung erfolgreich aufgegeben: " + order);
        } else {
            System.out.println("Bestellung konnte nicht aufgegeben werden.");
        }
    }
}
