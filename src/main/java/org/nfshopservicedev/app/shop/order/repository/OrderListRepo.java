package org.nfshopservicedev.app.shop.order.repository;
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
        for (Order order : orders) {
            if (order.id().equals(orderId)) {
                orders.remove(order);
            }
        }
    }

    @Override
    public Order getOrder(String orderId) {
        for(Order o : orders){
            if(o.id().equals(orderId)){
                return o;
            }
        }
       return null;
    }

    @Override
    public List<Order> getAllOrders() {
        return new ArrayList<>(orders);
    }
}
