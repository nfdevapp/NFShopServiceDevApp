package org.nfshopservicedev.app.shop.order.service;
import org.nfshopservicedev.app.shop.order.model.Order;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OrderMapRepo implements IOrderRepo{
    private Map<Integer, Order> orderMap = new HashMap<>();

    @Override
    public List<Order> getAllOrders() {
        List<Order> orders = new ArrayList<>();
        orders.addAll(orderMap.values());
        return orders;
    }

    @Override
    public void addOrder(Order order) {
        orderMap.put(order.id(), order);
    }

    @Override
    public boolean removeOrder(int id) {
        return orderMap.remove(id) != null;
    }

    @Override
    public Order getOrder(int id) {
        return orderMap.get(id);
    }
}
