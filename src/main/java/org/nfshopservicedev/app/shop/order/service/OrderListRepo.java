package org.nfshopservicedev.app.shop.order.service;
import org.nfshopservicedev.app.shop.order.model.Order;
import java.util.ArrayList;
import java.util.List;

public class OrderListRepo implements IOrderRepo{
    private List<Order> orders = new ArrayList<>();

    @Override
    public void addOrder(Order order) {
        orders.add(order);
    }

    @Override
    public boolean removeOrder(int id) {
        for (int i = 0; i < orders.size(); i++) {
            if (orders.get(i).id() == id) {
                orders.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public Order getOrder(int id) {
        for (var order : orders) {
            if (order.id() == id) {
                return order;
            }
        }
        return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }
}
