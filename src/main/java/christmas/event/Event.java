package christmas.event;

import christmas.domain.Order;

public interface Event {
    boolean isApply(Order order);
}
