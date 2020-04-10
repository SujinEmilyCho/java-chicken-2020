package domain.storeInfo;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static domain.storeInfo.MenuRepository.INVALID_MENU_ERR_MSG;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @DisplayName("예외 테스트: 입력 받은 번호의 메뉴가 존재하지 않는 경우")
    @Test
    void name2() {
        int menuNumber = 50;
        assertThatThrownBy(() -> MenuRepository.findMenuByNumber(menuNumber))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining(INVALID_MENU_ERR_MSG);
    }
}
