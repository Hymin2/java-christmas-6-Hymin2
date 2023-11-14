package christmas.event;

import static org.junit.jupiter.api.Assertions.*;

import christmas.config.MenuType;
import christmas.domain.Menu;
import christmas.domain.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class WeekDiscountEventTest {
    private static WeekDiscountEvent weekDiscountEvent;

    @BeforeAll
    static void setUp(){
        weekDiscountEvent = new WeekDiscountEvent();
    }

    @Test
    @DisplayName("총주문 금액이 10000원 미만일 때 미적용 테스트")
    void notApplyWeekDiscountEventByLessThanMinPriceTest(){
        Order order = new Order();
        order.saveMenu(new Menu("메뉴", MenuType.MAIN, 4000), 1);

        boolean isApply = weekDiscountEvent.isApply(order);

        assertEquals(false, isApply);
    }

    @Test
    @DisplayName("총주문 금액이 10000원 이상이고 평일이 아닌 경우 미적용 테스트")
    void notApplyWeekDiscountEventByNotWeekTest(){
        Order order = new Order();
        order.saveMenu(new Menu("메뉴", MenuType.MAIN, 10000), 1);
        order.saveDate(8);

        boolean isApply = weekDiscountEvent.isApply(order);

        assertEquals(false, isApply);
    }

    @Test
    @DisplayName("총주문 금액이 10000원 이상이고 평일인 경우 적용 테스트")
    void applyWeekDiscountEventTest(){
        Order order = new Order();
        order.saveMenu(new Menu("메뉴", MenuType.MAIN, 10000), 1);
        order.saveDate(4);

        boolean isApply = weekDiscountEvent.isApply(order);

        assertEquals(true, isApply);
    }

    @Test
    @DisplayName("디저트 메뉴가 2개일 경우 할인 테스트")
    void discountPriceTest(){
        Order order = new Order();
        order.saveMenu(new Menu("메뉴", MenuType.DESSERT, 10000), 2);
        order.saveDate(4);

        int discount = weekDiscountEvent.getDiscountAmount(order);

        assertEquals(4046, discount);
    }
}