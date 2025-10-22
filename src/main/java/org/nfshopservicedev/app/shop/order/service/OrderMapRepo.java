package org.nfshopservicedev.app.shop.order.service;
import org.nfshopservicedev.app.shop.order.model.Order;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderMapRepo implements IOrderRepo{
    private final Map<String, Order> orderMap = new HashMap<>();

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>(orderMap.values());
        return orders;
    }

    @Override
    public void addOrder(Order order) {
        orderMap.put(order.id(), order);
    }

    @Override
    public void removeOrder(String orderId) {
        orderMap.remove(orderId);
    }

    @Override
    public Order getOrder(String orderId) {
        return orderMap.get(orderId);
    }
}
