package christmas.event;

import static org.junit.jupiter.api.Assertions.*;

import christmas.domain.ApplyEvent;
import christmas.domain.Order;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ChristmasBadgeEventTest {
    private static ChristmasBadgeEvent christmasBadgeEvent;
    private static ApplyEvent applyEvent;

    @BeforeAll
    static void setUp(){
        christmasBadgeEvent = new ChristmasBadgeEvent();
        applyEvent = new ApplyEvent();
    }

    @AfterEach
    void clear(){
        applyEvent.clear();
    }

    @Test
    @DisplayName("총혜택 금액이 5000원 미만일 때 미적용 테스트")
    void notApplyChristmasBadgeEventByLessThanMinBenefitTest(){
        applyEvent.saveDiscountBenefit("평일 할인", 3000);

        boolean isApply = christmasBadgeEvent.isApply(applyEvent);

        assertEquals(false, isApply);
    }

    @Test
    @DisplayName("총혜택 금액이 5000원 이상일 때 적용 테스트")
    void applyChristmasBadgeEventTest(){
        applyEvent.saveDiscountBenefit("평일 할인", 5000);

        boolean isApply = christmasBadgeEvent.isApply(applyEvent);

        assertEquals(true, isApply);
    }

    @Test
    @DisplayName("총혜택 금액이 20000원 이상일 때 산타 뱃지 테스트")
    void getSantaBadgeTest(){
        applyEvent.saveDiscountBenefit("평일 할인", 20000);

        String badge = christmasBadgeEvent.getBadge(applyEvent);

        assertEquals("산타", badge);
    }

    @Test
    @DisplayName("총혜택 금액이 10000원 이상일 때 트리 뱃지 테스트")
    void getTreeBadgeTest(){
        applyEvent.saveDiscountBenefit("평일 할인", 10000);

        String badge = christmasBadgeEvent.getBadge(applyEvent);

        assertEquals("트리", badge);
    }

    @Test
    @DisplayName("총혜택 금액이 5000원 이상일 때 별 뱃지 테스트")
    void getStarBadgeTest(){
        applyEvent.saveDiscountBenefit("평일 할인", 5000);

        String badge = christmasBadgeEvent.getBadge(applyEvent);

        assertEquals("별", badge);
    }
}