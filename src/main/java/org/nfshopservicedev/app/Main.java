package org.nfshopservicedev.app;
import org.nfshopservicedev.app.shop.order.repository.OrderListRepo;
import org.nfshopservicedev.app.shop.product.model.Product;
import org.nfshopservicedev.app.shop.product.repository.ProductRepo;
import org.nfshopservicedev.app.shop.service.ShopService;

import java.util.*;

public class Main {
    static void main() {
        var scanner = new Scanner(System.in);
        var productRepo = new ProductRepo();
        var orderListRepo = new OrderListRepo();
//        var orderMapRepo = new OrderMapRepo(); // oder OrderMapRepo
        var shopService = new ShopService(productRepo, orderListRepo);

        productRepo.addProduct(new Product("112", "Kaffee", 3.5, 20));
        productRepo.addProduct(new Product("123", "Tee", 2.0, 15));

        while (true) {
            System.out.println("\n🔵 Menü: [1] Produkte [2] Bestellung [3] Alle Bestellungen [0] Beenden");
            String choice = scanner.nextLine();

            switch (choice) {
                case "1" -> {
                    System.out.println("🟢 Produkte:");
                    for (Product p : productRepo.getAllProducts()) {
                        System.out.println(p.id() + ": " + p.name() + " (€" + p.price() + ") - Lager: " + p.stock());
                    }
                }
                case "2" -> {
                    Map<String, Integer> bestellung = new HashMap<>();
                    while (true) {
                        System.out.println("Produkt-ID (oder 'fertig' eingeben):");
                        String pid = scanner.nextLine();
                        if (pid.equals("fertig")) break;

                        System.out.println("Menge:");
                        int qty = Integer.parseInt(scanner.nextLine());
                        bestellung.put(pid, qty);
                    }
                    String orderId = UUID.randomUUID().toString();
                    shopService.placeOrder(orderId, bestellung);
                }
                case "3" -> {
                    System.out.println("📦 Bestellungen:");
                    for (var order : orderListRepo.getAllOrders()) {
                        System.out.println(order.id() + " - Summe: €" + order.totalSum());
                    }
                }
                case "0" -> {
                    System.out.println("👋 Auf Wiedersehen!");
                    return;
                }
                default -> System.out.println("❓ Ungültige Eingabe.");
            }
        }
    }
}
