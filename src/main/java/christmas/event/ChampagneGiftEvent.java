package christmas.event;

import christmas.domain.Order;

public class ChampagneGiftEvent implements GiftEvent{
    @Override
    public boolean isApply(Order order) {
        if(order.getAllPrice() >= 120000){
            return true;
        }

        return false;
    }

    @Override
    public String getGift(Order order) {
        if(isApply(order)){
            return "샴페인 1개";
        }

        return null;
    }

    @Override
    public int getGiftPrice(Order order) {
        if(isApply(order)) {
            return -25000;
        }

        return 0;
    }

    @Override
    public String toString(){
        return "증정 이벤트";
    }
}
