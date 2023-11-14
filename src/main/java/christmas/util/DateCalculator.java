package christmas.util;

import christmas.config.DayOfWeek;
import christmas.config.EventConfig;
import christmas.error.ErrorMessage;

public class DateCalculator {
    private static final DayOfWeek firstDayOfWeek = DayOfWeek.FRIDAY;

    public static DayOfWeek calcDayOfWeek(int date){
        if(date > EventConfig.DAY_RANGE_MAX_VALUE.getValue()){
            throw new IllegalArgumentException(ErrorMessage.EXCEED_MAX_ORDER_NUMBER_ERROR_MESSAGE.getMessage());
        }

        if(date < EventConfig.DAY_RANGE_MIN_VALUE.getValue()){
            throw new IllegalArgumentException(ErrorMessage.LESS_MIN_ORDER_NUMBER_ERROR_MESSAGE.getMessage());
        }

        return DayOfWeek.getNowDayOfWeek(firstDayOfWeek, 1, date);
    }
}
