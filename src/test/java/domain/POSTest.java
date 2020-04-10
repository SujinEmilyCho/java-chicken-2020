package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class POSTest {

    @DisplayName("주문 등록된 테이블 확인 테스트")
    @Test
    void name() {
        POS pos = new POS();
        pos.addOrder(1, 1, 1);
        List<Boolean> actual = pos.getOrderStatus();
        List<Boolean> expected = Arrays.asList(true, false, false, false, false, false);
        assertThat(actual).isEqualTo(expected);
    }
}
