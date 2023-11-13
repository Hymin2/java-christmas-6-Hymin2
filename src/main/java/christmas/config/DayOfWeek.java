package christmas.config;

import java.util.Arrays;

public enum DayOfWeek {
    SUNDAY(0), MONDAY(1), TUESDAY(2), WEDNESDAY(3), THURSDAY(4), FRIDAY(5), SATURDAY(6);

    private int dayOfWeek;

    DayOfWeek(int dayOfWeek){
        this.dayOfWeek = dayOfWeek;
    }

    public static DayOfWeek getNowDayOfWeek(DayOfWeek baseDayOfWeek, int baseDate, int nowDate){
        int diffDate = nowDate - baseDate;
        int nowDayOfWeek = (baseDayOfWeek.dayOfWeek + diffDate) % 7;

        return Arrays.stream(DayOfWeek.values())
                .filter((dayOfWeek) -> dayOfWeek.dayOfWeek == nowDayOfWeek)
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(""));
    }
}
