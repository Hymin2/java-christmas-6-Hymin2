package christmas.event;

public interface GiftEvent extends Event{
    String getGift();
    int getGiftPrice();
}
