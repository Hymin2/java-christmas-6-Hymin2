package christmas.util;

import static org.junit.jupiter.api.Assertions.*;

import christmas.config.DayOfWeek;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class DateCalculatorTest {
    @Test
    @DisplayName("요일 계산 테스트")
    void calcDateTest(){
        DayOfWeek dayOfWeek = DateCalculator.calcDayOfWeek(13);

        assertEquals(DayOfWeek.WEDNESDAY, dayOfWeek);
    }
}