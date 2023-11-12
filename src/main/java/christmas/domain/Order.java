package christmas.domain;

import java.util.HashMap;
import java.util.Map;

public class Order {
    private Map<Menu, Integer> menu = new HashMap<>();

    public void save(Menu menu, Integer menuNumber){
        validate(menu);
        this.menu.put(menu, menuNumber);
    }

    private void validate(Menu menu){
        if(this.menu.containsKey(menu)){
            throw new IllegalArgumentException();
        }
    }
}
