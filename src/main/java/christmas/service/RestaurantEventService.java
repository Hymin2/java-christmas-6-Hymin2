package christmas.service;

import christmas.domain.Menu;
import christmas.repository.MenuRepository;

public class RestaurantEventService {
    private final MenuRepository menuRepository;

    public RestaurantEventService(MenuRepository menuRepository) {
        this.menuRepository = menuRepository;

        this.saveMenu(new Menu("양송이수프", "에피타이저", 6000));
        this.saveMenu(new Menu("타파스", "에피타이저", 5500));
        this.saveMenu(new Menu("시저샐러드", "에피타이저", 8000));

        this.saveMenu(new Menu("티본스테이크", "메인", 55000));
        this.saveMenu(new Menu("바비큐립", "메인", 54000));
        this.saveMenu(new Menu("해산물파스타", "메인", 35000));
        this.saveMenu(new Menu("크리스마스파스타", "메인", 25000));

        this.saveMenu(new Menu("초코케이크", "디저트", 15000));
        this.saveMenu(new Menu("아이스크림", "디저트", 5000));

        this.saveMenu(new Menu("제로콜라", "음료", 3000));
        this.saveMenu(new Menu("레드와인", "음료", 60000));
        this.saveMenu(new Menu("샴페인", "음료", 25000));
    }

    public void saveMenu(Menu menu){
        menuRepository.save(menu);
    }

    public void saveVisitDay(int date) {

    }

    public void saveOrderMenu(String orderMenu) {

    }


}
