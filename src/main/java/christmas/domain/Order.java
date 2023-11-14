package christmas.domain;

import christmas.config.EventConfig;
import christmas.config.MenuType;
import christmas.error.ErrorMessage;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Order {
    private Integer date;
    private Map<String, Integer> benefits = new HashMap<>();
    private Map<Menu, Integer> menu = new HashMap<>();

    public void saveMenu(Menu menu, Integer menuNumber){
        validate(menuNumber);
        validate(menu);

        this.menu.put(menu, menuNumber);
    }

    public void saveDate(int date){
        this.date = date;
    }

    public void saveBenefit(String eventName, int benefitPrice){
        this.benefits.put(eventName, benefitPrice);
    }

    public void isAllDrink(){
        Set<MenuType> typeSet = menu.keySet()
                .stream()
                .map(Menu::getType)
                .collect(Collectors.toSet());

        if(typeSet.contains(MenuType.DRINK) && typeSet.size() == 1){
            throw new IllegalArgumentException(ErrorMessage.ORDER_MENU_IS_ONLY_DRINK_ERROR_MESSAGE.getMessage());
        }
    }

    public int getAllPrice(){
        int sum = 0;

        for(Menu m : menu.keySet()){
            sum += m.getPrice() * menu.get(m);
        }

        return sum;
    }

    public int getDessertCount(){
        int sum = 0;

        for(Menu m : menu.keySet()){
            if(m.getType().equals(MenuType.DESSERT)) {
                sum += menu.get(m);
            }
        }

        return sum;
    }

    public int getMainMenuCount(){
        int sum = 0;

        for(Menu m : menu.keySet()){
            if(m.getType().equals(MenuType.MAIN)) {
                sum += menu.get(m);
            }
        }

        return sum;
    }

    public Integer getDate(){
        return date;
    }

    public Map<String, Integer> getBenefits(){
        return benefits;
    }

    public Map<Menu, Integer> getMenu() {
        return menu;
    }

    public Integer getBenefitPrice(){
        return benefits.values()
                .stream()
                .reduce(0, (a, b) -> a + b);
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
