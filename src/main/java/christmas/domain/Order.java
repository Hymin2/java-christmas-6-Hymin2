package christmas.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class Order {
    private Map<Menu, Integer> menu = new HashMap<>();

    public void save(Menu menu, Integer menuNumber){
        validate(menuNumber);
        validate(menu);
        this.menu.put(menu, menuNumber);
    }

    public void isAllDrink(){
        Set<String> typeSet = menu.keySet()
                .stream()
                .map(Menu::getType)
                .collect(Collectors.toSet());

        if(typeSet.contains("음료") && typeSet.size() == 1){
            throw new IllegalArgumentException();
        }
    }

    public int getAllPrice(){
        return menu.keySet()
                .stream()
                .mapToInt(Menu::getPrice)
                .sum();
    }

    public long getDessertCount(){
        return menu.keySet()
                .stream()
                .filter((menu) -> menu.getType().equals("디저트"))
                .count();
    }

    public long getMainMenuCount(){
        return menu.keySet()
                .stream()
                .filter((menu) -> menu.getType().equals("메인"))
                .count();
    }

    private void validate(Menu menu){
        if(this.menu.containsKey(menu)){
            throw new IllegalArgumentException();
        }
    }

    private void validate(Integer menuNumber){
        int menuSum = menuNumber;

        for(Integer number : menu.values()){
            menuSum += number;
        }

        if(menuSum > 20){
            throw new IllegalArgumentException();
        }
    }
}
