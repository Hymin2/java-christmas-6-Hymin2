package christmas.event;

import christmas.config.DayOfWeek;
import christmas.domain.Order;
import christmas.util.DateCalculator;

public class WeekendDiscountEvent implements DiscountEvent{
    @Override
    public int getDiscountPrice(Order order) {
        if(isApply(order)){
            return 2023 * order.getMainMenuCount();
        }

        return 0;
    }

    @Override
    public boolean isApply(Order order) {
        if(order.getAllPrice() < 10000){
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
}
