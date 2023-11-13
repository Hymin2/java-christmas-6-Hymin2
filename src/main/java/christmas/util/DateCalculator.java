package christmas.util;

import christmas.config.DayOfWeek;

public class DateCalculator {
    private static final int year = 2023;
    private static final int month = 12;
    private static final int days = 31;
    private static final DayOfWeek firstDayOfWeek = DayOfWeek.FRIDAY;

    public static DayOfWeek calcDayOfWeek(int date){
        if(date > days){
            throw new IllegalArgumentException();
        }

        return DayOfWeek.getNowDayOfWeek(firstDayOfWeek, 1, date);
    }
}
