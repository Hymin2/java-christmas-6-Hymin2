package christmas.event;

import christmas.domain.Order;

public interface DiscountEvent extends Event{
    int getDiscountPrice(Order order);
}
