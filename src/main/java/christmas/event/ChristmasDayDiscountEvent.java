package christmas.event;

import christmas.domain.Order;

public class ChristmasDayDiscountEvent implements DiscountEvent{
    private final int minPriceCondition = 10000;
    private final int baseDiscountPrice = 1000;
    private final int extraDiscountPrice = 100;

    private final String eventName = "크리스마스 디데이 할인";


    @Override
    public int getDiscountPrice(Order order) {
        if(isApply(order)){
            return -1 * (baseDiscountPrice + extraDiscountPrice * (order.getDate() - 1));
        }

        return 0;
    }

    @Override
    public boolean isApply(Order order) {
        if (order.getAllPrice() < minPriceCondition){
            return false;
        }

        if(order.getDate() > 25){
            return false;
        }

        return true;
    }

    @Override
    public String toString(){
        return eventName;
    }
}
