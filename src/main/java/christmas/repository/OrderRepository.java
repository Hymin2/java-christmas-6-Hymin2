package christmas.repository;

import christmas.domain.Menu;
import christmas.domain.Order;

public class OrderRepository {
    private static Order order = new Order();

    public void save(Menu menu, Integer menuNumber){
        order.save(menu, menuNumber);
    }

    public void isAllDrink(){
        order.isAllDrink();
    }

    public int getSumPrice(){
        return order.getAllPrice();
    }

    public int getDessertCount(){
        return order.getDessertCount();
    }

    public int getMainMenuCount(){
        return order.getMainMenuCount();
    }

    public void clear(){
        order.clear();
    }
}
