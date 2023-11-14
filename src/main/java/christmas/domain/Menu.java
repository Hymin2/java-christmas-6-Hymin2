package christmas.domain;

import christmas.config.MenuType;
import java.util.Objects;

public class Menu {
    private String name;
    private MenuType type;
    private int amount;

    public Menu(String name, MenuType type, int amount){
        this.name = name;
        this.type = type;
        this.amount = amount;
    }

    public boolean equals(String name){
        return name.equals(this.name);
    }

    public MenuType getType(){
        return type;
    }

    public int getAmount(){
        return amount;
    }

    @Override
    public boolean equals(Object o){
        Menu menu = (Menu) o;

        boolean equalName = this.name.equals(menu.name);
        boolean equalType = this.type.equals(menu.type);
        boolean equalPrice = this.amount == menu.amount;

        return equalName && equalType && equalPrice;
    }

    @Override
    public int hashCode(){
        return Objects.hash(name, type, amount);
    }

    @Override
    public String toString(){
        return this.name;
    }
}
