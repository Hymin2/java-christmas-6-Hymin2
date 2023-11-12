package christmas.domain;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class Order {
    private Map<Menu, Integer> menu = new HashMap<>();

    public void save(Menu menu, Integer menuNumber){
        validate(menuNumber);
        validate(menu);
        this.menu.put(menu, menuNumber);
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
