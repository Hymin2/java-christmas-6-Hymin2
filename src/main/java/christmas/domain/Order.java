package christmas.domain;

public class Order {
    private Menu menu;
    private int menuNumber;

    public Order(Menu menu, int menuNumber) {
        this.menu = menu;
        this.menuNumber = menuNumber;
    }
}
