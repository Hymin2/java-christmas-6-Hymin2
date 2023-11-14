package christmas.event;

import christmas.domain.Order;

public interface GiftEvent extends Event{
    String getGift(Order order);
    int getGiftAmount(Order order);
}
