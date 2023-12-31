package christmas.event;

import christmas.domain.Order;

public class ChampagneGiftEvent implements GiftEvent{
    private final int minPriceCondition = 120000;
    private final int giftPrice = 25000;

    private final String giftName = "샴페인 1개";
    private final String eventName = "증정 이벤트";

    @Override
    public boolean isApply(Order order) {
        if(order.getAllAmount() >= minPriceCondition){
            return true;
        }

        return false;
    }

    @Override
    public String getGift(Order order) {
        if(isApply(order)){
            return giftName;
        }

        return null;
    }

    @Override
    public int getGiftAmount(Order order) {
        if(isApply(order)) {
            return -1 * giftPrice;
        }

        return 0;
    }

    @Override
    public String toString(){
        return eventName;
    }
}
