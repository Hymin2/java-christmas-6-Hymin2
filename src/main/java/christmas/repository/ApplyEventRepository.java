package christmas.repository;

import christmas.domain.ApplyEvent;

public class ApplyEventRepository {
    private static final ApplyEvent applyEvent = new ApplyEvent();

    public ApplyEvent getApplyEvent(){
        return applyEvent;
    }

    public void saveDiscountBenefit(String eventName, int benefitAmount){
        applyEvent.saveDiscountBenefit(eventName, benefitAmount);
    }

    public void saveGiftBenefit(String eventName, int benefitAmount){
        applyEvent.saveGiftBenefit(eventName, benefitAmount);
    }
}
