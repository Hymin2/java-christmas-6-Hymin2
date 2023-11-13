package christmas.event;

import christmas.config.DayOfWeek;
import christmas.domain.Order;
import christmas.util.DateCalculator;

public class WeekDiscountEvent implements DiscountEvent{
    @Override
    public int getDiscountPrice(Order order) {
        if(isApply(order)){
            return 2023 * order.getDessertCount();
        }

        return 0;
    }

    @Override
    public boolean isApply(Order order) {
        if(order.getAllPrice() < 10000){
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
}
