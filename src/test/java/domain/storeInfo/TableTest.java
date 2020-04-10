package domain.storeInfo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class TableTest {

    @DisplayName("입력된 테이블 번호와 일치하는지 확인 기능 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,false"})
    void name(int tableNumber, boolean expected) {
        Table table = new Table(1);

        boolean actual = table.is(tableNumber);

        assertThat(actual).isEqualTo(expected);
    }
}
