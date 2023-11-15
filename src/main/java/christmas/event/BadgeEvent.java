package christmas.event;

import christmas.domain.ApplyEvent;

public interface BadgeEvent {
    boolean isApply(ApplyEvent applyEvent);
    String getBadge(ApplyEvent applyEvent);

}
