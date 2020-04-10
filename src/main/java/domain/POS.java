package domain;

import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class POS {
    private final Map<Table, Orders> orderStatus;

    public POS() {
        List<Table> tables = TableRepository.tables();
        orderStatus = tables.stream()
                .collect(Collectors.toMap(Function.identity(), table -> new Orders()));
    }

    public void addOrder(int table, int menu, int quantity) {
        Orders orders = orderStatus.get(table);
        orders.addOrder(menu, quantity);
    }
}
