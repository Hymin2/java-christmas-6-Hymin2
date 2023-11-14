package christmas.event;

import christmas.config.DayOfWeek;
import christmas.domain.Order;
import christmas.util.DateCalculator;

public class SpecialDiscountEvent implements DiscountEvent{
    private final int minPriceCondition = 10000;
    private final int baseDiscountPrice = 1000;

    private final String eventName = "특별 할인";

    @Override
    public int getDiscountPrice(Order order) {
        if(isApply(order)){
            return -1 * baseDiscountPrice;
        }

        return 0;
    }

    @Override
    public boolean isApply(Order order) {
        if(order.getAllPrice() < minPriceCondition){
            return false;
        }

        if(order.getDate() != 25 && DateCalculator.calcDayOfWeek(order.getDate()) != DayOfWeek.SUNDAY){
            return false;
        }

        return true;
    }

    @Override
    public String toString(){
        return eventName;
    }
}
