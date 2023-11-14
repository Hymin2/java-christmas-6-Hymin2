package christmas.event;

import christmas.config.DayOfWeek;
import christmas.domain.Order;
import christmas.util.DateCalculator;

public class WeekDiscountEvent implements DiscountEvent{
    private final int minPriceCondition = 10000;
    private final int baseDiscountPrice = 2023;

    private final String eventName = "평일 할인";

    @Override
    public int getDiscountAmount(Order order) {
        if(isApply(order)){
            return -1 * baseDiscountPrice * order.getDessertCount();
        }

        return 0;
    }

    @Override
    public boolean isApply(Order order) {
        if(order.getAllAmount() < minPriceCondition){
            return false;
        }

        if(isNotWeek(DateCalculator.calcDayOfWeek(order.getDate()))){
            return false;
        }

        return true;
    }

    private boolean isNotWeek(DayOfWeek dayOfWeek){
        return  dayOfWeek.equals(DayOfWeek.FRIDAY) ||
                dayOfWeek.equals(DayOfWeek.SATURDAY);
    }

    @Override
    public String toString(){
        return eventName;
    }
}
