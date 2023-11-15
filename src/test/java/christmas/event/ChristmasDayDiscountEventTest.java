package christmas.event;

import static org.junit.jupiter.api.Assertions.*;

import christmas.config.MenuType;
import christmas.domain.Menu;
import christmas.domain.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChristmasDayDiscountEventTest {
    private static ChristmasDayDiscountEvent christmasDayDiscountEvent;

    @BeforeAll
    static void setUp(){
        christmasDayDiscountEvent = new ChristmasDayDiscountEvent();
    }

    @Test
    @DisplayName("총주문 금액이 10000원 미만일 때 미적용 테스트")
    void notApplyChristmasDiscountEventByLessThanMinPriceTest(){
        Order order = new Order();
        order.saveMenu(new Menu("메뉴", MenuType.MAIN, 4000), 1);

        boolean isApply = christmasDayDiscountEvent.isApply(order);

        assertEquals(false, isApply);
    }

    @Test
    @DisplayName("총주문 금액이 10000원 이상이고 25일이 지난 경우 미적용 테스트")
    void notApplyWeekDiscountEventByPassingChristmasTest(){
        Order order = new Order();
        order.saveMenu(new Menu("메뉴", MenuType.MAIN, 10000), 1);
        order.saveDate(27);

        boolean isApply = christmasDayDiscountEvent.isApply(order);

        assertEquals(false, isApply);
    }

    @Test
    @DisplayName("총주문 금액이 10000원 이상이고 25일 이전인 경우 적용 테스트")
    void applyChristmasDiscountEventTest(){
        Order order = new Order();
        order.saveMenu(new Menu("메뉴", MenuType.MAIN, 10000), 1);
        order.saveDate(23);

        boolean isApply = christmasDayDiscountEvent.isApply(order);

        assertEquals(true, isApply);
    }

    @Test
    @DisplayName("크리스마스 디데이 할인 테스트")
    void discountPriceTest(){
        Order order = new Order();
        order.saveMenu(new Menu("메뉴", MenuType.DESSERT, 10000), 2);
        order.saveDate(22);

        int discount = christmasDayDiscountEvent.getDiscountAmount(order);

        assertEquals(-3100, discount);
    }
}