package domain.storeInfo;

import java.util.Objects;

import static domain.storeInfo.Category.CHICKEN;

public class Menu {
    private final int number;
    private final String name;
    private final Category category;
    private final int price;

    public Menu(final int number, final String name, final Category category, final int price) {
        this.number = number;
        this.name = name;
        this.category = category;
        this.price = price;
    }

    public boolean is(int menuNumber) {
        return this.number == menuNumber;
    }

    public boolean isChicken() {
        return this.category == CHICKEN;
    }

    public int getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return category + " " + number + " - " + name + " : " + price + "원";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Menu menu = (Menu) o;
        return number == menu.number &&
                price == menu.price &&
                Objects.equals(name, menu.name) &&
                category == menu.category;
    }

    @Override
    public int hashCode() {
        return Objects.hash(number, name, category, price);
    }
}
