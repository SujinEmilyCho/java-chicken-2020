package domain;

public class Bill {
    private String menu;
    private int quantity;
    private int price;

    public Bill(String menu, int quantity, int price) {
        this.menu = menu;
        this.quantity = quantity;
        this.price = price;
    }

    public String getMenu() {
        return menu;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getPrice() {
        return price;
    }
}
