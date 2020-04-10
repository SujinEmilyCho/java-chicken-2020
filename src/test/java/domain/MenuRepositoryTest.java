package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class MenuRepositoryTest {

    @DisplayName("입력 받은 번호로 메뉴 찾기 테스트")
    @Test
    void name() {
        List<Menu> menus = MenuRepository.menus();
        int menuNumber = 1;
        Menu actual = MenuRepository.findMenuByNumber(menuNumber);

        Menu expected = menus.get(0);

        assertThat(actual).isEqualTo(expected);
    }
}
