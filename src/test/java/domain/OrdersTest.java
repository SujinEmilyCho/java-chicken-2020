package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class OrdersTest {

    @DisplayName("주문 내역이 있는지 확인하는 기능 테스트")
    @Test
    void name() {
        Orders orders = new Orders();
        boolean notOrdered = orders.hasOrders();
        assertThat(notOrdered).isFalse();

        orders.addOrder(1, 2);
        boolean ordered = orders.hasOrders();
        assertThat(ordered).isTrue();
    }
}
