package christmas.event;

import static org.junit.jupiter.api.Assertions.*;

import christmas.config.MenuType;
import christmas.domain.Menu;
import christmas.domain.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SpecialDiscountEventTest {
    private static SpecialDiscountEvent SpecialDiscountEvent;

    @BeforeAll
    static void setUp(){
        SpecialDiscountEvent = new SpecialDiscountEvent();
    }

    @Test
    @DisplayName("총주문 금액이 10000원 미만일 때 미적용 테스트")
    void notApplySpecialDiscountEventByLessThanMinPriceTest(){
        Order order = new Order();
        order.saveMenu(new Menu("메뉴", MenuType.MAIN, 4000), 1);

        boolean isApply = SpecialDiscountEvent.isApply(order);

        assertEquals(false, isApply);
    }

    @Test
    @DisplayName("총주문 금액이 10000원 이상이고 일요일이나 25일이 아닌 경우 미적용 테스트")
    void notApplySpecialDiscountEventByNotWeekTest(){
        Order order = new Order();
        order.saveMenu(new Menu("메뉴", MenuType.MAIN, 10000), 1);
        order.saveDate(6);

        boolean isApply = SpecialDiscountEvent.isApply(order);

        assertEquals(false, isApply);
    }

    @Test
    @DisplayName("총주문 금액이 10000원 이상이고 25일인 경우 적용 테스트")
    void applyChristmasSpecialDiscountEventTest(){
        Order order = new Order();
        order.saveMenu(new Menu("메뉴", MenuType.MAIN, 10000), 1);
        order.saveDate(25);

        boolean isApply = SpecialDiscountEvent.isApply(order);

        assertEquals(true, isApply);
    }

    @Test
    @DisplayName("총주문 금액이 10000원 이상이고 일요일인 경우 적용 테스트")
    void applySundaySpecialDiscountEventTest(){
        Order order = new Order();
        order.saveMenu(new Menu("메뉴", MenuType.MAIN, 10000), 1);
        order.saveDate(24);

        boolean isApply = SpecialDiscountEvent.isApply(order);

        assertEquals(true, isApply);
    }

    @Test
    @DisplayName("특별 할인 테스트")
    void discountPriceTest(){
        Order order = new Order();
        order.saveMenu(new Menu("메뉴", MenuType.DESSERT, 10000), 2);
        order.saveDate(10);

        int discount = SpecialDiscountEvent.getDiscountPrice(order);

        assertEquals(1000, discount);
    }
}