package domain;

public class Order {
    private Menu menu;
    private int quantity;

    public Order(int menu, int quantity) {
        this.menu = MenuRepository.findMenuByNumber(menu);
        this.quantity = quantity;
    }
}
