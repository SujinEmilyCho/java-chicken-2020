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

    @DisplayName("전체 금액 계산 기능 테스트")
    @Test
    void name2() {
        Orders orders = new Orders();
        orders.addOrder(1, 2);      // 메뉴1: 후라이드 치킨 16000원
        orders.addOrder(2, 3);      //메뉴2: 양념 치킨 16000원

        int actual = orders.totalPrice();

        int expected = 16000 * 2 + 16000 * 3;

        assertThat(actual).isEqualTo(expected);
    }
}
