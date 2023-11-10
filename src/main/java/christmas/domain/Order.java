package christmas.domain;

import java.util.ArrayList;

public class Order {
    private int month;
    private int day;
    private ArrayList<Menu> menus;

    public Order(int month, int day, ArrayList<Menu> menus) {
        this.month = month;
        this.day = day;
        this.menus = menus;
    }
}
