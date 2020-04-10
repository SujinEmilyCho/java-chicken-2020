package domain;

public class Order {
    static final String INVALID_QUANTITY_ERR_MSG = "한 메뉴는 최대 99개 까지 주문할 수 있습니다.";

    private Menu menu;
    private int quantity;

    public Order(int menu, int quantity) {
        this.menu = MenuRepository.findMenuByNumber(menu);
        if (quantity > 99) {
            throw new IllegalArgumentException(INVALID_QUANTITY_ERR_MSG);
        }
        this.quantity = quantity;
    }
}
