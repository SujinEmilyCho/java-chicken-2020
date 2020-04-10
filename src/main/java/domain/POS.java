package domain;

import domain.storeInfo.Table;
import domain.storeInfo.TableRepository;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class POS {
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
}
