package christmas.event;

import static org.junit.jupiter.api.Assertions.*;

import christmas.config.MenuType;
import christmas.domain.Menu;
import christmas.domain.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChampagneGiftEventTest {
    private static ChampagneGiftEvent champagneGiftEvent;

    @BeforeAll
    static void setUp(){
        champagneGiftEvent = new ChampagneGiftEvent();
    }

    @Test
    @DisplayName("총주문 금액이 120000원 미만일 때 미적용 테스트")
    void notApplyChampagneGiftEventByLessThanMinPriceTest(){
        Order order = new Order();
        order.saveMenu(new Menu("메뉴", MenuType.MAIN, 10000), 1);

        boolean isApply = champagneGiftEvent.isApply(order);

        assertEquals(false, isApply);
    }

    @Test
    @DisplayName("총주문 금액이 120000원 이상일 때 적용 테스트")
    void applyChampagneGiftEventTest(){
        Order order = new Order();
        order.saveMenu(new Menu("메뉴", MenuType.MAIN, 120000), 1);

        boolean isApply = champagneGiftEvent.isApply(order);

        assertEquals(true, isApply);
    }

    @Test
    @DisplayName("샴페인 가격 테스트")
    void champagnePriceTest(){
        Order order = new Order();
        order.saveMenu(new Menu("메뉴", MenuType.DESSERT, 120000), 2);

        int discount = champagneGiftEvent.getGiftPrice(order);

        assertEquals(25000, discount);
    }
}