package christmas.repository;

import christmas.domain.Menu;
import java.util.ArrayList;

public class MenuRepository {
    private static ArrayList<Menu> menu;

    public void save(Menu _menu){
        menu.add(_menu);
    }

    public boolean existMenuByName(String name){
        return menu.contains(name);
    }

    public Menu findMenuByName(String name){
        if(existMenuByName(name)) {
            return menu.get(menu.indexOf(name));
        }

        throw new IllegalArgumentException();
    }
}
