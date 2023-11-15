package christmas.repository;

import christmas.domain.Menu;
import christmas.error.ErrorMessage;
import java.util.ArrayList;

public class MenuRepository {
    private static final ArrayList<Menu> menu = new ArrayList<>();

    public void save(Menu _menu){
        menu.add(_menu);
    }

    public boolean existMenuByName(String name){
        for(Menu m : menu){
            if(m.equals(name)) return true;
        }

        return false;
    }

    public Menu findMenuByName(String name){
        if(existMenuByName(name)) {
            for(Menu m : menu){
                if(m.equals(name)) return m;
            }
        }

        throw new IllegalArgumentException(ErrorMessage.NOT_EXIST_MENU_ORDER_ERROR_MESSAGE.getMessage());
    }

    public void clear(){
        menu.clear();
    }
}
