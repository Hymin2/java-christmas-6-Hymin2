package christmas.event;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Menu;
import christmas.domain.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekendDiscountEventTest {
    private static WeekendDiscountEvent weekendDiscountEvent;

    @BeforeAll
    static void setUp(){
        weekendDiscountEvent = new WeekendDiscountEvent();
    }

    @Test
    @DisplayName("총주문 금액이 10000원 미만일 때 미적용 테스트")
    void notApplyWeekendDiscountEventByLessThanMinPriceTest(){
        Order order = new Order();
        order.saveMenu(new Menu("메뉴", "메인", 4000), 1);

        boolean isApply = weekendDiscountEvent.isApply(order);

        assertEquals(false, isApply);
    }

    @Test
    @DisplayName("총주문 금액이 10000원 이상이고 주말이 아닌 경우 미적용 테스트")
    void notApplyWeekendDiscountEventByNotWeekTest(){
        Order order = new Order();
        order.saveMenu(new Menu("메뉴", "메인", 10000), 1);
        order.saveDate(4);

        boolean isApply = weekendDiscountEvent.isApply(order);

        assertEquals(false, isApply);
    }

    @Test
    @DisplayName("총주문 금액이 10000원 이상이고 주말인 경우 적용 테스트")
    void applyWeekendDiscountEventTest(){
        Order order = new Order();
        order.saveMenu(new Menu("메뉴", "메인", 10000), 1);
        order.saveDate(8);

        boolean isApply = weekendDiscountEvent.isApply(order);

        assertEquals(true, isApply);
    }

    @Test
    @DisplayName("메인 메뉴가 2개일 경우 할인 테스트")
    void discountPriceTest(){
        Order order = new Order();
        order.saveMenu(new Menu("메뉴", "메인", 10000), 2);
        order.saveDate(8);

        int discount = weekendDiscountEvent.getDiscountPrice(order);

        assertEquals(4046, discount);
    }
}