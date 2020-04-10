package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static domain.TableRepository.INVALID_TABLE_NUMBER_ERR_MSG;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TableRepositoryTest {

    @DisplayName("입력 받은 테이블 번호로 테이블 찾기 테스트")
    @Test
    void name() {
        int tableNumber = 1;
        Table actualTable = TableRepository.findTableByNumber(tableNumber);

        Table expected = new Table(1);

        assertThat(actualTable).isEqualTo(expected);
    }

    @DisplayName("예외 테스트: 입력 받은 번호의 테이블이 존재하지 않는 경우")
    @Test
    void name2() {
        int tableNumber = 50;
        assertThatThrownBy(() -> TableRepository.findTableByNumber(tableNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_TABLE_NUMBER_ERR_MSG);
    }
}
