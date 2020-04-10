package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class MenuTest {

    @DisplayName("입력한 메뉴 번호와 일치하는 메뉴인지 확인하는 기능 테스트")
    @ParameterizedTest
    @CsvSource(value = {"1,true", "2,false"})
    void name(int menuNumber, boolean expected) {
        Menu menu = new Menu(1, "후라이드", Category.CHICKEN, 16_000);

        boolean actual = menu.is(menuNumber);

        assertThat(actual).isEqualTo(expected);
    }
}
