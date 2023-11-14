package christmas.event;

import christmas.domain.Order;

public class ChristmasBadgeEvent implements BadgeEvent{
    private final int minPriceCondition = 5000;
    private final int santaPriceCondition = 20000;
    private final int treePriceCondition = 10000;
    private final int starPriceCondition = 5000;

    private final String santaBadge = "산타";
    private final String treeBadge = "트리";
    private final String starBadge = "별";

    @Override
    public String getBadge(Order order) {
        if(isApply(order)){
            int benefitPrice = Math.abs(order.getBenefitPrice());

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
    public boolean isApply(Order order) {
        if(Math.abs(order.getBenefitPrice()) >= minPriceCondition){
            return true;
        }

        return false;
    }
}
