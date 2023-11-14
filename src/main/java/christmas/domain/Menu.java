package christmas.domain;

import christmas.config.MenuType;
import java.util.Objects;

public class Menu {
    private String name;
    private MenuType type;
    private int price;

    public Menu(String name, MenuType type, int price){
        this.name = name;
        this.type = type;
        this.price = price;
    }

    public boolean equals(String name){
        return name.equals(this.name);
    }

    public MenuType getType(){
        return type;
    }

    public int getPrice(){
        return price;
    }

    @Override
    public boolean equals(Object o){
        Menu menu = (Menu) o;

        boolean equalName = this.name.equals(menu.name);
        boolean equalType = this.type.equals(menu.type);
        boolean equalPrice = this.price == menu.price;

        return equalName && equalType && equalPrice;
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, type, price);
    }

    @Override
    public String toString(){
        return this.name;
    }
}
