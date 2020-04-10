package domain;

import domain.storeInfo.Table;
import domain.storeInfo.TableRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class POS {
    private static final int DISCOUNT_AMOUNT = 10000;
    private static final int TEN_CHICKEN = 10;
    private static final int CASH = 2;
    private static final double CASH_DISCOUNT_PERCENT = 0.95;
    private final Map<Table, Orders> tableOrders;

    public POS() {
        List<Table> tables = TableRepository.tables();
        tableOrders = tables.stream()
                .collect(Collectors.toMap(Function.identity(), table -> new Orders()));
    }

    public void addOrder(int tableNo, int menu, int quantity) {
        Table table = TableRepository.findTableByNumber(tableNo);
        Orders orders = tableOrders.get(table);
        orders.addOrder(menu, quantity);
    }

    public List<Boolean> getOrderStatus() {
        return tableOrders.keySet().stream()
                .sorted(Comparator.comparing(Table::getNumber))
                .map(tableOrders::get)
                .map(Orders::hasOrders)
                .collect(Collectors.toList());
    }

    public List<Table> tables() {
        return tableOrders.keySet().stream()
                .sorted(Comparator.comparing(Table::getNumber))
                .collect(Collectors.toList());
    }

    public double calculatePrice(int tableNo, int payMethod) {
        Table table = TableRepository.findTableByNumber(tableNo);
        Orders orders = tableOrders.get(table);

        int totalPrice = orders.totalPrice();

        totalPrice -= calculateChickenDiscount(orders);

        if (payMethod == CASH) {
            return totalPrice * CASH_DISCOUNT_PERCENT;
        }
        return totalPrice;
    }

    private int calculateChickenDiscount(Orders orders) {
        return orders.countChickens() / TEN_CHICKEN * DISCOUNT_AMOUNT;
    }

    public void pay(int tableNumber) {
        Table table = TableRepository.findTableByNumber(tableNumber);
        tableOrders.put(table, new Orders());
    }

    public Orders getOrders(int tableNo) {
        Table table = TableRepository.findTableByNumber(tableNo);
        return tableOrders.get(table);
    }
}
