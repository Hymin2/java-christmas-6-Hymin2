package christmas.event;

import christmas.domain.ApplyEvent;

public class ChristmasBadgeEvent implements BadgeEvent{
    private final int minPriceCondition = 5000;
    private final int santaPriceCondition = 20000;
    private final int treePriceCondition = 10000;
    private final int starPriceCondition = 5000;

    private final String santaBadge = "산타";
    private final String treeBadge = "트리";
    private final String starBadge = "별";

    @Override
    public String getBadge(ApplyEvent applyEvent) {
        if(isApply(applyEvent)){
            int benefitPrice = Math.abs(applyEvent.getAllBenefitAmount());

            if(benefitPrice >= santaPriceCondition){
                return santaBadge;
            } else if(benefitPrice >= treePriceCondition){
                return treeBadge;
            } else if(benefitPrice >= starPriceCondition){
                return starBadge;
            }
        }

        return null;
    }

    @Override
    public boolean isApply(ApplyEvent applyEvent) {
        if(Math.abs(applyEvent.getAllBenefitAmount()) >= minPriceCondition){
            return true;
        }

        return false;
    }

}
