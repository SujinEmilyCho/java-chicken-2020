package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static domain.Order.INVALID_QUANTITY_ERR_MSG;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class OrderTest {
    @DisplayName("예외 테스트: 최대 주문 갯수를 초과하는 경우")
    @Test
    void name() {
        assertThatThrownBy(() -> new Order(1, 100))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_QUANTITY_ERR_MSG);
    }

    @DisplayName("가격 확인하는 기능 테스트")
    @Test
    void name2() {
        Order order = new Order(1, 2);  // 메뉴1: 후라이드 치킨 16000원
        int price = order.price();
        assertThat(price).isEqualTo(16000 * 2);
    }



}
