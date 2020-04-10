import domain.POS;
import domain.storeInfo.Menu;
import domain.storeInfo.MenuRepository;
import domain.storeInfo.Table;
import view.InputView;
import view.OutputView;

import java.util.List;

public class Application {
    private static final String INVALID_COMMAND_ERR_MSG = "입력한 번호에 해당하는 기능이 존재하지 않습니다.";
    private static final int END = 3;
    private static final int ORDER = 1;
    private static final int PAY = 2;

    public static void main(String[] args) {
        POS pos = new POS();

        int command;
        do {
            OutputView.printMain();
            command = InputView.inputCommandNumber();
            execute(pos, command);
        } while (command != END);
    }

    private static void execute(POS pos, int command) {
        switch (command) {
            case ORDER:
                order(pos);
                break;
            case PAY:
                pay(pos);
                break;
            case END:
                return;
            default:
                throw new IllegalArgumentException(INVALID_COMMAND_ERR_MSG);
        }
    }

    private static void order(POS pos) {
        final List<Table> tables = pos.tables();
        List<Boolean> orderStatus = pos.getOrderStatus();
        OutputView.printTables(tables, orderStatus);

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);

        final int menuNumber = InputView.inputMenuNumber();
        final int menuQuantity = InputView.inputQuantity();

        pos.addOrder(tableNumber, menuNumber, menuQuantity);
    }

    private static void pay(POS pos) {

    }
}
