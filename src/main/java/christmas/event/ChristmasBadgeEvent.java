package christmas.event;

import christmas.domain.Order;

public class ChristmasBadgeEvent implements BadgeEvent{
    @Override
    public String getBadge(Order order) {
        if(isApply(order)){
            int benefitPrice = Math.abs(order.getBenefitPrice());

            if(benefitPrice >= 20000){
                return "산타";
            } else if(benefitPrice >= 10000){
                return "트리";
            } else if(benefitPrice >= 5000){
                return "별";
            }
        }

        return null;
    }

    @Override
    public boolean isApply(Order order) {
        if(Math.abs(order.getBenefitPrice()) >= 5000){
            return true;
        }

        return false;
    }
}
