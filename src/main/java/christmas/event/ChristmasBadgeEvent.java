package christmas.event;

import christmas.domain.Order;

public class ChristmasBadgeEvent implements BadgeEvent{
    @Override
    public String getBadge(Order order) {
        if(isApply(order)){
            if(order.getBenefitPrice() >= 20000){
                return "산타";
            } else if(order.getBenefitPrice() >= 10000){
                return "트리";
            } else if(order.getBenefitPrice() >= 5000){
                return "별";
            }
        }

        return null;
    }

    @Override
    public boolean isApply(Order order) {
        if(order.getBenefitPrice() >= 5000){
            return true;
        }

        return false;
    }
}
