package christmas.service;

import christmas.config.MenuType;
import christmas.domain.Menu;
import christmas.domain.Order;
import christmas.dto.OrderBenefitDto;
import christmas.dto.OrderMenuDto;
import christmas.event.BadgeEvent;
import christmas.event.ChampagneGiftEvent;
import christmas.event.ChristmasBadgeEvent;
import christmas.event.ChristmasDayDiscountEvent;
import christmas.event.DiscountEvent;
import christmas.event.GiftEvent;
import christmas.event.SpecialDiscountEvent;
import christmas.event.WeekDiscountEvent;
import christmas.event.WeekendDiscountEvent;
import christmas.repository.MenuRepository;
import christmas.repository.OrderRepository;
import java.util.List;
import org.mockito.internal.matchers.Or;

public class RestaurantEventService {
    private final MenuRepository menuRepository;
    private final OrderRepository orderRepository;

    public RestaurantEventService(MenuRepository menuRepository, OrderRepository orderRepository) {
        this.menuRepository = menuRepository;
        this.orderRepository = orderRepository;

        this.initMenu();
    }

    public void saveMenu(Menu menu){
        menuRepository.save(menu);
    }

    public void saveVisitDay(int date) {
        orderRepository.saveDate(date);
    }

    public void saveOrderMenu(String orderMenu){
        String[] orderMenus = orderMenu.split(",");

        for (String _orderMenu : orderMenus) {
            String[] nameAndNumber = _orderMenu.split("-");

            Menu menu = menuRepository.findMenuByName(nameAndNumber[0]);
            int menuNumber = Integer.parseInt(nameAndNumber[1]);

            orderRepository.saveMenu(menu, menuNumber);
        }
        orderRepository.getOrder().isAllDrink();

        applyDiscountEvent();
        applyGiftEvent();
    }

    public void applyDiscountEvent(){
        List<DiscountEvent> discountEvents = List.of(
                new ChristmasDayDiscountEvent(),
                new WeekDiscountEvent(),
                new WeekendDiscountEvent(),
                new SpecialDiscountEvent());

        Order order = orderRepository.getOrder();

        for(DiscountEvent discountEvent : discountEvents){
            if (discountEvent.isApply(order)){
                orderRepository.saveBenefit(discountEvent.toString(), discountEvent.getDiscountPrice(order));
            }
        }
    }

    public void applyGiftEvent(){
        GiftEvent giftEvent = new ChampagneGiftEvent();

        Order order = orderRepository.getOrder();

        if (giftEvent.isApply(order)){
            orderRepository.saveBenefit(giftEvent.toString(), giftEvent.getGiftPrice(order));
        }
    }

    public int getDiscountPrice(){
        List<DiscountEvent> discountEvents = List.of(
                new ChristmasDayDiscountEvent(),
                new WeekDiscountEvent(),
                new WeekendDiscountEvent(),
                new SpecialDiscountEvent());

        Order order = orderRepository.getOrder();

        int sumDiscountPrice = 0;

        for(DiscountEvent discountEvent : discountEvents){
            if (discountEvent.isApply(order)){
                sumDiscountPrice += discountEvent.getDiscountPrice(order);
            }
        }

        return sumDiscountPrice;
    }

    public String getGift(){
        GiftEvent giftEvent = new ChampagneGiftEvent();

        Order order = orderRepository.getOrder();

        if (giftEvent.isApply(order)){
            return giftEvent.getGift(order);
        }

        return "없음";
    }

    public String getBadge(){
        BadgeEvent badgeEvent = new ChristmasBadgeEvent();

        Order order = orderRepository.getOrder();

        if (badgeEvent.isApply(order)){
            return badgeEvent.getBadge(order);
        }

        return "없음";
    }

    public OrderMenuDto getMenu(){
        return new OrderMenuDto(orderRepository.getOrder().getMenu());
    }

    public OrderBenefitDto getBenefits(){
        return new OrderBenefitDto(orderRepository.getOrder().getBenefits());
    }

    public int getDate(){
        Order order = orderRepository.getOrder();

        return order.getDate();
    }

    public int getAllPrice(){
        Order order = orderRepository.getOrder();

        return order.getAllPrice();
    }

    public int getBenefitPrice(){
        Order order = orderRepository.getOrder();

        return order.getBenefitPrice();
    }

    public int getExpectPrice() {
        Order order = orderRepository.getOrder();

        return order.getAllPrice() + getDiscountPrice();
    }

    public void clearMenu(){
        menuRepository.clear();
    }

    public void clearOrder(){
        orderRepository.clear();
    }

    private void initMenu(){
        this.saveMenu(new Menu("양송이수프", MenuType.APPETIZER, 6000));
        this.saveMenu(new Menu("타파스", MenuType.APPETIZER, 5500));
        this.saveMenu(new Menu("시저샐러드", MenuType.APPETIZER, 8000));

        this.saveMenu(new Menu("티본스테이크", MenuType.MAIN, 55000));
        this.saveMenu(new Menu("바비큐립", MenuType.MAIN, 54000));
        this.saveMenu(new Menu("해산물파스타", MenuType.MAIN, 35000));
        this.saveMenu(new Menu("크리스마스파스타", MenuType.MAIN, 25000));

        this.saveMenu(new Menu("초코케이크", MenuType.DESSERT, 15000));
        this.saveMenu(new Menu("아이스크림", MenuType.DESSERT, 5000));

        this.saveMenu(new Menu("제로콜라", MenuType.DRINK, 3000));
        this.saveMenu(new Menu("레드와인", MenuType.DRINK, 60000));
        this.saveMenu(new Menu("샴페인", MenuType.DRINK, 25000));
    }
}
