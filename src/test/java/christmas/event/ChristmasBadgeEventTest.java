package christmas.event;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.Order;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChristmasBadgeEventTest {
    private static ChristmasBadgeEvent christmasBadgeEvent;

    @BeforeAll
    static void setUp(){
        christmasBadgeEvent = new ChristmasBadgeEvent();
    }

    @Test
    @DisplayName("총혜택 금액이 5000원 미만일 때 미적용 테스트")
    void notApplyChristmasBadgeEventByLessThanMinBenefitTest(){
        Order order = new Order();
        order.saveBenefit("평일 할인", 3000);

        boolean isApply = christmasBadgeEvent.isApply(order);

        assertEquals(false, isApply);
    }

    @Test
    @DisplayName("총혜택 금액이 5000원 이상일 때 적용 테스트")
    void applyChristmasBadgeEventTest(){
        Order order = new Order();
        order.saveBenefit("평일 할인", 5000);

        boolean isApply = christmasBadgeEvent.isApply(order);

        assertEquals(true, isApply);
    }

    @Test
    @DisplayName("총혜택 금액이 20000원 이상일 때 산타 뱃지 테스트")
    void getSantaBadgeTest(){
        Order order = new Order();
        order.saveBenefit("평일 할인", 20000);

        String badge = christmasBadgeEvent.getBadge(order);

        assertEquals("산타", badge);
    }

    @Test
    @DisplayName("총혜택 금액이 10000원 이상일 때 트리 뱃지 테스트")
    void getTreeBadgeTest(){
        Order order = new Order();
        order.saveBenefit("평일 할인", 10000);

        String badge = christmasBadgeEvent.getBadge(order);

        assertEquals("트리", badge);
    }

    @Test
    @DisplayName("총혜택 금액이 5000원 이상일 때 별 뱃지 테스트")
    void getStarBadgeTest(){
        Order order = new Order();
        order.saveBenefit("평일 할인", 5000);

        String badge = christmasBadgeEvent.getBadge(order);

        assertEquals("별", badge);
    }
}