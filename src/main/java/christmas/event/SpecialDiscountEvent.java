package christmas.event;

import christmas.config.DayOfWeek;
import christmas.domain.Order;
import christmas.util.DateCalculator;

public class SpecialDiscountEvent implements DiscountEvent{
    @Override
    public int getDiscountPrice(Order order) {
        if(isApply(order)){
            return 1000;
        }

        return 0;
    }

    @Override
    public boolean isApply(Order order) {
        if(order.getAllPrice() < 10000){
            return false;
        }

        if(order.getDate() != 25 && DateCalculator.calcDayOfWeek(order.getDate()) != DayOfWeek.SUNDAY){
            return false;
        }

        return true;
    }
}
