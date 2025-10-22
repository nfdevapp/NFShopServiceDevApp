package org.nfshopservicedev.app.shop.order.service;
import org.nfshopservicedev.app.shop.order.model.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderListRepo implements IOrderRepo{
    private final List<Order> orders = new ArrayList<>();

    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public void removeOrder(String orderId) {
        orders.removeIf(o -> o.id().equals(orderId));
    }

    @Override
    public Order getOrder(String orderId) {
        return orders.stream()
                .filter(o -> o.id().equals(orderId))
                .findFirst()
                .orElse(null);
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }
}
