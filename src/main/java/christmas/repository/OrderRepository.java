package christmas.repository;

import christmas.domain.Menu;
import christmas.domain.Order;

public class OrderRepository {
    private static final Order order = new Order();

    public void saveMenu(Menu menu, Integer menuNumber){
        order.saveMenu(menu, menuNumber);
    }

    public void saveDate(int date){
        order.saveDate(date);
    }

    public Order getOrder(){
        return order;
    }

    public void clear(){
        order.clear();
    }
}
