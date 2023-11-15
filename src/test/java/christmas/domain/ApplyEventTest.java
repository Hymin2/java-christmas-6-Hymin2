package christmas.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplyEventTest {
    private static ApplyEvent applyEvent;

    @BeforeAll
    static void setUp(){
        applyEvent = new ApplyEvent();

        applyEvent.saveDiscountBenefit("평일 할인", 4046);
        applyEvent.saveDiscountBenefit("특별 할인", 1000);

        applyEvent.saveGiftBenefit("증정 이벤트", 25000);
        applyEvent.saveGift("샴페인 1개");
    }

    @Test
    @DisplayName("할인 금액 테스트")
    void discountAmountTest(){
        int discountAmount = applyEvent.getDiscountAmount();

        assertEquals(5046, discountAmount);
    }

    @Test
    @DisplayName("총혜택 금액 테스트")
    void totalBenefitAmountTest(){
        int totalBenefitAmount = applyEvent.getTotalBenefitAmount();

        assertEquals(30046, totalBenefitAmount);
    }

    @Test
    @DisplayName("총혜택 내역 테스트")
    void allBenefitTest(){
        Map<String, Integer> allBenefits = applyEvent.getAllBenefits();

        boolean b1 = allBenefits.containsKey("평일 할인");
        boolean b2 = allBenefits.containsKey("특별 할인");
        boolean b3 = allBenefits.containsKey("증정 이벤트");

        assertEquals(3, allBenefits.size());

        assertEquals(true, b1);
        assertEquals(true, b1);
        assertEquals(true, b1);
    }

    @Test
    @DisplayName("증정 메뉴 테스트")
    void giftMenuTest(){
        List<String> gifts = applyEvent.getGift();

        boolean b = gifts.contains("샴페인 1개");

        assertEquals(1, gifts.size());
        assertEquals(true, b);
    }
}