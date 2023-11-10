package christmas.repository;

import christmas.domain.Menu;
import java.util.ArrayList;

public class MenuRepository {
    private static ArrayList<Menu> menu;

    public void save(Menu menu){
        menu().add(menu);
    }

    public boolean existMenuByName(String name){
        return menu().contains(name);
    }

    private ArrayList<Menu> menu(){
        return MenuRepository.menu;
    }
}
