package org.nfshopservicedev.app.shop.order.service;
import org.nfshopservicedev.app.shop.order.model.Order;
import java.util.List;

public interface IOrderRepo {
    void addOrder(Order order);
    boolean removeOrder(int id);
    Order getOrder(int id);
    List<Order> getAllOrders();

}
