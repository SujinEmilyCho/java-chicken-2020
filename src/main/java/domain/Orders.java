package domain;

import java.util.ArrayList;
import java.util.List;

public class Orders {
    private final List<Order> orders = new ArrayList<>();

    public void addOrder(int menu, int quantity) {
        orders.add(new Order(menu, quantity));
    }

    public boolean hasOrders() {
        return orders.size() != 0;
    }

    public int totalPrice() {
        return orders.stream()
                .mapToInt(Order::price)
                .sum();
    }
}
