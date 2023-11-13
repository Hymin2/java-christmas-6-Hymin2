package christmas.event;

import christmas.domain.Order;

public interface BadgeEvent extends Event {
    String getBadge(Order order);
}
