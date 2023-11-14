package christmas.event;

import christmas.domain.Order;

public class ChristmasDayDiscountEvent implements DiscountEvent{

    @Override
    public int getDiscountPrice(Order order) {
        if(isApply(order)){
            return -(1000 + 100 * (order.getDate() - 1));
        }

        return 0;
    }

    @Override
    public boolean isApply(Order order) {
        if (order.getAllPrice() < 10000){
            return false;
        }

        if(order.getDate() > 25){
            return false;
        }

        return true;
    }

    @Override
    public String toString(){
        return "크리스마스 디데이 할인";
    }
}
