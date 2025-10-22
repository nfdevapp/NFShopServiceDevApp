package org.nfshopservicedev.app.shop.order.service;
import org.nfshopservicedev.app.shop.order.model.Order;
import java.util.List;

public interface IOrderRepo {
    void addOrder(Order order);
    void removeOrder(String orderId);
    Order getOrder(String id);
    List<Order> getAllOrders();

}
