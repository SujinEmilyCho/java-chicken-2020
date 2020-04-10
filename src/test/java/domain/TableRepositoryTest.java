package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class TableRepositoryTest {

    @DisplayName("입력 받은 테이블 번호로 테이블 찾기 테스트")
    @Test
    void name() {
        int tableNumber = 1;
        Table actualTable = TableRepository.findTableByNumber(tableNumber);

        Table expected = new Table(1);

        assertThat(actualTable).isEqualTo(expected);
    }
}
