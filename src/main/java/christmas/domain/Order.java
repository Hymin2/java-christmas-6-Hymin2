package christmas.domain;

import christmas.config.EventConfig;
import christmas.error.ErrorMessage;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class Order {
    private Integer date;
    private final Map<Menu, Integer> menu = new HashMap<>();

    public void saveMenu(Menu menu, Integer menuNumber){
        validate(menuNumber);
        validate(menu);

        this.menu.put(menu, menuNumber);
    }

    public void saveDate(int date){
        this.date = date;
    }

    public void isAllDrink(){
        int drinkCount = (int) menu.keySet()
                .stream()
                .filter(Menu::isDrink)
                .count();

        if(drinkCount == menu.size()){
            throw new IllegalArgumentException(ErrorMessage.ORDER_MENU_IS_ONLY_DRINK_ERROR_MESSAGE.getMessage());
        }
    }

    public int getAllAmount(){
        int sum = 0;

        for(Menu m : menu.keySet()){
            sum += m.getAmount() * menu.get(m);
        }

        return sum;
    }

    public int getDessertCount(){
        int sum = 0;

        for(Menu m : menu.keySet()){
            if(m.isDessert()) {
                sum += menu.get(m);
            }
        }

        return sum;
    }

    public int getMainMenuCount(){
        int sum = 0;

        for(Menu m : menu.keySet()){
            if(m.isMain()) {
                sum += menu.get(m);
            }
        }

        return sum;
    }

    public int getDate(){
        return date;
    }

    public Map<Menu, Integer> getMenu() {
        return Collections.unmodifiableMap(menu);
    }

    public void clear(){
        menu.clear();
    }

    private void validate(Menu menu){
        if(this.menu.containsKey(menu)){
            clear();
            throw new IllegalArgumentException(ErrorMessage.DUPLICATION_ORDER_ERROR_MESSAGE.getMessage());
        }
    }

    private void validate(Integer menuNumber){
        if(menuNumber < EventConfig.MENU_NUMBER_MIN_VALUE.getValue()){
            clear();
            throw new IllegalArgumentException(ErrorMessage.LESS_MIN_ORDER_NUMBER_ERROR_MESSAGE.getMessage());
        }

        int menuSum = menu.values().stream()
                .reduce(menuNumber, (a, b) -> a + b);

        if(menuSum > EventConfig.MENU_NUMBER_MAX_VALUE.getValue()){
            clear();
            throw new IllegalArgumentException(ErrorMessage.EXCEED_MAX_ORDER_NUMBER_ERROR_MESSAGE.getMessage());
        }
    }
}
