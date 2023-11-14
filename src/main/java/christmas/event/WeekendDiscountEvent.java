package christmas.event;

import christmas.config.DayOfWeek;
import christmas.domain.Order;
import christmas.util.DateCalculator;

public class WeekendDiscountEvent implements DiscountEvent{
    private final int minPriceCondition = 10000;
    private final int baseDiscountPrice = 2023;

    private final String eventName = "주말 할인";

    @Override
    public int getDiscountAmount(Order order) {
        if(isApply(order)){
            return -1 * baseDiscountPrice * order.getMainMenuCount();
        }

        return 0;
    }

    @Override
    public boolean isApply(Order order) {
        if(order.getAllAmount() < minPriceCondition){
            return false;
        }

        if(isNotWeekend(DateCalculator.calcDayOfWeek(order.getDate()))){
            return false;
        }

        return true;
    }

    private boolean isNotWeekend(DayOfWeek dayOfWeek){
        return  dayOfWeek.equals(DayOfWeek.SUNDAY)    ||
                dayOfWeek.equals(DayOfWeek.MONDAY)    ||
                dayOfWeek.equals(DayOfWeek.TUESDAY)   ||
                dayOfWeek.equals(DayOfWeek.WEDNESDAY) ||
                dayOfWeek.equals(DayOfWeek.THURSDAY);
    }

    @Override
    public String toString(){
        return eventName;
    }
}
