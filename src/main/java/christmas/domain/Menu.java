package christmas.domain;

import christmas.config.MenuType;
import java.util.Objects;

public class Menu {
    private final String name;
    private final MenuType type;
    private final Integer amount;

    public Menu(String name, MenuType type, Integer amount){
        this.name = name;
        this.type = type;
        this.amount = amount;
    }

    public boolean equals(String name){
        return name.equals(this.name);
    }

    public boolean isMain(){
        return type.equals(MenuType.MAIN);
    }

    public boolean isDessert(){
        return type.equals(MenuType.DESSERT);
    }

    public boolean isDrink(){
        return type.equals(MenuType.DRINK);
    }

    public int getAmount(){
        return amount;
    }

    @Override
    public boolean equals(Object o){
        Menu menu = (Menu) o;

        boolean equalName = this.name.equals(menu.name);
        boolean equalType = this.type.equals(menu.type);
        boolean equalPrice = this.amount.equals(menu.amount);

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
